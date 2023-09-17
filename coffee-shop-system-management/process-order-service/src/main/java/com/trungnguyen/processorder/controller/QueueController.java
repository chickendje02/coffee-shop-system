package com.trungnguyen.processorder.controller;

import com.trungnguyen.processorder.entity.Queue;
import com.trungnguyen.processorder.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/queue")
public class QueueController {

    @Autowired
    QueueService queueService;

    @GetMapping
    public ResponseEntity<List<Queue>> getListQueueByCoffeeShopId(@RequestParam int coffeeShopId) {
        return ResponseEntity.ok(queueService.findByCoffeeShopId(coffeeShopId));
    }
}
