package domain;

import enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import services.CustomerService;
import services.ProductService;
import services.ShoppingCartService;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond Phua on 1-11-2016.
 */
@Named
//@SessionScoped
@Stateful
@NoArgsConstructor
@Data
public class AdminBean implements Serializable {

    private List<Customer> customerList;
    private List<Product> productList;
    private List<ShoppingCart> orderList;
    private Customer detailedCustomer;
    private ShoppingCart detailedOrder;
    private Product detailedProduct;

    private List<String> possibleStatus;

    private String status;

    public String findSingleCustomer(long id) {
        CustomerService customerService = new CustomerService();
        detailedCustomer = customerService.find(id);

        return "customerDetail";
    }

    public String findAllCustomers() {
        CustomerService customerService = new CustomerService();
        customerList = customerService.findAll();

        return "customerList";
    }

    public String findAllProducts() {
        ProductService productService = new ProductService();
        productList = productService.findAll();

        return "productList";
    }

    public String findAllOrdersFromCustomer(long id) {
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        orderList = shoppingCartService.findOrdersFromCustomer(id);

        return "orderList";
    }

    public String findAllOrders() {
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        orderList = shoppingCartService.findAll();

        return "orderList";
    }

    public List<String> getPossibleStatus() {
        possibleStatus = new ArrayList<>();
        for (Status status : Status.values()) {
            possibleStatus.add(status.toString());
        }

        return possibleStatus;
    }

    public void onStatusChangeListener() {
        ShoppingCartService shoppingCartService = new ShoppingCartService();

        if(status != null) {
            orderList = shoppingCartService.findOrdersWithStatus(status);
        } else {
            orderList = shoppingCartService.findAll();
        }
    }
}
