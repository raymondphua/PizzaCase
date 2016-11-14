package domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Raymond Phua on 3-11-2016.
 */
@Entity
@Data
@Named
@Stateless
@NoArgsConstructor
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @OneToOne
    private Product product;
    @ManyToOne
    private ShoppingCart shoppingCart;
    private int amount;
    private double price;

    public OrderItem(int amount, Product product) {
        this.amount = amount;
        this.price = product.getPrice();
        this.product = product;
    }

    public void incrementAmount() {
        amount++;
        price += product.getPrice();
    }

    public void decrementAmount() {
        amount--;
        price -= product.getPrice();
    }
}
