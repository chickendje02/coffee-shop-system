package com.trungnguyen.coffeeshop.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_by")
    private String createdBy = "system";

    @Column(name = "created_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "updated_by")
    private String updatedBy = "system";

    @Column(name = "updated_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedDate = LocalDateTime.now();
}
