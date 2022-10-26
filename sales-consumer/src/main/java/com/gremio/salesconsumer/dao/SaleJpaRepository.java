package com.gremio.salesconsumer.dao;

import com.gremio.salesconsumer.dao.entity.SaleEntity;
import com.gremio.salesconsumer.dto.TotalSalesDto;
import com.gremio.salesconsumer.model.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleJpaRepository extends JpaRepository<SaleEntity, Long> {

    @Query(value = "SELECT COUNT(DISTINCT client_name), cart_id FROM sales as s GROUP BY cart_id", nativeQuery = true)
    List<Integer> getDailyCustomers();
    @Query(value = "select cart_id, count(id) from sales group by cart_id", nativeQuery = true)
    List<Integer> getDailySales();

    @Query(value = "select cart_id, avg(amount) from sales group by cart_id", nativeQuery = true)
    List<Integer> getAvgAmount();
}
