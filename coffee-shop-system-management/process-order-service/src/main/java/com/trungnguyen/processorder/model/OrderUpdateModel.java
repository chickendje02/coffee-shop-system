package com.trungnguyen.processorder.model;


import com.trungnguyen.processorder.entity.OrderCustomer;
import com.trungnguyen.processorder.eumeration.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderUpdateModel {

    private Integer customerId;

    private Integer coffeeShopId;

    private String customerFullName;

    private String customerPhoneNumber;

    private String customerAddress;

    private BigDecimal totalPrice;

    List<OrderDetailUpdateModel> listDetails;


    public OrderCustomer convertToOrderEntity(OrderStatus status) {
        OrderCustomer order = new OrderCustomer();
        order.setCustomerId(this.getCustomerId());
        order.setCustomerFullName(this.getCustomerFullName());
        order.setCustomerAddress(this.getCustomerAddress());
        order.setTotalPrice(this.getTotalPrice());
        order.setStatus(status.name());
        order.setUpdatedBy(this.getCustomerFullName());
        return order;
    }

}
