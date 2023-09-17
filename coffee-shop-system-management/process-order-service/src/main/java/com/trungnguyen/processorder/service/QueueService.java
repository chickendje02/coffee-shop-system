package com.trungnguyen.processorder.service;

import com.trungnguyen.processorder.entity.Queue;
import com.trungnguyen.processorder.entity.QueueOrder;
import com.trungnguyen.processorder.model.QueueUpdateModel;

import java.util.List;
import java.util.Map;

public interface QueueService {

    List<Queue> findByCoffeeShopId(int coffeeShopId);

    Map<String, Object> updateQueue(QueueUpdateModel model);
}
