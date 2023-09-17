package com.trungnguyen.customer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "customer_token")
public class CustomerToken extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "device")
    private String device;

    @Column(name = "token")
    private String token;

    @Column(name = "active")
    private Boolean active;

}
