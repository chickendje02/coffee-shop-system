package com.trungnguyen.processorder.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "queue")
public class QueueOrder extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "queue_order_id")
    private Integer id;

    @Column(name = "queue_id")
    private Integer queueId;

    @Column(name = "order_id")
    private Integer orderid;

    @Column(name = "current_position")
    private Integer currentPosition;
}
