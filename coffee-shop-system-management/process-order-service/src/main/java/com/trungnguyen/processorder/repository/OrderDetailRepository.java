package com.trungnguyen.processorder.repository;

import com.trungnguyen.processorder.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
