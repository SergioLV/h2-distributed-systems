package com.gremio.receiver.dao;

import com.gremio.receiver.business.Constants;
import com.gremio.receiver.dao.entity.SaleEntity;
import com.gremio.receiver.exceptions.DatabaseException;
import com.gremio.receiver.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleDAO {

    @Autowired
    SaleJpaRepository saleJpaRepository;

    public void save(Sale sale) throws  DatabaseException{
        try {
            SaleEntity saleEntity = new SaleEntity(sale);
            saleJpaRepository.save(saleEntity);
        }catch (Exception e){
            throw new DatabaseException(Constants.PROBLEM_SALES_TABLE, e);
        }
    }
}
