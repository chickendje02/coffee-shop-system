package com.trungnguyen.coffeeshop.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "menu", schema = "coffee_shop_management")
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

}
