package com.trungnguyen.processorder.service;

import com.trungnguyen.processorder.model.OrderUpdateModel;

import java.util.Map;

public interface OrderService {

    Map<String, Object> createOrder(OrderUpdateModel model);

}
