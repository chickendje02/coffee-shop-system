package com.trungnguyen.processorder.repository;

import com.trungnguyen.processorder.entity.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<OrderCustomer, Integer> {

    @Modifying // to declare no need return from db
    @Query(
            nativeQuery = true,
            value = "UPDATE order_customer t1  SET status =:status  where t1.id =:orderCustomerId"
    )
    void updateStatusOrder(@Param("orderCustomerId") int orderCustomerId,@Param("status") String status);
}
