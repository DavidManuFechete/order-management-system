package ro.tuc.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *  The GUI for the Products window in which each button, text field and label are implemented. The Class extends JFrame
 *  and acts as a canvas for the different components that are added onto it. It has buttons for the addition of the product,
 *  update of it, deletion and showing.
 */
public class ProductsView extends JFrame {

    private JFrame frame;
    private JTextField textField;
    private JTextField priceTextField;
    private JTextField quantityTextField;
    private JTextField updateField;
    private JTextField deleteTextField;

    JScrollPane scrollPane;
    JButton updateButton;

    JButton deleteButton;
    JButton insertButton;
    JButton showButton;
    public ProductsView(){

        this.setBounds(100, 100, 959, 551);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(93, 164, 96, 19);
        this.getContentPane().add(textField);
        textField.setColumns(10);

        updateField = new JTextField();
        updateField.setBounds(206, 442, 96, 19);
        this.getContentPane().add(updateField);
        updateField.setColumns(10);

        showButton = new JButton("Show Products");
        showButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        showButton.setBounds(35, 441, 139, 32);
        this.getContentPane().add(showButton);

        JLabel clientsTitle = new JLabel("Products");
        clientsTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
        clientsTitle.setBounds(396, 25, 126, 45);
        this.getContentPane().add(clientsTitle);


        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idLabel.setBounds(175, 443, 16, 13);
        this.getContentPane().add(idLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nameLabel.setBounds(35, 167, 45, 13);
        this.getContentPane().add(nameLabel);

        priceTextField = new JTextField();
        priceTextField.setBounds(93, 212, 96, 19);
        this.getContentPane().add(priceTextField);
        priceTextField.setColumns(10);

        JLabel addressLabel = new JLabel("Price");
        addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addressLabel.setBounds(20, 213, 60, 13);
        this.getContentPane().add(addressLabel);

        quantityTextField = new JTextField();
        quantityTextField.setColumns(10);
        quantityTextField.setBounds(93, 255, 96, 19);
        this.getContentPane().add(quantityTextField);

        deleteTextField = new JTextField();
        deleteTextField.setColumns(10);
        deleteTextField.setBounds(357, 442, 96, 19);
        this.getContentPane().add(deleteTextField);

        JLabel emailLabel = new JLabel("Quantity");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        emailLabel.setBounds(35, 256, 65, 13);
        this.getContentPane().add(emailLabel);

        JLabel idLabelForDelete = new JLabel("ID");
        idLabelForDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idLabelForDelete.setBounds(332, 445, 16, 13);
        this.getContentPane().add(idLabelForDelete);


        insertButton = new JButton("Insert Product");
        insertButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        insertButton.setBounds(35, 389, 129, 32);
        this.getContentPane().add(insertButton);

        deleteButton = new JButton("Delete Product");
        deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        deleteButton.setBounds(332, 389, 121, 32);
        this.getContentPane().add(deleteButton);

        updateButton = new JButton("Update a Product");
        updateButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        updateButton.setBounds(175, 389, 150, 32);
        this.getContentPane().add(updateButton);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(403, 119, 428, 255);
        this.getContentPane().add(scrollPane);

        updateButton.setFocusable(false);
        deleteButton.setFocusable(false);
        insertButton.setFocusable(false);
        showButton.setFocusable(false);
        //this.setVisible(true);
    }


    public void showInsertMessage(String msg){
        JOptionPane.showMessageDialog(this, msg, "", JOptionPane.INFORMATION_MESSAGE);
        refresh();
    }
    public void showDeletedMsg(String msg){
        JOptionPane.showMessageDialog(this, msg, "", JOptionPane.INFORMATION_MESSAGE);
        refresh();
    }
    public void showUpdatedMsg(String msg){
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

    public void addProductListener(ActionListener actionListener){
        insertButton.addActionListener(actionListener);
    }

    public void deleteProductListener(ActionListener actionListener){
        deleteButton.addActionListener(actionListener);
    }

    public void showProductListener(ActionListener actionListener){
        showButton.addActionListener(actionListener);
    }

    public void updateProductListener(ActionListener actionListener){
        updateButton.addActionListener(actionListener);
    }

    public String getTextField() { // name text field
        return textField.getText();
    }

    public void setTextField(String textField) {
        this.textField.setText(textField);
    }

    public double getPriceTextField() {
        return Double.parseDouble(priceTextField.getText());
    }

    public void setPriceTextField(double priceTextField) {
        this.priceTextField.setText(String.valueOf(priceTextField));
    }

    public int getQuantityTextField() {
        return Integer.parseInt(quantityTextField.getText());
    }

    public void setQuantityTextField(int quantityTextField) {
        this.quantityTextField.setText(String.valueOf(quantityTextField));
    }

    public int getUpdateField() {
        return Integer.parseInt(updateField.getText());
    }

    public void setUpdateField(int updateField) {
        this.updateField.setText(String.valueOf(updateField));
    }

    public int getDeleteTextField() {
        return Integer.parseInt(deleteTextField.getText());
    }

    public void setDeleteTextField(int deleteTextField) {
        this.deleteTextField.setText(String.valueOf(deleteTextField));
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public void setInsertButton(JButton insertButton) {
        this.insertButton = insertButton;
    }

    public void refresh(){
        textField.setText(null);
        quantityTextField.setText(null);
        priceTextField.setText(null);
        deleteTextField.setText(null);
        updateField.setText(null);
    }
}
