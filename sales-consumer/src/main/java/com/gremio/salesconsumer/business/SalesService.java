package com.gremio.salesconsumer.business;

import com.gremio.salesconsumer.dao.SaleDAO;
import com.gremio.salesconsumer.exceptions.DatabaseException;
import com.gremio.salesconsumer.model.Sale;
import com.gremio.salesconsumer.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    @Autowired
    private SaleDAO saleDAO;

    @Autowired
    private StockService stockService;

    public void save(Sale sale) throws DatabaseException {
        Stock stock = new Stock(sale.getCartId(), sale.getRemainingStock());
        stockService.save(stock);
        saleDAO.save(sale);
    }
}
