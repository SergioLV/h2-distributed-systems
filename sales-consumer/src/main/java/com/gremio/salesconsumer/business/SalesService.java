package com.gremio.salesconsumer.business;

import com.gremio.salesconsumer.dao.SaleDAO;
import com.gremio.salesconsumer.exceptions.DatabaseException;
import com.gremio.salesconsumer.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    @Autowired
    private SaleDAO saleDAO;

    public void save(Sale sale) throws DatabaseException {
        saleDAO.save(sale);
    }
}
