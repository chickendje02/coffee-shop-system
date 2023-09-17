package com.trungnguyen.processorder.service;

import com.trungnguyen.processorder.entity.Queue;

import java.util.List;

public interface QueueService {

    List<Queue> findByCoffeeShopId(int coffeeShopId);
}
