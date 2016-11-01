package domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Named
@RequestScoped
@Data
@Entity
public class Customer {

    @Id
    private int id;
    private String name;
    private String email;
    private int phoneNumber;
    private String street;
    private int houseNr;
    private String zip;
    private String city;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
    //@JoinColumn(name="SHOPPINGCART_ID",referencedColumnName="CUSTOMER_ID")
    private Collection<ShoppingCart> orders;

    public Customer() {
        orders = new ArrayList<>();
    }

    public Customer(int id,
                    String name,
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


}
