package services;

import domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Raymond Phua on 31-10-2016.
 */
public class ProductService implements DefaultService<Product> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzaCaseService");
    private EntityManager em = emf.createEntityManager();

    @Override
    public Product find(long id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        Query query = em.createQuery("SELECT p FROM Product p");
        return query.getResultList();
    }

    @Override
    public Product create(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();

        return product;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
