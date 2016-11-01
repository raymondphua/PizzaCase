import domain.Customer;
import domain.Pizza;
import domain.Product;
import domain.ShoppingCart;
import services.CustomerService;
import services.ProductService;
import services.ShoppingCartService;

import java.util.Collection;
import java.util.List;

/**
 * Created by Raymond Phua on 31-10-2016.
 */
public class Main {

    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        Customer c1 = new Customer(6, "Test 6", "test2@email.com", 687654321, "Test straatjeee", 15, "1234AB", "Amsterdam");
        Customer c2 = new Customer(7, "Test 7", "test2@email.com", 687654321, "Test straatjeee", 15, "1234AB", "Amsterdam");

        customerService.create(c1);
        customerService.create(c2);

        Customer found = customerService.find(6);
        System.out.println(found.getName());

        //customerService.update(customer);

        List<Customer> customers = customerService.findAll();
        customers.forEach(c -> System.out.println(c.getName()));


        ShoppingCartService shoppingCartService = new ShoppingCartService();

        ShoppingCart sc1 = new ShoppingCart();
        sc1.setAmountInCart(3);
        sc1.setStatus("Completed");
        sc1.setTotalPrice(24.5);
        sc1.setId(5);
        sc1.setStatusProgress(100);

        shoppingCartService.create(sc1);

        ShoppingCart sc2 = new ShoppingCart();
        sc2.setAmountInCart(4);
        sc2.setStatus("Delivering");
        sc2.setTotalPrice(31.25);
        sc2.setId(6);
        sc2.setStatusProgress(66);

        shoppingCartService.create(sc2);

        ShoppingCart sc3 = new ShoppingCart();
        sc3.setAmountInCart(4);
        sc3.setStatus("Delivering");
        sc3.setTotalPrice(31.25);
        sc3.setId(7);
        sc3.setStatusProgress(66);

        shoppingCartService.create(sc3);

        shoppingCartService.setOrderCustomer(sc1, c1);
        shoppingCartService.setOrderCustomer(sc2, c2);
        shoppingCartService.setOrderCustomer(sc3, c2);

        Product p1 = new Pizza(1, "domain.Pizza Hawaii", "The best Hawaiian pizza in town!", 7.50);
        Product p2 = new Pizza(2, "domain.Pizza Salami", "Best salami pizza in town (spicy)!", 8.25);
        Product p3 = new Pizza(3, "domain.Pizza Cheese", "Classic pizza with tomato sauce and cheese", 7.00);
        Product p4 = new Pizza(4, "domain.Pizza Shoarma", "Pizza with cheese, tomato sauce and Shoarma pieces on top", 8.75);
        Product p5 = new Pizza(5, "domain.Pizza Green Garden", "Pizza made for vegetarians! Crushed tomatoes, green peppers, red onions, mushroom, roasted spinach", 08.50);
        Product p6 = new Pizza(6, "domain.Pizza Meat Lover's", "Pizza made for the meat lover's out there! Pepperoni, Italian sausage, Roasted ham, smoked bacon, seasoned pork and beef", 9.75);

        ProductService productService = new ProductService();
        productService.create(p1);
        productService.create(p2);
        productService.create(p3);
        productService.create(p4);
        productService.create(p5);
        productService.create(p6);

        Customer customer1 = customerService.find(6);
        Collection<ShoppingCart> orders = customer1.getOrders();
        int i = 0;
    }
}
