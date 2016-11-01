package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Raymond Phua on 27-10-2016.
 */


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PRODUCT_TYPE")
public abstract class Product {

    @Id
    @Getter
    @Setter
    protected int id;

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
