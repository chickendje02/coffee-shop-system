package com.trungnguyen.processorder.entity;

import com.trungnguyen.processorder.eumeration.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "order")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_full_name")
    private String customerFullName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "status")
    private OrderStatus status;
}
