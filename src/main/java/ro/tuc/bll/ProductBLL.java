package ro.tuc.bll;

import ro.tuc.bll.validators.*;
import ro.tuc.dao.ClientDAO;
import ro.tuc.dao.ProductDAO;
import ro.tuc.model.Client;
import ro.tuc.model.Order;
import ro.tuc.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 *  Business Logic Level class used for accessing the methods from the Data Access Layer in order to provide
 *  an extra stage of checking data through the various validators for this class: PriceValidator and QuantityValidator.
 *  It has no constructor parameters, but it has as attributes a list containing all the validators and also the DAO
 *  specific for the class, e.g. ProductDAO
 */
public class ProductBLL {

    private List<Validator<Product>> validators;
    private static ProductDAO productDAO = new ProductDAO();

    public ProductBLL(){
        validators = new ArrayList<Validator<Product>>();
        validators.add(new PriceValidator());
        validators.add(new QuantityValidator());
        productDAO = new ProductDAO();
    }

    public static Product findProductById(int id){
        Product product = productDAO.findById(id);
        if (product == null){
            return null;
        }
        return product;
    }
    public static boolean checkProduct(Product product){
        PriceValidator priceValidator = new PriceValidator();
        QuantityValidator quantityValidator = new QuantityValidator();
        try{
            priceValidator.validate(product);
            quantityValidator.validate(product);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static void insertProduct (Product product){
        try{
            productDAO.insert(product);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static List<Product> findAllProducts(){
        return productDAO.findAll();
    }
    public static void deleteProduct (Product product){
        productDAO.delete(product);
    }
    public static void updateProduct(Product product){
        productDAO.update(product);
    }
    public static void updateProductAfterOrderInsert(Product product, Order order) {
        ProductDAO.updateProduct(product.getId(), order.getQuantity());
    }
}
