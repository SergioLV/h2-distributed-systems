package com.gremio.salesconsumer.dao;
import com.gremio.salesconsumer.business.Constants;
import com.gremio.salesconsumer.dao.entity.SaleEntity;
import com.gremio.salesconsumer.dto.TotalSalesDto;
import com.gremio.salesconsumer.exceptions.DatabaseException;
import com.gremio.salesconsumer.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleDAO {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SaleDAO.class);

    @Autowired
    private SaleJpaRepository saleJpaRepository;

    public void save(Sale sale) throws DatabaseException {
        try {
            SaleEntity saleEntity = new SaleEntity(sale);
            saleJpaRepository.save(saleEntity);
            List<Integer> s = saleJpaRepository.getDailySales();
            LOGGER.info("New Sale Added to the Database!");
        }catch (Exception e){
            throw new DatabaseException(Constants.PROBLEM_SALES_TABLE, e);
        }
    }


}
