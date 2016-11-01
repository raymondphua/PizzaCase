package domain;

import lombok.Data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Data
@Inheritance
@DiscriminatorColumn(name="USER_TYPE")
public abstract class User {

    @Id
    private int id;
    protected String name;
    protected String email;
    protected int phoneNumber;
    protected String street;
    protected int houseNr;
    protected String zip;
    protected String city;

    @OneToMany(mappedBy="user")
    private Collection<ShoppingCart> orders;

}
