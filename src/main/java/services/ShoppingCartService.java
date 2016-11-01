package services;

import domain.Customer;
import domain.ShoppingCart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Raymond Phua on 31-10-2016.
 */
public class ShoppingCartService implements DefaultService<ShoppingCart> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzaCaseService");
    private EntityManager em = emf.createEntityManager();

    @Override
    public ShoppingCart find(int id) {
        return em.find(ShoppingCart.class, id);
    }

    @Override
    public List<ShoppingCart> findAll() {
        Query query = em.createQuery("SELECT o FROM ShoppingCart o");
        return query.getResultList();
    }

    @Override
    public void create(ShoppingCart shoppingCart) {
        em.getTransaction().begin();
        em.persist(shoppingCart);
        em.getTransaction().commit();
    }

    @Override
    public void update(ShoppingCart shoppingCart) {

    }

    @Override
    public void delete(ShoppingCart shoppingCart) {

    }

    public void setOrderCustomer(ShoppingCart order, Customer customer) {
        ShoppingCart cart = em.find(ShoppingCart.class, order.getId());
        Customer customer1 = em.find(Customer.class, customer.getId());

        em.getTransaction().begin();
        cart.setCustomer(customer1);
        em.getTransaction().commit();

    }
}
