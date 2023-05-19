
package ro.tuc.bll.validators;

import ro.tuc.model.Client;
import ro.tuc.model.Product;
/**
 * Validator that implements the validate method, in this case the validation of the price which needs to be above 0.0
 * whenever we want to insert a new product.
 */

public class PriceValidator implements Validator<Product>{

    private static final double MIN_PRICE = 0.0;
    public void validate(Product t){
        if (t.getPrice() == MIN_PRICE) {
            throw new IllegalArgumentException("Price must be over 0.0 !");
        }
    }

}
