package com.trungnguyen.processorder.controller;

import com.trungnguyen.processorder.model.OrderUpdateModel;
import com.trungnguyen.processorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity createOrder(@RequestBody OrderUpdateModel model) {
        orderService.createOrder(model);
        return ResponseEntity.ok("Ok");
    }
}
