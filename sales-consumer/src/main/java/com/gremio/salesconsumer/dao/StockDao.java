package com.gremio.salesconsumer.dao;

import com.gremio.salesconsumer.business.Constants;
import com.gremio.salesconsumer.dao.entity.SaleEntity;
import com.gremio.salesconsumer.dao.entity.StockEntity;
import com.gremio.salesconsumer.exceptions.DatabaseException;
import com.gremio.salesconsumer.model.Sale;
import com.gremio.salesconsumer.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class StockDao {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(StockDao.class);

    @Autowired
    private StockJpaRepository stockJpaRepository;

    @Transactional
    public void save(Stock stock) throws DatabaseException {
        try {
            StockEntity stockEntity = new StockEntity(stock);
            stockJpaRepository.updateStock(stockEntity.getCartId(), stockEntity.getRemainingStock());
            LOGGER.info("New Remaining Stock Added to the Database!");
        }catch (Exception e){
            throw new DatabaseException(Constants.PROBLEM_STOCK_TABLE, e);
        }
    }

}
