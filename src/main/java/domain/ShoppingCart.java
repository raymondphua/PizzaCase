package domain;

import enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import services.CustomerService;
import services.ShoppingCartService;

import javax.ejb.Stateful;
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
//@SessionScoped
@Data
@Entity
@Stateful
@ToString(exclude = "orderedItems")
@NamedQueries({
        @NamedQuery(name="findOrdersFromCustomer",
                query="SELECT sc " +
                        "FROM Customer c, ShoppingCart sc " +
                        "WHERE sc.customer.id = :customerId " +
                        "GROUP BY sc"),
        @NamedQuery(name="findOrdersWithStatus",
                query="SELECT sc " +
                        "FROM ShoppingCart sc " +
                        "WHERE sc.status = :status")
})
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch=FetchType.EAGER)
    private Customer customer;

//    @ManyToMany(targetEntity=Product.class)
//    private Collection<Product> orderedProducts;

    @OneToMany(mappedBy="shoppingCart", cascade = CascadeType.PERSIST)
    private Collection<OrderItem> orderedItems;

    private int amountInCart;
    private String status;
    private double statusProgress;
    private double totalPrice;

    public ShoppingCart() {
        this(0, 0,"Processing...",0d,0d);
        //customer = new Customer();
    }

    public ShoppingCart(long id, int amountInCart, String status, double statusProgress, double totalPrice) {
        this.id = id;
        this.amountInCart = amountInCart;
        this.status = status;
        this.statusProgress = statusProgress;
        this.totalPrice = totalPrice;
        orderedItems = new ArrayList<>();
    }

    public void addToCart(OrderItem item) {
        orderedItems.add(item);
        item.setShoppingCart(this);
    }
}
