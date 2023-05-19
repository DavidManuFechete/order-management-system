package ro.tuc.bll;

import ro.tuc.bll.validators.AgeValidator;
import ro.tuc.bll.validators.EmailValidator;
import ro.tuc.bll.validators.NameValidator;
import ro.tuc.bll.validators.Validator;
import ro.tuc.dao.ClientDAO;
import ro.tuc.dao.OrderDAO;
import ro.tuc.model.Client;
import ro.tuc.model.Order;

import java.util.ArrayList;
import java.util.List;
/**
 * Business Logic Level class used for accessing the methods from the Data Access Layer in order to provide
 * an extra stage of checking data in the case of the orders class there are no validators needed. The class
 * doesn't get any parameters, and as attributes it has the DAO specific for the order, e.g. OrderDAO
 */
public class OrderBLL{
    private List<Validator<Order>> validators;

    private static OrderDAO orderDAO = new OrderDAO();

    public OrderBLL(){
        validators = new ArrayList<Validator<Order>>();
        orderDAO = new OrderDAO();
    }

    public static Order findOrderById(int id){
        Order order = orderDAO.findById(id);
        if (order == null){
            return null;
        }
        return order;
    }

    public static void insertOrder (Order order){
        orderDAO.insert(order);
    }
    public static List<Order> findAllOrder(){
        return orderDAO.findAll();
    }
    public static void deleteOrder (Order order){
        orderDAO.delete(order);
    }
    public static void updateOrder(Order order){
        orderDAO.update(order);
    }
}
