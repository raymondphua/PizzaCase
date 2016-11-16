package EJB;

import domain.OrderItem;
import domain.ShoppingCart;
import enums.Status;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond Phua on 15-11-2016.
 */
@Stateless
@NoArgsConstructor
public class ShoppingCartEJB {

    @PersistenceContext
    private EntityManager em;

    public void create(ShoppingCart shoppingCart) {
        em.persist(shoppingCart);
    }

    public void updateStatus(ShoppingCart shoppingCart) {
        int statusSize = Status.values().length;
        double progressPercentage = 100.0 / statusSize;

        if (!shoppingCart.getStatus().equals(Status.COMPLETED.toString())) {
            if (shoppingCart.getStatus().equals("Processing...")) {
                shoppingCart.setStatus(Status.PREPARING.toString());
                shoppingCart.setStatusProgress(progressPercentage * 1);
            } else if (shoppingCart.getStatus().equals(Status.PREPARING.toString())) {
                shoppingCart.setStatus(Status.DELIVERING.toString());
                shoppingCart.setStatusProgress(progressPercentage * 2);
            } else if (shoppingCart.getStatus().equals(Status.DELIVERING.toString())) {
                shoppingCart.setStatus(Status.COMPLETED.toString());
                shoppingCart.setStatusProgress(progressPercentage * 3);
            }

            List<OrderItem> mergedItems = new ArrayList<>();
            for (OrderItem item : shoppingCart.getOrderedItems()) {
                mergedItems.add(em.merge(item));
            }
            shoppingCart.setOrderedItems(mergedItems);

            em.persist(shoppingCart);
        }
    }
}
