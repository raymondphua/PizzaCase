import lombok.NoArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Named
@RequestScoped
@NoArgsConstructor
public class Customer extends User {

    public Customer(String name,
                    String email,
                    int phoneNumber,
                    String street,
                    int houseNr,
                    String zip,
                    String city) {

        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.houseNr = houseNr;
        this.zip = zip;
        this.city = city;
    }
}
