package com.trungnguyen.coffeeshopservice.entity;



import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "menu")
public class Menu extends BaseEntity{

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

}
