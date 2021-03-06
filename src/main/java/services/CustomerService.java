package services;

import domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Raymond Phua on 31-10-2016.
 */
public class CustomerService implements DefaultService<Customer> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzaCaseService");
    private EntityManager em = emf.createEntityManager();

    @Override
    public Customer find(long id) {
        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        Query query = em.createNamedQuery("findAllCustomers", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer create(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();

        return customer;
    }

    @Override
    public void update(Customer customer) {
        em.getTransaction().begin();
        Customer updateCustomer = em.find(Customer.class, customer.getId());

        updateCustomer.setName("Poop");
        em.getTransaction().commit();
    }

    @Override
    public void delete(Customer customer) {

    }
}
