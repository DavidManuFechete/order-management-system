package ro.tuc.presentation;

import ro.tuc.dao.AbstractDAO;
import ro.tuc.dao.ClientDAO;
import ro.tuc.dao.OrderDAO;
import ro.tuc.dao.ProductDAO;
import ro.tuc.model.Client;
import ro.tuc.model.ClientTableModel;
import ro.tuc.model.Order;
import ro.tuc.model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private ClientsView clientsView;
    private ProductsView productsView;
    private OrdersView ordersView;
    private MainView mainView;

    public Controller (ClientsView clientsView, ProductsView productsView, OrdersView ordersView, MainView mainView) {
        this.clientsView = clientsView;
        this.productsView = productsView;
        this.ordersView = ordersView;
        this.mainView = mainView;

        this.mainView.goToClientsListener(new goToClients());
        this.mainView.goToProductsListener(new goToProducts());
        this.mainView.goToOrdersListener(new goToOrders());

        this.clientsView.addClientListener(new InsertClient());
        this.clientsView.deleteClientListener(new DeleteClient());
        this.clientsView.showClientsListener(new ShowClients());
        this.clientsView.updateClientsListener(new UpdateClient());

        this.productsView.addProductListener(new InsertProduct());
        this.productsView.deleteProductListener(new DeleteProduct());
        this.productsView.showProductListener(new ShowProducts());

        this.ordersView.insertOrderListener(new InsertOrder());
        this.ordersView.showOrdersListener(new ShowOrders());
    }

    class goToOrders implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ordersView.setVisible(true);
        }
    }
    class goToClients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            clientsView.setVisible(true);
        }
    }
    class goToProducts implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            productsView.setVisible(true);
        }
    }
    class ShowProducts implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Product> productList = ProductDAO.selectAllProducts();
            ProductDAO productDAO = new ProductDAO();
            JTable table = productDAO.generateTable(productList);
            productsView.getScrollPane().setViewportView(table);
        }
    }
    class DeleteProduct implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductDAO productDAO = new ProductDAO();
            Product product = ProductDAO.findProductById(productsView.getDeleteTextField());
            productDAO.delete(product);
        }
    }
    class InsertProduct implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            Product product = new Product(productsView.getTextField(), productsView.getPriceTextField(), productsView.getQuantityTextField());
            ProductDAO productDAO = new ProductDAO();
            productDAO.insert(product);
        }
    }
    class ShowClients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Client> clientList = ClientDAO.selectAllClients();
            ClientDAO clientDAO = new ClientDAO();
            JTable table = clientDAO.generateTable(clientList);
            clientsView.getScrollPane().setViewportView(table);
        }
    }
    class InsertClient implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Client client = new Client(clientsView.getTextField(), clientsView.getAddressTextField(), clientsView.getEmailTextField(),
                                        clientsView.getAgeTextField());
            ClientDAO clientDAO = new ClientDAO();
            clientDAO.insert(client);
        }
    }

    class DeleteClient implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientDAO clientDAO = new ClientDAO();
            Client client = ClientDAO.findClientById(clientsView.getDeleteTextField());
            clientDAO.delete(client);
        }
    }
    class UpdateClient implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientDAO clientDAO = new ClientDAO();
            Client client = new Client(clientsView.getUpdateField(), clientsView.getTextField(),
                                        clientsView.getAddressTextField(), clientsView.getEmailTextField(),
                                        clientsView.getAgeTextField());
            clientDAO.update(client);
        }
    }

    class InsertOrder implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Order order = new Order(ordersView.getClientIdTextField(), ordersView.getProductIdTextField(),
                                    ordersView.getQuantityTextField());
            OrderDAO orderDAO = new OrderDAO();
            ProductDAO productDAO = new ProductDAO();
            orderDAO.insert(order);
            ProductDAO.updateProduct(ordersView.getProductIdTextField(), ordersView.getQuantityTextField());
        }
    }

    class ShowOrders implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
