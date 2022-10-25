package com.gremio.receiver.dao;

import com.gremio.receiver.business.Constants;
import com.gremio.receiver.exceptions.DatabaseException;
import com.gremio.receiver.model.Sale;
import com.gremio.receiver.dao.entity.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SaleDAO {
    @Autowired
    private SaleJpaRepository saleJpaRepository;

    public int save(Sale sale) throws DatabaseException {
        try{
            SaleEntity saleEntity = new SaleEntity(sale);
            saleJpaRepository.save(saleEntity);
            return saleEntity.getCartId();
        }catch (Exception e){
            throw new DatabaseException(Constants.PROBLEM_SALES_TABLE, e);
        }
    }
}
