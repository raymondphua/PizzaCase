import lombok.Data;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond Phua on 27-10-2016.
 */
@Named
@ViewScoped
@Data
public class PizzasBean implements Serializable {

    private List<Pizza> pizzaList;

    public PizzasBean() {
        this.pizzaList = new ArrayList<>();
        addPizzas();
    }

    private void addPizzas() {
        pizzaList.add(new Pizza("Pizza Hawaii", "The best Hawaiian pizza in town!", 7.50));
        pizzaList.add(new Pizza("Pizza Salami", "Best salami pizza in town (spicy)!", 8.25));
        pizzaList.add(new Pizza("Pizza Cheese", "Classic pizza with tomato sauce and cheese", 7.00));
        pizzaList.add(new Pizza("Pizza Shoarma", "Pizza with cheese, tomato sauce and Shoarma pieces on top", 8.75));
        pizzaList.add(new Pizza("Pizza Green Garden", "Pizza made for vegetarians! Crushed tomatoes, green peppers, red onions, mushroom, roasted spinach", 08.50));
        pizzaList.add(new Pizza("Pizza Meat Lover's", "Pizza made for the meat lover's out there! Pepperoni, Italian sausage, Roasted ham, smoked bacon, seasoned pork and beef", 9.75));
    }
}