package org.cydeo.service;

import org.cydeo.model.Cart;
import org.cydeo.model.Product;

public interface CartService {
    Cart addCart(Product product, int quantity);
}
