package domain;

import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Raymond Phua on 27-10-2016.
 */

@Entity
@NoArgsConstructor
@XmlRootElement(name="Pizza")
public class Pizza extends Product implements Serializable {

    public Pizza(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
