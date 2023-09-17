package com.trungnguyen.processorder.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_log")
public class OrderLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator="order_log_sequence")
    @SequenceGenerator(name = "order_log_sequence", sequenceName = "order_log_seq", initialValue = 1, allocationSize=1)
    private int id;

    @Column(name="order_id")
    private int orderId;

    @Column(name="coffee_shop_id")
    private int coffeeShopId;

    @Column(name="status")
    private String status;

    @Column(name="log_by")
    private String logBy;

}
