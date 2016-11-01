package domain;

import enums.Status;
import lombok.Data;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Named
@SessionScoped
@Data
@Entity
public class ShoppingCart implements Serializable {

    @Id
    private int id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

    //@OneToMany(mappedBy="shoppingcart")
    //private Collection<Product> orderedProducts;

    private int amountInCart;
    private String status;
    private double statusProgress;

    @Setter
    private double totalPrice;

    public ShoppingCart() { }
//    public ShoppingCart() {
//        orderedProducts = new ArrayList<>();
//        amountInCart = 0;
//        customer = new Customer();
//        Random random = new Random();
//        id = random.nextInt(100);
//        status = "Processing...";
//    }
//
//    public void addProductToCart(Product product) {
//        if (orderedProducts.contains(product)) {
//            orderedProducts.forEach(p -> {
//                if (p.equals(product)) {
//                    p.incrementAmount();
//                }
//            });
//        } else {
//            product.incrementAmount();
//            orderedProducts.add(product);
//        }
//        amountInCart++;
//    }
//
//    public void removeProductFromCart(Product product) {
//        if (orderedProducts.contains(product)) {
//            orderedProducts.forEach(p -> {
//                if (p.equals(product)) {
//                    p.decrementAmount();
//                }
//            });
//        }
//
//        if (product.getAmount() == 0) {
//            orderedProducts.remove(product);
//        }
//
//        amountInCart--;
//    }
//
//    public int getShoppingCartSize() {
//        return amountInCart;
//    }
//
//    public double getTotalPrice() {
//        double price = orderedProducts.stream().mapToDouble(Product::getPrice).sum();
//
//        return price;
//    }

    public void updateStatus() {
        int statusSize = Status.values().length;
        double progressPercentage = 100.0 / statusSize;

        if (status.equals("Processing...")) {
            this.status = Status.PREPARING.toString();
            statusProgress = progressPercentage * 1;
        } else if (status.equals(Status.PREPARING.toString())) {
            this.status = Status.DELIVERING.toString();
            statusProgress = progressPercentage * 2;
        } else if (status.equals(Status.DELIVERING.toString())) {
            this.status = Status.COMPLETED.toString();
            statusProgress = progressPercentage * 3;
        }
    }
}
