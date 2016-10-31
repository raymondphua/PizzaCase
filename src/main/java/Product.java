import lombok.Getter;
import lombok.Setter;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
public abstract class Product {

    @Getter
    @Setter
    protected String name;
    @Getter
    @Setter
    protected String description;
    @Setter
    protected double price;
    @Getter
    @Setter
    protected int amount;

    @Getter
    @Setter
    protected double defaultPrice;

    public double getPrice() {
        if (amount != 0) {
            price = defaultPrice * amount;
        }
        return price;
    }

    public void incrementAmount() {
        amount++;
    }

    public void decrementAmount() {
        amount--;
    }
}
