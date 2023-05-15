package ro.tuc.dao;

import ro.tuc.connection.ConnectionFactory;
import ro.tuc.model.Client;
import ro.tuc.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product>{


    public static Product findProductById(int id){
        Product toReturn = null;
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.prepareStatement("SELECT * FROM product WHERE id = ?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            toReturn = new Product(id,name,price,quantity);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        ConnectionFactory.close(resultSet);
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
        return toReturn;
    }
    public static List<Product> selectAllProducts(){
        List<Product> list = new ArrayList<Product>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM orders_management.product");
        String query = stringBuilder.toString();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id =  resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int quantity = resultSet.getInt(4);
                list.add(new Product(id,name,price,quantity));
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

    public static void updateProduct(int id, int quantity){
        Product product = findProductById(id);
        product.setQuantity(product.getQuantity() - quantity);
        ProductDAO productDAO = new ProductDAO();
        productDAO.update(product);
    }
}
