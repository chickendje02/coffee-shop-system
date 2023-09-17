package com.trungnguyen.processorder.service.impl;

import com.trungnguyen.processorder.entity.Order;
import com.trungnguyen.processorder.entity.OrderDetail;
import com.trungnguyen.processorder.entity.Queue;
import com.trungnguyen.processorder.entity.QueueOrder;
import com.trungnguyen.processorder.eumeration.OrderStatus;
import com.trungnguyen.processorder.exception.CommonBusinessException;
import com.trungnguyen.processorder.model.OrderDetailUpdateModel;
import com.trungnguyen.processorder.model.OrderUpdateModel;
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
import java.util.List;
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

    @Override
    @Transactional
    public void createOrder(OrderUpdateModel model) {
        Order order = model.convertToOrderEntity(OrderStatus.WAITING);
        Order orderSaved = orderRepository.save(order);
        var orderSavedTask = CompletableFuture.runAsync(() -> saveOrder(model.getListDetails(), orderSaved.getId()));
        var addToQueueTask = CompletableFuture.runAsync(() -> saveQueue(orderSaved, model.getCoffeeShopId()));
        try {
            CompletableFuture.allOf(orderSavedTask, addToQueueTask).get();
        } catch (Exception e) {
            log.error("Failed to handle saved Task {}", e.getMessage());
            throw new CommonBusinessException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    private void saveOrder(List<OrderDetailUpdateModel> list, int orderId) {
        List<OrderDetail> listEntity = list.stream().map(item -> item.convertToOrderDetail(orderId)).collect(Collectors.toList());
        orderDetailRepository.saveAll(listEntity);
    }

    private void saveQueue(Order orderSaved, int coffeeShopId) {
        Queue queues = queueRepository.findAvailableQueueByCoffeeShopId(coffeeShopId);
        int currentPosition = queueOrderRepository.findLastQueue(queues.getId()).getCurrentPosition();
        QueueOrder queueOrder = new QueueOrder();
        queueOrder.setQueueId(queues.getId());
        queueOrder.setOrderid(orderSaved.getId());
        queueOrder.setCurrentPosition(currentPosition + 1);
        queueOrderRepository.save(queueOrder);
    }
}
