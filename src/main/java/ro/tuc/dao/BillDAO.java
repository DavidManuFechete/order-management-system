

package ro.tuc.dao;

import ro.tuc.connection.ConnectionFactory;
import ro.tuc.model.Bill;
import ro.tuc.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
/**
 * Class that extends the AbstractDAO class, taking its methods and also implementing a specific method for bills
 * that is used to select all the bills from the database and storing them into an array.
 */
public class BillDAO extends AbstractDAO<Bill>{

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    public static List<Bill> selectAllBills(){
        List<Bill> list = new ArrayList<Bill>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM orders_management.bill");
        String query = stringBuilder.toString();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id =  resultSet.getInt(1);
                int quantity = resultSet.getInt(2);
                String productName = resultSet.getString(3);
                String clientName = resultSet.getString(4);
                list.add(new Bill(id,quantity,productName,clientName));
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
