package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfnumber, tfname, tfcountry, tfaddress, tfphone, tfemail;
    JComboBox<String> comboid;
    JRadioButton male, female;
    JButton add, back;
    String username;

    public AddCustomer(String username) {
        this.username = username;

        setBounds(300, 100, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel labelUsername = new JLabel("Username :");
        labelUsername.setBounds(30, 50, 150, 25);
        add(labelUsername);

        JLabel labelu = new JLabel(username);
        labelu.setBounds(220, 50, 150, 25);
        add(labelu);

        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        comboid = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "PAN Card", "Ration Card"});
        comboid.setBounds(220, 90, 150, 25);
        add(comboid);

        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 170, 150, 25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender :");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        male = new JRadioButton("Male");
        male.setBounds(220, 210, 70, 25);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(300, 210, 70, 25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel lblcountry = new JLabel("Country :");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Permanent Address :");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JLabel lblemail = new JLabel("Email :");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        add = new JButton("Add");
        add.setBounds(70, 420, 100, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(200, 420, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 400, 400);
        add(image);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText().trim();
            String name = tfname.getText().trim();
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "");
            String country = tfcountry.getText().trim();
            String address = tfaddress.getText().trim();
            String phone = tfphone.getText().trim();
            String email = tfemail.getText().trim();

            if (number.isEmpty() || name.isEmpty() || gender.isEmpty() || country.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all required fields including gender");
                return;
            }

            try {
                Conn c = new Conn();
                String query = "INSERT INTO customer (username, id, number, name, gender, country, address, phone, email) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement ps = c.c.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, id);
                ps.setString(3, number);
                ps.setString(4, name);
                ps.setString(5, gender);
                ps.setString(6, country);
                ps.setString(7, address);
                ps.setString(8, phone);
                ps.setString(9, email);

                int row = ps.executeUpdate();
                if (row > 0) {
                    JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add customer details");
                }

                ps.close();
                c.s.close();
                c.c.close();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Could not add customer details");
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    // You can test by running this main method
    public static void main(String[] args) {
        new AddCustomer("vedha");
    }
}
