package com.trungnguyen.processorder.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "queue")
public class Queue extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "coffee_shop_id")
    private Integer coffeeShopId;
}
