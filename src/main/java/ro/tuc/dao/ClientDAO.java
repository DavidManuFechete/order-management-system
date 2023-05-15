package ro.tuc.dao;

import ro.tuc.model.Client;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ro.tuc.connection.ConnectionFactory;
import ro.tuc.presentation.ClientsView;

import javax.swing.*;

public class ClientDAO extends AbstractDAO<Client> {

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
   public static Client findClientById(int id){
       Client toReturn = null;
       Connection connection = ConnectionFactory.getConnection();
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       try{
            statement = connection.prepareStatement("SELECT * FROM client WHERE id = ?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");
            toReturn = new Client(id,name,address,email,age);
       }
       catch(Exception e){
            e.printStackTrace();
       }
       ConnectionFactory.close(resultSet);
       ConnectionFactory.close(statement);
       ConnectionFactory.close(connection);
       return toReturn;
   }

   public static List<Client> selectAllClients(){
       List<Client> list = new ArrayList<Client>();
       Connection connection = null;
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("SELECT * FROM orders_management.client");
       String query = stringBuilder.toString();
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(query);
           resultSet = statement.executeQuery();
           while(resultSet.next()){
                int id =  resultSet.getInt(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String email = resultSet.getString(4);
                int age = resultSet.getInt(5);
                list.add(new Client(id,name,address,email,age));
           }
       }
       catch (Exception e){
            e.printStackTrace();
       }
       ConnectionFactory.close(resultSet);
       ConnectionFactory.close(statement);
       ConnectionFactory.close(connection);
       return list;
   }
}
