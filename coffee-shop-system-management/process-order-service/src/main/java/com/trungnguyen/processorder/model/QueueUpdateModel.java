package com.trungnguyen.processorder.model;

import com.trungnguyen.processorder.eumeration.OrderAction;
import com.trungnguyen.processorder.eumeration.OrderStatus;
import lombok.Data;

@Data
public class QueueUpdateModel {

    private Integer orderId;

    private Integer queueId;

    private Integer coffeeShopId;

    private Integer customerId;

    private OrderStatus status;

    private OrderAction action;

}
