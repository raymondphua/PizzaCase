package EJB;

import domain.Customer;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Raymond Phua on 15-11-2016.
 */
@Stateless
@NoArgsConstructor
public class CustomerEJB {

    @PersistenceContext
    private EntityManager em;

    public void create(Customer customer) {
        em.persist(customer);
    }
}
