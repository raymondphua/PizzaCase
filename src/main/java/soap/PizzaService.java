
package soap;

import domain.Product;
import exceptions.CustomException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.List;

@WebService
public interface PizzaService {

    @WebMethod
    public List<Product> getPizzaList();

    @WebMethod
    public Product getPizza(long id) throws CustomException;
}
