package ro.tuc.bll.validators;

import ro.tuc.model.Client;
/**
 * Validator that implements the validate method, in this case the validation of the age, the age of a client must be over 18
 * in order for he/she to be able to place any orders.
 */
public class AgeValidator implements Validator<Client> {

    private static final int MIN_AGE = 18;

    public void validate(Client t) {

        if (t.getAge() < MIN_AGE) {
            throw new IllegalArgumentException("Age limit not respected ! Must be over 18");
        }
    }
}

