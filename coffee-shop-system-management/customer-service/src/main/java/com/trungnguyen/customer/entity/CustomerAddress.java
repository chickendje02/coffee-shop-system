package com.trungnguyen.customer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "customer_address")
public class CustomerAddress extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "home_or_office")
    private String homeOrOffice;

    @Column(name = "address")
    private String address;

}
