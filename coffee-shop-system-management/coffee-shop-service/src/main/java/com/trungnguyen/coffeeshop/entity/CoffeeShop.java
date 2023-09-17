package com.trungnguyen.coffeeshopservice.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "coffee_shop")
public class CoffeeShop extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String location;

    @Column(name = "contact_detail")
    private String contact_detail;

    @Column(name = "number_of_queue")
    private Integer number_of_queue;

    @Column(name = "open_time")
    private Integer open_time;

    @Column(name = "close_time")
    private Integer close_time;

    @ManyToMany
    @JoinTable(
    name = "menu_shop",
    joinColumns = @JoinColumn(name = "coffee_shop_id"),
    inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private List<Menu> listMenu;

}
