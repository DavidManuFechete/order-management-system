package ro.tuc.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 *   Main GUI implementation present in this class, it just has 3 buttons that redirect the user to the other 3 specific GUIs
 *   that are used. This GUI is always open.
 */

public class MainView extends JFrame {

    private JFrame frame;
    JButton goToOrdersButton;
    JButton goToProductsButton;
    JButton goToClientsButton;

    public MainView(){

        this.setBounds(100, 100, 706, 489);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel appTitle = new JLabel("Orders Management");
        appTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
        appTitle.setBounds(215, 40, 281, 45);
        this.getContentPane().add(appTitle);

        goToClientsButton = new JButton("Clients");
        goToClientsButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        goToClientsButton.setBounds(100, 192, 127, 45);
        this.getContentPane().add(goToClientsButton);

        goToProductsButton = new JButton("Products");
        goToProductsButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        goToProductsButton.setBounds(268, 193, 136, 42);
        this.getContentPane().add(goToProductsButton);

        goToOrdersButton = new JButton("Orders");
        goToOrdersButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        goToOrdersButton.setBounds(449, 195, 136, 39);
        this.getContentPane().add(goToOrdersButton);

        goToClientsButton.setFocusable(false);
        goToProductsButton.setFocusable(false);
        goToOrdersButton.setFocusable(false);

        this.setVisible(true);
    }

    public void goToOrdersListener(ActionListener actionListener){
        goToOrdersButton.addActionListener(actionListener);
    }

    public void goToProductsListener(ActionListener actionListener){
        goToProductsButton.addActionListener(actionListener);
    }
    public void goToClientsListener(ActionListener actionListener){
        goToClientsButton.addActionListener(actionListener);
    }
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getGoToOrdersButton() {
        return goToOrdersButton;
    }

    public void setGoToOrdersButton(JButton goToOrdersButton) {
        this.goToOrdersButton = goToOrdersButton;
    }

    public JButton getGoToProductsButton() {
        return goToProductsButton;
    }

    public void setGoToProductsButton(JButton goToProductsButton) {
        this.goToProductsButton = goToProductsButton;
    }

    public JButton getGoToClientsButton() {
        return goToClientsButton;
    }

    public void setGoToClientsButton(JButton goToClientsButton) {
        this.goToClientsButton = goToClientsButton;
    }
}

