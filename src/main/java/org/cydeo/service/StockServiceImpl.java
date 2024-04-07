package org.cydeo.service;

import org.cydeo.model.Product;
import org.springframework.stereotype.Component;

@Component
public class StockServiceImpl implements StockService{
    @Override
    public boolean checkStockIsAvailable(Product product, int quantity) {
        return product.getRemainingQuantity() > quantity;
    }
}
