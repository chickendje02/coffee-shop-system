package com.trungnguyen.processorder.repository;

import com.trungnguyen.processorder.entity.Queue;
import com.trungnguyen.processorder.entity.QueueOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QueueOrderRepository extends JpaRepository<QueueOrder, Integer> {

    @Query(
            value = "SELECT " +
                    " * " +
                    "FROM queue_order t1 " +
                    "WHERE t1.queue_id =:queueId " +
                    "ORDER BY t1.current_position DESC " +
                    "LIMIT 1",
            nativeQuery = true
    )
    QueueOrder findLastQueue(@Param("queueId") int queueId);
}
