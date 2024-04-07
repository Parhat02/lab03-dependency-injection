package org.cydeo.repository;

import org.cydeo.model.Product;

public interface CartRepository {
    boolean addCartDatabase(Product product, int quantity);
}
