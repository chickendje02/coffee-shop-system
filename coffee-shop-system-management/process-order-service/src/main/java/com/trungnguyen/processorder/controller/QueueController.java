package com.trungnguyen.processorder.controller;

import com.trungnguyen.processorder.entity.Queue;
import com.trungnguyen.processorder.model.QueueUpdateModel;
import com.trungnguyen.processorder.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/queue")
public class QueueController {

    @Autowired
    QueueService queueService;

    @GetMapping
    public ResponseEntity<List<Queue>> getListQueueByCoffeeShopId(@RequestParam int coffeeShopId) {
        return ResponseEntity.ok(queueService.findByCoffeeShopId(coffeeShopId));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> updateQueue(@RequestBody QueueUpdateModel model) {
        return ResponseEntity.ok(queueService.updateQueue(model));
    }
}
