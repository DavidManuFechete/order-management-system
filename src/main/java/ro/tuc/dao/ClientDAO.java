package ro.tuc.dao;

import ro.tuc.model.Client;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ro.tuc.connection.ConnectionFactory;
import ro.tuc.presentation.ClientsView;

import javax.swing.*;

public class ClientDAO extends AbstractDAO<Client> {

   /*private ClientsView clientsView;
    private ArrayList<Client> clients = new ArrayList<>();
    public ClientDAO(ClientsView clientsView){

    }*/

    /*public void getClientsFromDataBase(){

        try{
            clients.clear();
            Connection connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM clients";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Client client = new Client(resultSet.getInt("id"), resultSet.getString("name"),
                                          resultSet.getString("address"), resultSet.getString("email"),
                                          resultSet.getInt("id"));
                clients.add(client);
            }

            JTable table = new JTable();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }*/
}
