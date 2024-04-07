package org.cydeo.repository;

import org.cydeo.model.Product;
import org.springframework.stereotype.Component;

@Component
public class CartRepositoryImpl implements CartRepository{
    @Override
    public boolean addCartDatabase(Product product, int quantity) {
        System.out.println(product.getName() + " is added to database");
        return true;
    }
}
