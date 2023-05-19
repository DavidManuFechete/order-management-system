

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
/**
 * Class that extends the AbstractDAO class, taking its methods. It has no specific methods (or queries) needed for clients.
 */
public class ClientDAO extends AbstractDAO<Client> {


}
