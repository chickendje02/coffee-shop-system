package com.trungnguyen.processorder.model;

import lombok.Data;

@Data
public class OrderCanceledMessage {

    private int coffeeShopId;

    private int customerId;
}
