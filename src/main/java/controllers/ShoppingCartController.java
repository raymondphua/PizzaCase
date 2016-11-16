package controllers;

import EJB.*;
import domain.*;
import enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import services.CustomerService;
import services.ShoppingCartService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond Phua on 15-11-2016.
 */
@Named
@SessionScoped
@Data
public class ShoppingCartController implements Serializable {

    private long id;

    private Customer customer;
    private List<OrderItem> orderedItems;
    private int amountInCart;
    private String status;
    private double statusProgress;
    private double totalPrice;

    @EJB
    private ShoppingCartEJB shoppingCartEJB;

    @EJB
    private CustomerEJB customerEJB;

    public ShoppingCartController() {
        orderedItems = new ArrayList<>();
        status = "Processing...";
        customer = new Customer();
        amountInCart = 0;
    }

    public void addProductToCart(Product product) {
        //OrderItem exists = orderedProducts.entrySet().stream().map(itemAmountEntry -> itemAmountEntry.getKey()).filter(item -> item.getProduct().equals(product)).findAny().orElse(null);
        OrderItem exists = orderedItems.stream().filter(item -> item.getProduct().equals(product)).findAny().orElse(null);
        if (exists != null) {
            exists.incrementAmount();
        } else {
            orderedItems.add(new OrderItem(1, product));
        }
        amountInCart++;
        totalPrice = totalPrice + product.getPrice();
    }

    public void removeProductFromCart(Product product) {
        OrderItem found = orderedItems.stream().filter(item -> item.getProduct().equals(product)).findAny().orElse(null);

        if (found != null) {
            found.decrementAmount();

            if(found.getAmount() == 0) {
                orderedItems.remove(found);
            }
        }
        amountInCart--;
        totalPrice = totalPrice - product.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public ShoppingCart mapToDomain() {
        ShoppingCart shoppingCart = new ShoppingCart(id, amountInCart, status, statusProgress, totalPrice);
        orderedItems.forEach(item -> shoppingCart.addToCart(item));
        //shoppingCart.setCustomer(customer);
        return shoppingCart;
    }

    private void construct() {
        orderedItems = new ArrayList<>();
        status = "Processing...";
        customer = new Customer();
        amountInCart = 0;
        statusProgress = 0;
        totalPrice = 0;
    }

    public String destroy() {
        construct();
        id = 0;

        return "index";
    }

    public String pay() {

        customerEJB.create(customer);

        ShoppingCart shoppingCart = mapToDomain();
        shoppingCart.setCustomer(customer);
        shoppingCartEJB.create(shoppingCart);

        return "orderStatus";
    }

    public void updateStatus() {
        shoppingCartEJB.updateStatus(mapToDomain());
    }
}
