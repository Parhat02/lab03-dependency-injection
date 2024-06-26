package org.cydeo.service;

import org.cydeo.model.Cart;
import org.cydeo.model.Product;
import org.cydeo.repository.CartRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final StockService service;

    public CartServiceImpl(CartRepository cartRepository, StockService service) {
        this.cartRepository = cartRepository;
        this.service = service;
    }

    @Override
    public Cart addCart(Product product, int quantity) {
        if (!service.checkStockIsAvailable(product, quantity)) return null;

        Cart cart = new Cart();

        cartRepository.addCartDatabase(product, quantity);

        BigDecimal totalAmount = product.getPrice().multiply(new BigDecimal(quantity));

        Map<Product, Integer> products = new HashMap<>();

        products.put(product, quantity);

        cart.setCartTotalAmount(totalAmount);
        cart.setProductMap(products);

        return cart;
    }
}
