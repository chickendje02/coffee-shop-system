package com.trungnguyen.coffeeshop.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderCanceledMessage {

    private int coffeeShopId;

    private int customerId;
}
