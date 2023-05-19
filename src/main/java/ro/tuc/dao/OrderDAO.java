

package ro.tuc.dao;

import ro.tuc.connection.ConnectionFactory;
import ro.tuc.model.Client;
import ro.tuc.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
/**
 * Class that extends the AbstractDAO class, taking its methods. It has no specific methods (or queries) needed for orders.
 */
public class OrderDAO extends AbstractDAO<Order> {

}

