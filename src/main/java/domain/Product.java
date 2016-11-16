package domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Collection;

/**
 * Created by Raymond Phua on 27-10-2016.
 */


@Entity
@ToString(exclude="orderItem")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PRODUCT_TYPE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Pizza.class})
@NamedQueries({
        @NamedQuery(name="findAllProducts",
                query="SELECT p " +
                        "FROM Product p")
})
public abstract class Product {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected long id;

    @Getter
    @Setter
    protected String name;
    @Getter
    @Setter
    protected String description;

    @Getter
    @Setter
    protected double price;

    @Getter
    @Setter
    @OneToOne(mappedBy="product")
    @XmlTransient
    protected OrderItem orderItem;

//    @Getter
//    @Setter
//    @ManyToMany(targetEntity=ShoppingCart.class, mappedBy="orderedProducts")
//    protected Collection<ShoppingCart> orders;
}
