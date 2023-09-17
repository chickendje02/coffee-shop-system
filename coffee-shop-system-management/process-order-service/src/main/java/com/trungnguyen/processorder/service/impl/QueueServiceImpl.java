package com.trungnguyen.processorder.service.impl;


import com.trungnguyen.processorder.constant.HandlerUtils;
import com.trungnguyen.processorder.entity.OrderLog;
import com.trungnguyen.processorder.entity.Queue;
import com.trungnguyen.processorder.entity.QueueOrder;
import com.trungnguyen.processorder.eumeration.OrderAction;
import com.trungnguyen.processorder.eumeration.OrderStatus;
import com.trungnguyen.processorder.model.OrderCanceledMessage;
import com.trungnguyen.processorder.model.QueueUpdateModel;
import com.trungnguyen.processorder.producer.ProcessOrderProducer;
import com.trungnguyen.processorder.repository.OrderRepository;
import com.trungnguyen.processorder.repository.QueueOrderRepository;
import com.trungnguyen.processorder.repository.QueueRepository;
import com.trungnguyen.processorder.service.OrderLogService;
import com.trungnguyen.processorder.service.QueueService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
public class QueueServiceImpl implements QueueService {

    @Autowired
    QueueRepository queueRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderLogService orderLogService;

    @Autowired
    QueueOrderRepository queueOrderRepository;

    @Autowired
    ProcessOrderProducer producer;

    @Override
    public List<Queue> findByCoffeeShopId(int coffeeShopId) {
        return queueRepository.findAllByCoffeeShopId(coffeeShopId);
    }

    @Override
    @Transactional
    public Map<String, Object> updateQueue(QueueUpdateModel model) {
        handleChangeStatusOrder(model);
        insertOrderLog(model);
        if (model.getAction().equals(OrderAction.CANCELED_BY_SHOP) || model.getAction().equals(OrderAction.CANCELED_BY_CUSTOMER)) {
            CompletableFuture.runAsync(() -> notifyCancel(model));
        }
        Map<String, Object> result = new HashMap<>();
        return HandlerUtils.buildSuccessMapResponse(result);
    }

    private void handleChangeStatusOrder(QueueUpdateModel model) {
        orderRepository.updateStatusOrder(model.getOrderId(), model.getStatus().name());
        if (model.getStatus().equals(OrderStatus.DONE)
                || model.getAction().equals(OrderAction.CANCELED_BY_SHOP)
                || model.getAction().equals(OrderAction.CANCELED_BY_CUSTOMER)) {
            handleUpdatePositionOfQueue(model);
        }
    }

    private void handleUpdatePositionOfQueue(QueueUpdateModel model) {
        Optional<QueueOrder> queueOrder = queueOrderRepository.findByQueueIdAndOrderId(model.getQueueId(), model.getOrderId());
        int currentPositionOfUpdatedQueue = queueOrder.isPresent() ? queueOrder.get().getCurrentPosition() : 0;
        queueOrderRepository.updateQueueOfOrderDone(model.getQueueId(), model.getOrderId());
        queueOrderRepository.updateQueuePosition(model.getQueueId(), currentPositionOfUpdatedQueue);
    }

    private void insertOrderLog(QueueUpdateModel model) {
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderId(model.getOrderId());
        orderLog.setStatus(model.getStatus().name());
        orderLog.setCoffeeShopId(model.getCoffeeShopId());
        orderLog.setLogBy(String.valueOf(model.getCoffeeShopId()));
        orderLogService.insertLog(orderLog);
    }

    private void notifyCancel(QueueUpdateModel model) {
        OrderCanceledMessage message = new OrderCanceledMessage();
        message.setCustomerId(model.getCustomerId());
        message.setCoffeeShopId(model.getCoffeeShopId());
        producer.sendMessage(message, "order-cancel-topic");
    }
}
