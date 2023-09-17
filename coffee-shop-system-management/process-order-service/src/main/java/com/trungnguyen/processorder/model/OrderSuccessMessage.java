package com.trungnguyen.processorder.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderSuccessMessage {

    private int expectedWaitingMinTime;

    private int expectedWaitingMaxTime;

    private int coffeeShopId;

    private int customerId;

}
