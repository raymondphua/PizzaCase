package domain;

import enums.Status;
import interceptors.TracelogInterceptor;
import lombok.Data;
import services.CustomerService;
import services.ShoppingCartService;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond Phua on 3-11-2016.
 */
@Named
//@SessionScoped
@Data
@Entity
@Stateful
@Interceptors(TracelogInterceptor.class)
public class ShoppingCartBean implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private Customer customer;
    private List<OrderItem> orderedItems;
    private int amountInCart;
    private String status;
    private double statusProgress;
    private double totalPrice;

    public ShoppingCartBean() {
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

    public void updateStatus() {
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        int statusSize = Status.values().length;
        double progressPercentage = 100.0 / statusSize;

        if (!status.equals(Status.COMPLETED.toString())) {
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

            shoppingCartService.update(mapToDomain());
        }
    }

    public String pay() {

        ShoppingCartService shoppingCartService = new ShoppingCartService();
        CustomerService customerService = new CustomerService();

        customerService.create(customer);
        this.id = shoppingCartService.create(mapToDomain()).getId();

        shoppingCartService.setOrderCustomer(mapToDomain(), customer);

        return "orderStatus";
    }

    private ShoppingCart mapToDomain() {
        ShoppingCart shoppingCart = new ShoppingCart(id, amountInCart, status, statusProgress, totalPrice);
        orderedItems.forEach(item -> shoppingCart.addToCart(item));
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
}

