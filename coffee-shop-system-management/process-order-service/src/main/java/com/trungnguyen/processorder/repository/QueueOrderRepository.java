package com.trungnguyen.processorder.repository;

import com.trungnguyen.processorder.entity.QueueOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface QueueOrderRepository extends JpaRepository<QueueOrder, Integer> {

    @Query(
//            value = "SELECT " +
//                    " * " +
//                    "FROM queue_order t1 " +
//                    "WHERE t1.queue_id =:queueId " +
//                    "ORDER BY t1.current_position DESC " +
//                    "LIMIT 1",
            value = "SELECT " +
                    " * " +
                    "FROM queue_order t1 " +
                    "WHERE t1.queue_id = ( select t2.id from queue t2 LEFT JOIN queue_order t3 ON t2.id = t3.queue_id " +
                                            "WHERE t2.coffee_shop_id =:coffeeShopId AND (t3.current_position > 0 OR t3.queue_id is null) " +
                                            "GROUP BY t2.id " +
                                            "ORDER BY COUNT(t2.*) ASC " +
                                            "LIMIT 1 ) " +
                    "ORDER BY t1.current_position DESC " +
                    "LIMIT 1",
            nativeQuery = true
    )
    Optional<QueueOrder> findQueueWithTheLeastWaiting(@Param("coffeeShopId") int coffeeShopId);

    @Query(
            value = "SELECT " +
                    " * " +
                    "FROM queue_order t1 " +
                    "WHERE t1.queue_id =:queueId " +
                    "ORDER BY t1.current_position DESC " +
                    "LIMIT 1",
            nativeQuery = true
    )
    Optional<QueueOrder> findLastQueue(@Param("queueId") int queueId);


    @Modifying // to declare no need return from db
    @Query(
            nativeQuery = true,
            value = "UPDATE queue_order t1  SET current_position = 0  where t1.queue_id =:queueId and t1.order_id =:orderId"
    )
    void updateQueueOfOrderDone(@Param("queueId") int queueId, @Param("orderId") int orderId);


    @Modifying // to declare no need return from db
    @Query(
            nativeQuery = true,
            value = "UPDATE queue_order t1  SET current_position = current_position - 1  where t1.queue_id =:queueId and t1.current_position > :updatedPosition"
    )
    void updateQueuePosition(@Param("queueId") int queueId, @Param("updatedPosition") int updatedPosition);

    Optional<QueueOrder> findByQueueIdAndOrderId(int queueId, int updatedPosition);
}
