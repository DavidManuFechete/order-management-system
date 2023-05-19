package ro.tuc;
import ro.tuc.connection.ConnectionFactory;
import ro.tuc.presentation.*;

import java.sql.Connection;
import java.util.logging.Logger;

/**
 *  The Main which starts the whole application and creates all the views as well as the controller.
 */
public class App {


    public static void main( String[] args ) {

        MainView mainView = new MainView();
        ClientsView clientsView = new ClientsView();
        ProductsView productsView = new ProductsView();
        OrdersView ordersView = new OrdersView();
        Controller controller = new Controller(clientsView,productsView,ordersView,mainView);
    }
}
