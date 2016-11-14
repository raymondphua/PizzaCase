package controllers;

import domain.PizzasBean;
import domain.Product;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by Raymond Phua on 14-11-2016.
 */
@Named
@NoArgsConstructor
@ViewScoped
public class PizzaController implements Serializable {

    @EJB
    private PizzasBean pizzasBean;
    @Setter
    private List<Product> pizzaList;

    public List<Product> getPizzaList() {
        pizzaList = pizzasBean.getPizzaList();
        return pizzaList;
    }

    public void addProduct(Product p) {
        pizzasBean.addPizza(p);
    }

    @Asynchronous
    public Future<String> test() {
        try {
            Thread.sleep(5000);
        } catch(Exception e) {
            e.printStackTrace();
        }
        String result = "U wasted 5 seconds of your life for this result";

        return new AsyncResult<>(result);
    }
}
