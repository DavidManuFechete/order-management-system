package ro.tuc.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * The GUI for the Orders window in which each button, text field and label are implemented. The Class extends JFrame
 * and acts as a canvas for the different components that are added onto it. It has buttons for the order creation and
 * showing of all bills present in the database.
 */
public class OrdersView extends JFrame {


    private JFrame frame;
    private JTextField clientIdTextField;
    private JTextField productIdTextField;
    private JTextField quantityTextField;

    JButton showOrders;
    JButton insertOrderButton;
    JScrollPane scrollPane;


    public OrdersView(){

        this.setBounds(100, 100, 840, 499);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel ordersTitle = new JLabel("Orders");
        ordersTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
        ordersTitle.setBounds(360, 28, 96, 45);
        this.getContentPane().add(ordersTitle);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(345, 107, 388, 280);
        this.getContentPane().add(scrollPane);

        clientIdTextField = new JTextField();
        clientIdTextField.setBounds(93, 117, 96, 19);
        this.getContentPane().add(clientIdTextField);
        clientIdTextField.setColumns(10);

        JLabel idClient = new JLabel("ID for Client");
        idClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
        idClient.setBounds(10, 120, 73, 13);
        this.getContentPane().add(idClient);

        productIdTextField = new JTextField();
        productIdTextField.setColumns(10);
        productIdTextField.setBounds(93, 158, 96, 19);
        this.getContentPane().add(productIdTextField);

        JLabel idProduct = new JLabel("ID for Product");
        idProduct.setFont(new Font("Tahoma", Font.PLAIN, 13));
        idProduct.setBounds(10, 161, 81, 13);
        this.getContentPane().add(idProduct);

        quantityTextField = new JTextField();
        quantityTextField.setBounds(93, 214, 96, 19);
        this.getContentPane().add(quantityTextField);
        quantityTextField.setColumns(10);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        quantityLabel.setBounds(21, 216, 62, 13);
        this.getContentPane().add(quantityLabel);

        insertOrderButton = new JButton("Insert Order");
        insertOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        insertOrderButton.setBounds(93, 273, 111, 35);
        this.getContentPane().add(insertOrderButton);

        showOrders = new JButton("Show Orders");
        showOrders.setFont(new Font("Tahoma", Font.PLAIN, 13));
        showOrders.setBounds(93, 336, 111, 35);
        this.getContentPane().add(showOrders);

        insertOrderButton.setFocusable(false);
        showOrders.setFocusable(false);
    }

    public void showInsertMessage(String msg){
        JOptionPane.showMessageDialog(this, msg, "", JOptionPane.INFORMATION_MESSAGE);
        refresh();
    }
    public void errorInsertMsg(String msg){
        JOptionPane.showMessageDialog(this, msg, "", JOptionPane.ERROR_MESSAGE);
        refresh();
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public void insertOrderListener(ActionListener actionListener){
        this.insertOrderButton.addActionListener(actionListener);
    }

    public void showOrdersListener(ActionListener actionListener){
        this.showOrders.addActionListener(actionListener);
    }
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public int getClientIdTextField() {
        return Integer.parseInt(clientIdTextField.getText());
    }

    public void setClientIdTextField(int clientIdTextField) {
        this.clientIdTextField.setText(String.valueOf(clientIdTextField));
    }

    public int getProductIdTextField() {
        return Integer.parseInt(productIdTextField.getText());
    }

    public void setProductIdTextField(int productIdTextField) {
        this.productIdTextField.setText(String.valueOf(productIdTextField));
    }

    public int getQuantityTextField() {
        return Integer.parseInt(quantityTextField.getText());
    }

    public void setQuantityTextField(int quantityTextField) {
        this.quantityTextField.setText(String.valueOf(quantityTextField));
    }

    public JButton getShowOrders() {
        return showOrders;
    }

    public void setShowOrders(JButton showOrders) {
        this.showOrders = showOrders;
    }

    public JButton getInsertOrderButton() {
        return insertOrderButton;
    }

    public void setInsertOrderButton(JButton insertOrderButton) {
        this.insertOrderButton = insertOrderButton;
    }
    public void refresh(){
        quantityTextField.setText(null);
        productIdTextField.setText(null);
        clientIdTextField.setText(null);
    }
}

