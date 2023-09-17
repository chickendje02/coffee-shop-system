package com.trungnguyen.processorder.repository;

import com.trungnguyen.processorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
