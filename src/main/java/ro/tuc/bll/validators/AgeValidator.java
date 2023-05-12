package ro.tuc.bll.validators;

import ro.tuc.model.Client;

public class AgeValidator implements Validator<Client> {

    private static final int MIN_AGE = 18;

    public void validate(Client t) {

        if (t.getAge() < MIN_AGE) {
            throw new IllegalArgumentException("Age limit not respected ! Must be over 18");
        }
    }
}

