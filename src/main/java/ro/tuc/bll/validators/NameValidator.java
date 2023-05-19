package ro.tuc.bll.validators;

import ro.tuc.model.Client;
/**
 * Validator that implements the validate method, in this case the validation of the price which needs to be above 0.0
 * whenever we want to insert a new product.
 */
public class NameValidator implements Validator<Client>{

    public void validate(Client client) {
        if (client.getName().isEmpty() && client.getName().contains("0123456789")){
            throw new IllegalArgumentException("Name is not valid");
        }
    }
}

