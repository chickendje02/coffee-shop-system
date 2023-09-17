package com.trungnguyen.customer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="customer_id", referencedColumnName="id"),
    })
    List<CustomerAddress> addresses;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="customer_id", referencedColumnName="id"),
    })
    List<CustomerToken> tokens;
}
