package com.trungnguyen.processorder.repository;

import com.trungnguyen.processorder.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QueueRepository extends JpaRepository<Queue, Integer> {

    List<Queue> findAllByCoffeeShopId(int coffeeShopId);


    @Query(
            value = "SELECT " +
                    " * " +
                    "FROM queue t1 " +
                    "WHERE t1.coffee_shop_id =:coffeeShopId " +
                    "LIMIT 1",
            nativeQuery = true
    )
    Queue findAvailableQueueByCoffeeShopId(@Param("coffeeShopId") int coffeeShopId);
}
