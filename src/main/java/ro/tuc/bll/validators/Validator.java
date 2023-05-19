package ro.tuc.bll.validators;
/**
 *  Interface that gives a validation method that needs to be implemented by each specific validator.
 */
public interface Validator<T> {

    public void validate(T t);
}

