package com.trungnguyen.processorder.model;


import com.trungnguyen.processorder.entity.OrderDetail;
import lombok.Data;

@Data
public class OrderDetailUpdateModel {

    private int menuShopId;

    private int quantity;

    public OrderDetail convertToOrderDetail(int orderId) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setQuantity(this.getQuantity());
        orderDetail.setMenuShopId(this.getMenuShopId());
        return orderDetail;
    }
}
