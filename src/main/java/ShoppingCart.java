import lombok.Data;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Named
@SessionScoped
@Data
public class ShoppingCart implements Serializable {

    //@Inject
    private Customer customer;
    private List<Product> orderedProducts;
    private int amountInCart;

    @Setter
    private double totalPrice;

    public ShoppingCart() {
        this.orderedProducts = new ArrayList<>();
        amountInCart = 0;
        customer = new Customer();
    }

    public void addProductToCart(Product product) {
        if (orderedProducts.contains(product)) {
            orderedProducts.forEach(p -> {
                if (p.equals(product)) {
                    p.incrementAmount();
                }
            });
        } else {
            product.incrementAmount();
            orderedProducts.add(product);
        }
        amountInCart++;
    }

    public void removeProductFromCart(Product product) {
        if (orderedProducts.contains(product)) {
            orderedProducts.forEach(p -> {
                if (p.equals(product)) {
                    p.decrementAmount();
                }
            });
        }

        if (product.getAmount() == 0) {
            orderedProducts.remove(product);
        }

        amountInCart--;
    }

    public int getShoppingCartSize() {
        return amountInCart;
    }

    public double getTotalPrice() {
        double price = orderedProducts.stream().mapToDouble(Product::getPrice).sum();

        return price;
    }
}
