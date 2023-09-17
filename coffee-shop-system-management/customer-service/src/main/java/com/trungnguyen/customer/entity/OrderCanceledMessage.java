package com.trungnguyen.customer.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderCanceledMessage {

    private int coffeeShopId;

    private int customerId;
}
