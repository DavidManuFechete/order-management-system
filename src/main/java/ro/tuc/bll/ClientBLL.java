package ro.tuc.bll;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import ro.tuc.bll.validators.*;

import ro.tuc.dao.ClientDAO;
import ro.tuc.model.Client;
import ro.tuc.presentation.ClientsView;

import javax.naming.Name;
/**
 * Business Logic Level class used for accessing the methods from the Data Access Layer in order to provide
 * an extra stage of checking data. The Validators present for the clients are email validators in order to make
 * sure that the email given is a proper one, age validators, the client must be over 18 years old in order for
 * him or her to order anything and also a name validator to make sure their name given in the text fields
 * doesn't contain any numbers. The class doesn't get any parameters, and as attributes it has the DAO specific for the order,
 * e.g. ClientDAO
 */
public class ClientBLL {

    private List<Validator<Client>> validators;
    private static ClientDAO clientDAO = new ClientDAO();

    public ClientBLL(){
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new AgeValidator());
        validators.add(new NameValidator());
        clientDAO = new ClientDAO();
    }

    public static Client findClientById(int id){
        Client client = clientDAO.findById(id);
        if (client == null){
            return null;
            //throw new NoSuchElementException("The student with id = " + id + " was not found");
        }
        return client;
    }
    public static boolean checkClient(Client client){
        AgeValidator ageValidator = new AgeValidator();
        EmailValidator emailValidator = new EmailValidator();
        NameValidator nameValidator = new NameValidator();
        try{
            ageValidator.validate(client);
            emailValidator.validate(client);
            nameValidator.validate(client);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static void insertClient (Client client){
        clientDAO.insert(client);
    }
    public static List<Client> findAllClients(){
        return clientDAO.findAll();
    }
    public static void deleteClient (Client client){
        clientDAO.delete(client);
    }
    public static void updateCLient(Client client){
        clientDAO.update(client);
    }

}
