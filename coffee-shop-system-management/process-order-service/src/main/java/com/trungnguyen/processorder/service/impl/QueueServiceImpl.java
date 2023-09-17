package com.trungnguyen.processorder.service.impl;


import com.trungnguyen.processorder.entity.Queue;
import com.trungnguyen.processorder.repository.QueueRepository;
import com.trungnguyen.processorder.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    QueueRepository queueRepository;

    @Override
    public List<Queue> findByCoffeeShopId(int coffeeShopId) {
        return queueRepository.findAllByCoffeeShopId(coffeeShopId);
    }
}
