package services;

import domain.Customer;
import domain.OrderItem;
import domain.Product;
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
    public ShoppingCart find(long id) {
        return em.find(ShoppingCart.class, id);
    }

    @Override
    public List<ShoppingCart> findAll() {
        Query query = em.createQuery("SELECT o FROM ShoppingCart o");
        return query.getResultList();
    }

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        em.getTransaction().begin();
        em.persist(shoppingCart);
        em.getTransaction().commit();

        return shoppingCart;
    }

    @Override
    public void update(ShoppingCart newCart) {
        ShoppingCart oldCart = em.find(ShoppingCart.class, newCart.getId());
        em.getTransaction().begin();
        updateCart(oldCart, newCart);
        em.getTransaction().commit();
    }

    @Override
    public void delete(ShoppingCart shoppingCart) {

    }

    public void setOrderCustomer(ShoppingCart order, Customer customer) {
        ShoppingCart cart = em.find(ShoppingCart.class, order.getId());
        Customer customer1 = em.find(Customer.class, customer.getId());

        em.getTransaction().begin();
        cart.setCustomer(customer1);
        customer1.addOrder(order);
        em.getTransaction().commit();

    }

    public List<ShoppingCart> findOrdersFromCustomer(long id) {
        return em.createNamedQuery("findOrdersFromCustomer", ShoppingCart.class)
                .setParameter("customerId", id)
                .getResultList();
    }

    public List<ShoppingCart> findOrdersWithStatus(String status) {
        return em.createNamedQuery("findOrdersWithStatus", ShoppingCart.class)
                .setParameter("status", status)
                .getResultList();
    }

    private void updateCart(ShoppingCart oldCart, ShoppingCart newCart) {
        oldCart.setCustomer(newCart.getCustomer());
        oldCart.setStatusProgress(newCart.getStatusProgress()); 
        oldCart.setStatus(newCart.getStatus());
        oldCart.setTotalPrice(newCart.getTotalPrice());
        oldCart.setAmountInCart(newCart.getAmountInCart());
        oldCart.setOrderedItems(newCart.getOrderedItems());
    }
}
