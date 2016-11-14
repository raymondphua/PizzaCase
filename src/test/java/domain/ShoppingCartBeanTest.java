package domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Raymond Phua on 14-11-2016.
 */
public class ShoppingCartBeanTest {

    @Test
    public void test() {
        ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
        shoppingCartBean.addProductToCart(new Pizza("Test", "Description", 9));
        shoppingCartBean.getAmountInCart();
    }
}