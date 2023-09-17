package com.trungnguyen.processorder.service.impl;

import com.trungnguyen.processorder.constant.HandlerUtils;
import com.trungnguyen.processorder.entity.*;
import com.trungnguyen.processorder.eumeration.OrderStatus;
import com.trungnguyen.processorder.exception.CommonBusinessException;
import com.trungnguyen.processorder.model.OrderDetailUpdateModel;
import com.trungnguyen.processorder.model.OrderSuccessMessage;
import com.trungnguyen.processorder.model.OrderUpdateModel;
import com.trungnguyen.processorder.producer.ProcessOrderProducer;
import com.trungnguyen.processorder.repository.OrderDetailRepository;
import com.trungnguyen.processorder.repository.OrderRepository;
import com.trungnguyen.processorder.repository.QueueOrderRepository;
import com.trungnguyen.processorder.repository.QueueRepository;
import com.trungnguyen.processorder.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    QueueRepository queueRepository;

    @Autowired
    QueueOrderRepository queueOrderRepository;

    @Autowired
    ProcessOrderProducer producer;

    @Autowired
    OrderLogServiceImpl orderLogService;

    @Override
    @Transactional
    public Map<String, Object> createOrder(OrderUpdateModel model) {
        OrderCustomer order = model.convertToOrderEntity(OrderStatus.WAITING);
        OrderCustomer orderSaved = orderRepository.save(order);
        var orderSavedTask = CompletableFuture.runAsync(() -> saveOrder(model.getListDetails(), orderSaved.getId()));
        var addToQueueTask = CompletableFuture.runAsync(() -> saveQueueOrder(orderSaved, model.getCoffeeShopId()));
        CompletableFuture.runAsync(() -> notifyCustomerAndAdmin(orderSaved, model.getCoffeeShopId()));
        CompletableFuture.runAsync(() -> insertLog(orderSaved, model.getCoffeeShopId()));
        try {
            CompletableFuture.allOf(orderSavedTask, addToQueueTask).get();
            Map<String, Object> result = new HashMap<>();
            return HandlerUtils.buildSuccessMapResponse(result);
        } catch (Exception e) {
            log.debug("Failed to handle saved Task {}", e.getMessage());
            throw new CommonBusinessException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    private void saveOrder(List<OrderDetailUpdateModel> list, int orderId) {
        List<OrderDetail> listEntity = list.stream().map(item -> item.convertToOrderDetail(orderId)).collect(Collectors.toList());
        orderDetailRepository.saveAll(listEntity);
    }

    private void saveQueueOrder(OrderCustomer orderSaved, int coffeeShopId) {
        Queue queues = queueRepository.findAvailableQueueByCoffeeShopId(coffeeShopId);
        Optional<Queue> queueWithLeastOrder = queueRepository.findQueueOrderWithTheLeastWaiting(coffeeShopId);
        Optional<QueueOrder> theLastPositionOfQueue = queueOrderRepository.findQueueWithTheLeastWaiting(coffeeShopId);
        int currentPosition = theLastPositionOfQueue.isPresent() ? theLastPositionOfQueue.get().getCurrentPosition() : 0;
        int queueId = queueWithLeastOrder.isPresent() ? queueWithLeastOrder.get().getId() : queues.getId();
        QueueOrder queueOrder = new QueueOrder();
        queueOrder.setQueueId(queueId);
        queueOrder.setOrderId(orderSaved.getId());
        queueOrder.setCurrentPosition(currentPosition + 1);
        queueOrderRepository.save(queueOrder);
    }

    private void notifyCustomerAndAdmin(OrderCustomer orderSaved, int coffeeShopId) {
        OrderSuccessMessage orderSuccessMessage = OrderSuccessMessage.builder()
                .customerId(orderSaved.getCustomerId())
                .coffeeShopId(coffeeShopId)
                .build();
        producer.sendMessage(orderSuccessMessage, "order-success-topic");
    }

    private void insertLog(OrderCustomer orderSaved, int coffeeShopId) {
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderId(orderSaved.getId());
        orderLog.setStatus(orderSaved.getStatus());
        orderLog.setCoffeeShopId(coffeeShopId);
        orderLog.setLogBy(orderSaved.getUpdatedBy());
        orderLogService.insertLog(orderLog);
    }
}
