package com.gremio.salesconsumer.business;

import com.gremio.salesconsumer.dao.SaleDAO;
import com.gremio.salesconsumer.dao.StockDao;
import com.gremio.salesconsumer.exceptions.DatabaseException;
import com.gremio.salesconsumer.model.Sale;
import com.gremio.salesconsumer.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    private StockDao stockDao;

    public void save(Stock stock) throws DatabaseException {;
        stockDao.save(stock);
    }
}
