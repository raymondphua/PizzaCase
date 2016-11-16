package domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Named
@RequestScoped
//@NoArgsConstructor
@Data
@ToString(exclude="orders")
@Entity
@NamedQueries({
        @NamedQuery(name="findCustomerFromId",
                query="SELECT c " +
                        "FROM Customer c " +
                        "WHERE c.id = :customerId"),
        @NamedQuery(name="findAllCustomers",
                query="SELECT c " +
                        "FROM Customer c")
})
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private int phoneNumber;
    private String street;
    private int houseNr;
    private String zip;
    private String city;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="customer")
    private Collection<ShoppingCart> orders;// = new ArrayList<>();

    public Customer() {
        this.orders = new ArrayList<>();
    }

    public Customer(String name,
                    String email,
                    int phoneNumber,
                    String street,
                    int houseNr,
                    String zip,
                    String city) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.houseNr = houseNr;
        this.zip = zip;
        this.city = city;
        orders = new ArrayList<>();
    }

    public int getOrderSize() {
        return orders.size();
    }

    public void addOrder(ShoppingCart order) {
        this.orders.add(order);
    }
}
