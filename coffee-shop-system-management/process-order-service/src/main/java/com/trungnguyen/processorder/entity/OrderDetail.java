package com.trungnguyen.processorder.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "order_detail")
public class OrderDetail extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_detail_id")
    private int orderDetailId;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "menu_shop_id")
    private int menuShopId;


    @Column(name = "quantity")
    private Integer quantity;
}
