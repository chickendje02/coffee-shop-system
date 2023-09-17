package com.trungnguyen.processorder.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "queue_order")
public class QueueOrder extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator="queue_order_sequence")
    @SequenceGenerator(name = "queue_order_sequence", sequenceName = "queue_order_seq", initialValue = 1, allocationSize=1)
    @Column(name = "queue_order_id")
    private Integer id;

    @Column(name = "queue_id")
    private Integer queueId;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "current_position")
    private Integer currentPosition;
}
