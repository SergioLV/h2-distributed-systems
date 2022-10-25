package com.gremio.receiver.dao;

import com.gremio.receiver.dao.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleJpaRepository extends JpaRepository<SaleEntity, Long> {
}
