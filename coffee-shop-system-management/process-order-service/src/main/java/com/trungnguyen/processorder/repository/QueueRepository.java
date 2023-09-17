package com.trungnguyen.processorder.repository;

import com.trungnguyen.processorder.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QueueRepository extends JpaRepository<Queue, Integer> {

    List<Queue> findAllByCoffeeShopId(int coffeeShopId);


    @Query(
            nativeQuery = true,
            value = "select * from queue t1 where t1.coffee_shop_id =:coffeeShopId limit 1 "
    )
    Queue findAvailableQueueByCoffeeShopId(@Param("coffeeShopId") int coffeeShopId);


    @Query(
            nativeQuery = true,
            value = "select t2.* from queue t2 " +
                    "LEFT JOIN queue_order t3 ON t2.id = t3.queue_id " +
                    "WHERE t2.coffee_shop_id =:coffeeShopId AND (t3.current_position > 0 OR t3.queue_id is null) " +
                    "GROUP BY t2.id " +
                    "ORDER BY COUNT(t2.*) ASC " +
                    "LIMIT 1 "
    )
    Optional<Queue> findQueueOrderWithTheLeastWaiting(@Param("coffeeShopId") int coffeeShopId);

}
