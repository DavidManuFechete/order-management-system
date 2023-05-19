/**
 * Class used for the main logic of the application and the listener for the buttons
 * The controller receives as arguments the views (GUIs) of the application and has inner classes
 * for each button.
 * @param clientsView GUI for the clients operations and also displays the table containing each client
 * @param productsView GUI that contains the products operations as well as the table of products
 * @param ordersView GUI for the order management, the user can create any order he/she wants and can see all the created orders as well
 * @param mainView GUI for the user that allows he/she to pick which GUI to open.
 */
package ro.tuc.presentation;

import ro.tuc.bll.BillBLL;
import ro.tuc.bll.ClientBLL;
import ro.tuc.bll.OrderBLL;
import ro.tuc.bll.ProductBLL;
import ro.tuc.dao.*;
import ro.tuc.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * Class used for the main logic of the application and the listener for the buttons
 * The controller receives as arguments the views (GUIs) of the application and has inner classes
 * for each button.
 */
public class Controller {

    private ClientsView clientsView;
    private ProductsView productsView;
    private OrdersView ordersView;
    private MainView mainView;
    private BillMaker billMaker;

    public Controller (ClientsView clientsView, ProductsView productsView, OrdersView ordersView, MainView mainView) {

        this.billMaker = new BillMaker();
        this.billMaker.createBill();
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
        this.productsView.updateProductListener(new UpdateProduct());

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
            ProductDAO productDAO = new ProductDAO();
            List<Product> productList = ProductBLL.findAllProducts();
            JTable table = productDAO.generateTable(productList);
            productsView.getScrollPane().setViewportView(table);
        }
    }
    class UpdateProduct implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Product product = new Product(productsView.getUpdateField(), productsView.getTextField(), productsView.getPriceTextField(),
                        productsView.getQuantityTextField());
                ProductBLL.updateProduct(product);
                productsView.showUpdatedMsg("Product successfully updated");
            }
            catch (Exception ex){
                productsView.showDeletedMsg("Wrong input !");
            }
        }
    }
    class DeleteProduct implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(ProductBLL.findProductById(productsView.getDeleteTextField()) != null){
                    ProductDAO productDAO = new ProductDAO();
                    Product product = productDAO.findById(productsView.getDeleteTextField());
                    ProductBLL.deleteProduct(product);
                    productsView.showDeletedMsg("Product deleted successfully !");
                }
                else{
                    productsView.showDeletedMsg("Nonexistent product");
                }
            }
            catch (Exception ex){
                productsView.showDeletedMsg("Wrong input !");
            }

        }
    }
    class InsertProduct implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Product product = new Product(productsView.getTextField(), productsView.getPriceTextField(), productsView.getQuantityTextField());
                if(ProductBLL.checkProduct(product)){
                    ProductBLL.insertProduct(product);
                    productsView.showInsertMessage("Product inserted successfully !");
                }
                else{
                    productsView.errorInsertMsg("Wrong input !");
                }
            }
            catch (Exception ex){
                productsView.errorInsertMsg("Wrong input !");
            }

        }
    }
    class ShowClients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientDAO clientDAO = new ClientDAO();
            List<Client> clientList = ClientBLL.findAllClients();
            List<Client> clients = clientDAO.findAll();
            JTable table = clientDAO.generateTable(clients);
            clientsView.getScrollPane().setViewportView(table);
        }
    }
    class InsertClient implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Client client = new Client(clientsView.getTextField(), clientsView.getAddressTextField(), clientsView.getEmailTextField(),
                        clientsView.getAgeTextField());
                if(ClientBLL.checkClient(client)){
                    ClientBLL.insertClient(client);
                    clientsView.showInsertMessage("Client successfully added !");
                }
                else{
                    clientsView.errorInsertMsg("Wrong input !");
                }
            }
            catch (Exception ex){
                clientsView.errorInsertMsg("Wrong input !");
            }

        }
    }

    class DeleteClient implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(ClientBLL.findClientById(clientsView.getDeleteTextField()) != null){
                    ClientDAO clientDAO = new ClientDAO();
                    Client client = clientDAO.findById(clientsView.getDeleteTextField());
                    ClientBLL.deleteClient(client);
                    clientsView.showDeletedMsg("Client deleted successfully !");
                }
                else{
                    clientsView.showDeletedMsg("Nonexistent client !");
                }
            }
           catch (Exception ex){
                clientsView.showDeletedMsg("Cannot delete this client !");
           }
        }
    }
    class UpdateClient implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Client client = new Client(clientsView.getUpdateField(), clientsView.getTextField(),
                        clientsView.getAddressTextField(), clientsView.getEmailTextField(),
                        clientsView.getAgeTextField());
                ClientBLL.updateCLient(client);
                clientsView.showUpdatedMsg("Client successfully updated");
            }
            catch (Exception ex){
                clientsView.errorInsertMsg("Wrong input !");
            }
        }
    }

    class InsertOrder implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Order order = new Order(ordersView.getClientIdTextField(), ordersView.getProductIdTextField(),
                        ordersView.getQuantityTextField());
                Product product = null;
                product = ProductBLL.findProductById(ordersView.getProductIdTextField());
                OrderBLL orderBLL = new OrderBLL();
                ProductBLL productBLL = new ProductBLL();
                assert product != null;
                if (product.getQuantity() < order.getQuantity()){
                    ordersView.errorInsertMsg("Cannot insert the order !");
                }
                if (product.getQuantity() == order.getQuantity()){
                    Client client = ClientBLL.findClientById(ordersView.getClientIdTextField());
                    OrderBLL.insertOrder(order);
                    ordersView.showInsertMessage("Order has been successfully placed");
                    ProductBLL.deleteProduct(product);
                    Bill bill = new Bill(0,order.getQuantity(),product.getName(),client.getName());
                    billMaker.writeBill(bill);
                    BillDAO billDAO = new BillDAO();
                    billDAO.insert(bill);
                }
                else{
                    Client client = ClientBLL.findClientById(ordersView.getClientIdTextField());
                    OrderBLL.insertOrder(order);
                    ordersView.showInsertMessage("Order has been successfully placed");
                    ProductBLL.updateProductAfterOrderInsert(product,order);
                    assert client != null;
                    Bill bill = new Bill(0,order.getQuantity(),product.getName(),client.getName());
                    billMaker.writeBill(bill);
                    BillDAO billDAO = new BillDAO();
                    billDAO.insert(bill);
                }
            }catch (Exception ex){
                ordersView.errorInsertMsg("Order cannot be placed wrong input !");
            }

        }
    }

    class ShowOrders implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            BillDAO billDAO = new BillDAO();
            List <Bill> bills = BillBLL.findAllBills();
            JTable table = billDAO.generateTable(bills);
            ordersView.getScrollPane().setViewportView(table);
        }
    }
}
