package ro.tuc.bll.validators;

import ro.tuc.model.Product;
/**
 * Validator that implements the validate method, in this case the validation of the quantity which needs to be above 0
 * whenever we want to insert a new product.
 */
public class QuantityValidator implements Validator<Product> {

    private static final double MIN_QUANTITY = 0.0;
    public void validate(Product t){
        if (t.getQuantity() == MIN_QUANTITY) {
            throw new IllegalArgumentException("Quantity must be over 0 !");
        }
    }
}
