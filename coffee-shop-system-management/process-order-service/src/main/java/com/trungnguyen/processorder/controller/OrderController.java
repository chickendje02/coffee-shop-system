package com.trungnguyen.processorder.controller;

import com.trungnguyen.processorder.model.OrderUpdateModel;
import com.trungnguyen.processorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<Map<String,Object>> createOrder(@RequestBody OrderUpdateModel model) {
        return ResponseEntity.ok(orderService.createOrder(model));
    }
}
