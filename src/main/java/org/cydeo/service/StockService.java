package org.cydeo.service;

import org.cydeo.model.Product;

public interface StockService {
    boolean checkStockIsAvailable(Product product, int quantity);
}
