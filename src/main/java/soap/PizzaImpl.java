package soap;

import domain.Product;
import exceptions.CustomException;
import services.ProductService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "soap.PizzaService")
public class PizzaImpl implements PizzaService {

    @Override
    public Product getPizza(long id) throws CustomException {
        ProductService productService = new ProductService();
        Product found = productService.find(id);
        if (found == null) {
            throw new CustomException("404", "Product not found");
        }
        return found;
    }

    @Override
    public List<Product> getPizzaList() {
        ProductService productService = new ProductService();
        return productService.findAll();
    }
}
