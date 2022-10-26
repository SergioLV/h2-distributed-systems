package com.gremio.salesconsumer.dao;

import com.gremio.salesconsumer.dao.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockJpaRepository extends JpaRepository<StockEntity, Long> {
    @Modifying
    @Query(value = "UPDATE stocks SET cart_id = :cartId, remaining_stock = :remainingStock WHERE cart_id = :cartId", nativeQuery = true)
    void updateStock(@Param("cartId") int cartId, @Param("remainingStock") int remainingStock);
}
