import lombok.Data;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Data
public abstract class User {

    protected String name;
    protected String email;
    protected int phoneNumber;
    protected String street;
    protected int houseNr;
    protected String zip;
    protected String city;


}
