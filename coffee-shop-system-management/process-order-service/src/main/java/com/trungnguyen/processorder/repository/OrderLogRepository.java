package com.trungnguyen.processorder.repository;

import com.trungnguyen.processorder.entity.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLogRepository extends JpaRepository<OrderLog, Integer> {
}
