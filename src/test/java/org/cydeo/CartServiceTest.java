package org.cydeo;

import org.cydeo.config.ConfigApp;
import org.cydeo.model.Cart;
import org.cydeo.model.Product;
import org.cydeo.repository.CartRepository;
import org.cydeo.service.CartServiceImpl;
import org.cydeo.service.StockService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith( SpringRunner.class )
@ContextConfiguration(classes = ConfigApp.class)
public class CartServiceTest {
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private StockService stockService;


    @Test
    public void addCartTest(){
        Product product = new Product();
        product.setName("milk");
        product.setPrice(new BigDecimal(12));
        product.setQuantity(3);
        product.setRemainingQuantity(3);
        Cart cart = cartService.addCart(product, 2);
        Assert.assertEquals(new BigDecimal(24), cart.getCartTotalAmount());
    }
}
