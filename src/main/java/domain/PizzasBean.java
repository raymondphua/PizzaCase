package domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.ProductService;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
//@Named
//@ViewScoped
@NoArgsConstructor
@Stateless
@Setter
//@Data
public class PizzasBean implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public List<Product> getPizzaList() {
        TypedQuery<Product> query = em.createNamedQuery("findAllProducts", Product.class);
        return query.getResultList();
    }

    public void addPizza(Product pizza) {
        em.persist(pizza);
    }

//    @Schedule(second = "*/5", minute = "*", hour="*")
//    public void showMessage() {
//        System.out.println("Test Message...");
//        LOG.info("Message every 5 seconds");
//    }
}
