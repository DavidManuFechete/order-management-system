

package ro.tuc.dao;

import org.w3c.dom.css.CSSUnknownRule;
import ro.tuc.connection.ConnectionFactory;
import ro.tuc.model.Client;
import ro.tuc.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * Class that extends the AbstractDAO class and has a single method specific for each product : the updateProduct method
 * which is needed specifically for this class because it's quantity(stock) needs to be updated after an order is placed
 */
public class ProductDAO extends AbstractDAO<Product>{


    public static void updateProduct(int id, int quantity){
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findById(id);
        product.setQuantity(product.getQuantity() - quantity);
        productDAO.update(product);
    }
}
