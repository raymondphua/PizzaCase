
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Named
@RequestScoped
public class Pizza extends Product implements Serializable {

    public Pizza(String name, String description, double defaultPrice) {
        this.name = name;
        this.description = description;
        this.defaultPrice = defaultPrice;
        amount = 0;
    }
}
