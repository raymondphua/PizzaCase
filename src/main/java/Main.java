import controllers.PizzaController;
import domain.*;
import services.CustomerService;
import services.ProductService;
import services.ShoppingCartService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Raymond Phua on 31-10-2016.
 */
public class Main {
    @PersistenceContext
    private EntityManager em;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Main main = new Main();
//        PizzaController p = new PizzaController();
//        System.out.println("Why hello there...");
//        String result = p.test().get();
//
//        System.out.println("Result: " + result);
//        System.out.println("Other stuff going on...");
        main.test();


//        CustomerService customerService = new CustomerService();
//        ShoppingCartService shoppingCartService = new ShoppingCartService();
//        ProductService productService = new ProductService();
//
////UNCOMMENT IF DROP-CREATE TABLES IS ENABLED
//
//
//
//        Customer c1 = new Customer("Test 6", "test2@email.com", 687654321, "Test straatjeee", 15, "1234AB", "Amsterdam");
//        Customer c2 = new Customer("Test 7", "test2@email.com", 687654321, "Test straatjeee", 15, "1234AB", "Amsterdam");
//
//        customerService.create(c1);
//        customerService.create(c2);
//
//        Customer found = customerService.find(c1.getId());
//        System.out.println(found.getName());
//
//        Product p1 = new Pizza("Pizza Hawaii", "The best Hawaiian pizza in town!", 7.50);
//        Product p2 = new Pizza("Pizza Salami", "Best salami pizza in town (spicy)!", 8.25);
//        Product p3 = new Pizza("Pizza Cheese", "Classic pizza with tomato sauce and cheese", 7.00);
//        Product p4 = new Pizza("Pizza Shoarma", "Pizza with cheese, tomato sauce and Shoarma pieces on top", 8.75);
//        Product p5 = new Pizza("Pizza Green Garden", "Pizza made for vegetarians! Crushed tomatoes, green peppers, red onions, mushroom, roasted spinach", 08.50);
//        Product p6 = new Pizza("Pizza Meat Lovers", "Pizza made for the meat lovers out there! Pepperoni, Italian sausage, Roasted ham, smoked bacon, seasoned pork and beef", 9.75);
//
//
//        productService.create(p1);
//        productService.create(p2);
//        productService.create(p3);
//        productService.create(p4);
//        productService.create(p5);
//        productService.create(p6);
//
//        //customerService.update(customer);
//
//        List<Customer> customers = customerService.findAll();
//        customers.forEach(c -> System.out.println(c.getName()));
//
//        ShoppingCart sc1 = new ShoppingCart();
//        sc1.setAmountInCart(3);
//        sc1.setStatus("Completed");
//        sc1.setTotalPrice(24.5);
//        sc1.setStatusProgress(100);
//        sc1.addToCart(new OrderItem(2, p1));
//        sc1.addToCart(new OrderItem(1, p2));
//
//        shoppingCartService.create(sc1);
//
//        ShoppingCart sc2 = new ShoppingCart();
//        sc2.setAmountInCart(4);
//        sc2.setStatus("Delivering");
//        sc2.setTotalPrice(31.25);
//        sc2.setStatusProgress(66);
//        sc2.addToCart(new OrderItem(3, p1));
//        sc2.addToCart(new OrderItem(1, p3));
//
//        shoppingCartService.create(sc2);
//
//        ShoppingCart sc3 = new ShoppingCart();
//        sc3.setAmountInCart(4);
//        sc3.setStatus("Delivering");
//        sc3.setTotalPrice(31.25);
//        sc3.setStatusProgress(66);
//        sc3.addToCart(new OrderItem(2, p4));
//        sc3.addToCart(new OrderItem(2, p5));
//
//        shoppingCartService.create(sc3);
//
//        shoppingCartService.setOrderCustomer(sc1, c1);
//        shoppingCartService.setOrderCustomer(sc2, c2);
//        shoppingCartService.setOrderCustomer(sc3, c2);
//
//
//
////        shoppingCartService.addProductsToOrder(sc1, p1);
////        shoppingCartService.addProductsToOrder(sc1, p2);
////        shoppingCartService.addProductsToOrder(sc1, p3);
//
//// END OF UNCOMMENT
//
////        ShoppingCart foundCart = shoppingCartService.find(sc1.getId());
////
////        Product product = productService.find(p1.getId());
////        Collection<ShoppingCart> orders2 = product.getOrders();
////
////        Customer customer1 = customerService.find(c2.getId());
////        Collection<ShoppingCart> orders = customer1.getOrders();
////
////        ShoppingCart shoppingCart = shoppingCartService.find(sc1.getId());
////        Collection<Product> orderedProducts = shoppingCart.getOrderedProducts();
//
//        Customer c = new Customer();
//        c.setName("TEST");
//        c.setCity("TEST");
//        c.setEmail("NEWTEST@EMAIL.COM");
//        c.setHouseNr(25);
//        c.setPhoneNumber(612312312);
//        c.setStreet("TEST STREEEETTT");
//        c.setZip("1233AB");
//
//        customerService.create(c);
    }

    public void test() {
        Product p1 = new Pizza("Pizza Hawaii", "The best Hawaiian pizza in town!", 7.50);
        Product p2 = new Pizza("Pizza Salami", "Best salami pizza in town (spicy)!", 8.25);
        Product p3 = new Pizza("Pizza Cheese", "Classic pizza with tomato sauce and cheese", 7.00);
        Product p4 = new Pizza("Pizza Shoarma", "Pizza with cheese, tomato sauce and Shoarma pieces on top", 8.75);
        Product p5 = new Pizza("Pizza Green Garden", "Pizza made for vegetarians! Crushed tomatoes, green peppers, red onions, mushroom, roasted spinach", 08.50);
        Product p6 = new Pizza("Pizza Meat Lovers", "Pizza made for the meat lovers out there! Pepperoni, Italian sausage, Roasted ham, smoked bacon, seasoned pork and beef", 9.75);

        PizzaController pc = new PizzaController();
        pc.getPizzaList();
        pc.addProduct(p1);
        pc.addProduct(p2);
        pc.addProduct(p3);
        pc.addProduct(p4);
        pc.addProduct(p5);
        pc.addProduct(p6);
    }
}
