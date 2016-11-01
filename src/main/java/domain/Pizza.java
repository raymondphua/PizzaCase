package domain;

import lombok.NoArgsConstructor;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Named
@RequestScoped
@Entity
@NoArgsConstructor
public class Pizza extends Product implements Serializable {

    public Pizza(int id, String name, String description, double defaultPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.defaultPrice = defaultPrice;
        amount = 0;
    }
}
