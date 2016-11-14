package beans;

import domain.Pizza;
import domain.PizzasBean;
import domain.Product;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by Raymond Phua on 14-11-2016.
 */
@Singleton
@Startup
public class ConfigBean {

    @EJB
    PizzasBean pizzasBean;

    @PostConstruct
    public void createTestData() {
        Product p1 = new Pizza("Pizza Hawaii", "The best Hawaiian pizza in town!", 7.50);
        Product p2 = new Pizza("Pizza Salami", "Best salami pizza in town (spicy)!", 8.25);
        Product p3 = new Pizza("Pizza Cheese", "Classic pizza with tomato sauce and cheese", 7.00);
        Product p4 = new Pizza("Pizza Shoarma", "Pizza with cheese, tomato sauce and Shoarma pieces on top", 8.75);
        Product p5 = new Pizza("Pizza Green Garden", "Pizza made for vegetarians! Crushed tomatoes, green peppers, red onions, mushroom, roasted spinach", 08.50);
        Product p6 = new Pizza("Pizza Meat Lovers", "Pizza made for the meat lovers out there! Pepperoni, Italian sausage, Roasted ham, smoked bacon, seasoned pork and beef", 9.75);

        pizzasBean.addPizza(p1);
        pizzasBean.addPizza(p2);
        pizzasBean.addPizza(p3);
        pizzasBean.addPizza(p4);
        pizzasBean.addPizza(p5);
        pizzasBean.addPizza(p6);
    }

}
