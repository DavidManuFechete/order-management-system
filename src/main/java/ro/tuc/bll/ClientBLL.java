package ro.tuc.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import ro.tuc.bll.validators.*;

import ro.tuc.dao.ClientDAO;
import ro.tuc.model.Client;
import ro.tuc.presentation.ClientsView;

public class ClientBLL {

    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL(){
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new AgeValidator());
        clientDAO = new ClientDAO();
    }

    public Client findClientById(int id){
        Client client = clientDAO.findById(id);
        if (client == null){
            throw new NoSuchElementException("The student with id= " + id + " was not found");
        }
        return client;
    }

}
