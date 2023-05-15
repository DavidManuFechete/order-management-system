package ro.tuc.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientsView extends JFrame {


    private JFrame frame;
    private JTextField textField;
    private JTextField addressTextField;
    private JTextField emailTextField;
    private JTextField ageTextField;
    private JTextField updateField;
    private JTextField deleteTextField;

    JScrollPane scrollPane;
    JButton updateButton;

    JButton deleteButton;
    JButton insertButton;
    JButton showButton;
    public ClientsView(){

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

        showButton = new JButton("Show Clients");
        showButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        showButton.setBounds(35, 441, 109, 32);
        this.getContentPane().add(showButton);

        JLabel clientsTitle = new JLabel("Clients");
        clientsTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
        clientsTitle.setBounds(396, 25, 96, 45);
        this.getContentPane().add(clientsTitle);


        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idLabel.setBounds(175, 443, 16, 13);
        this.getContentPane().add(idLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nameLabel.setBounds(35, 167, 45, 13);
        this.getContentPane().add(nameLabel);

        addressTextField = new JTextField();
        addressTextField.setBounds(93, 212, 96, 19);
        this.getContentPane().add(addressTextField);
        addressTextField.setColumns(10);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addressLabel.setBounds(20, 213, 60, 13);
        this.getContentPane().add(addressLabel);

        emailTextField = new JTextField();
        emailTextField.setColumns(10);
        emailTextField.setBounds(93, 255, 96, 19);
        this.getContentPane().add(emailTextField);

        deleteTextField = new JTextField();
        deleteTextField.setColumns(10);
        deleteTextField.setBounds(357, 442, 96, 19);
        this.getContentPane().add(deleteTextField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        emailLabel.setBounds(35, 256, 45, 13);
        this.getContentPane().add(emailLabel);

        JLabel idLabelForDelete = new JLabel("ID");
        idLabelForDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idLabelForDelete.setBounds(332, 445, 16, 13);
        this.getContentPane().add(idLabelForDelete);

        ageTextField = new JTextField();
        ageTextField.setColumns(10);
        ageTextField.setBounds(93, 301, 96, 19);
        this.getContentPane().add(ageTextField);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ageLabel.setBounds(35, 299, 45, 19);
        this.getContentPane().add(ageLabel);

        insertButton = new JButton("Insert Client");
        insertButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        insertButton.setBounds(35, 389, 109, 32);
        this.getContentPane().add(insertButton);

        deleteButton = new JButton("Delete Client");
        deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        deleteButton.setBounds(332, 389, 121, 32);
        this.getContentPane().add(deleteButton);

        updateButton = new JButton("Update a Client");
        updateButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        updateButton.setBounds(175, 389, 127, 32);
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

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public void addClientListener(ActionListener actionListener){
        insertButton.addActionListener(actionListener);
    }

    public void deleteClientListener(ActionListener actionListener){
        deleteButton.addActionListener(actionListener);
    }

    public void showClientsListener(ActionListener actionListener){
        showButton.addActionListener(actionListener);
    }

    public void updateClientsListener(ActionListener actionListener){
        updateButton.addActionListener(actionListener);
    }

    public String getTextField() { // name text field
        return textField.getText();
    }

    public void setTextField(String textField) {
        this.textField.setText(textField);
    }

    public String getAddressTextField() {
        return addressTextField.getText();
    }

    public void setAddressTextField(String addressTextField) {
        this.addressTextField.setText(addressTextField);
    }

    public String getEmailTextField() {
        return emailTextField.getText();
    }

    public void setEmailTextField(String emailTextField) {
        this.emailTextField.setText(emailTextField);
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

    public int getAgeTextField() {
        return Integer.parseInt(ageTextField.getText());
    }

    public void setAgeTextField(int ageTextField) {
        this.ageTextField.setText(String.valueOf(ageTextField));
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
}


