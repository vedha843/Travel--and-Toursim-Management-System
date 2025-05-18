package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Home extends JFrame {
    String username;

    public static void main(String[] args) {
        new Home("").setVisible(true);
    }

    public Home(String username) {
        super("Travel and Tourism Management System");
        this.username = username;
        setLayout(null);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_SMOOTH);

        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1950, 1000);
        add(background);

        // Title
        JLabel title = new JLabel("Tourism Management System");
        title.setBounds(600, 30, 1000, 70);
        title.setFont(new Font("Tahoma", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        background.add(title);

        // Sidebar Panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 128));
        p1.setBounds(0, 0, 300, 1000);
        background.add(p1);

        JLabel dashboard = new JLabel("Dash Board");
        dashboard.setBounds(80, 10, 200, 40);
        dashboard.setFont(new Font("Tahoma", Font.BOLD, 20));
        dashboard.setForeground(Color.WHITE);
        p1.add(dashboard);

        String[] buttons = {
            "Add Personal Details", "Update Personal Details", "View Customer", "Check Package", 
            "Book package", "View Package", "Check Hotels", "Book Hotel", "View Booked Hotel", 
            "Destination", "Payment Gateway", "Delete all Details", "About Us", "Logout"
        };

        int y = 60;
        for (String btnText : buttons) {
            JButton btn = new JButton(btnText);
            btn.setBounds(20, y, 250, 30);
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLUE);
            btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
            p1.add(btn);
            y += 35;

            // Event Listeners
            btn.addActionListener(e -> {
                switch (btnText) {
                    case "Add Personal Details":
                        try {
                            new AddCustomer(username).setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "Update Personal Details":
                        try {
                            new UpdateCustomer(username).setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "View Customer":
                        try {
                            new ViewCustomers().setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "Check Package":
                        try {
                            new CheckPackage().setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "Book package":
                        try {
                            new BookPackage(username).setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "View Package":
                        try {
                            new ViewPackage(username).setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "Check Hotels":
                        try {
                            new CheckHotels().setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "Book Hotel":
                        try {
                            new BookHotel(username).setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "View Booked Hotel":
                        try {
                            new ViewBookedHotel(username).setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "Destination":
                        new Destination().setVisible(true);
                        break;
                    case "Payment Gateway":
                        new Payment().setVisible(true);
                        break;
                    case "Delete all Details":
                        try {
                            new DeleteCustomer().setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "About Us":
                        new About().setVisible(true);
                        break;
                    case "Logout":
                        setVisible(false);
                        break;
                }
            });
        }

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
    }
}
