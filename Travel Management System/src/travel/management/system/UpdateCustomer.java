package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame {
    UpdateCustomer(String username) {
        setBounds(500, 200, 800, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("VIEW CUSTOMER DETAILS");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setForeground(Color.BLUE);
        heading.setBounds(280, 20, 300, 30);
        add(heading);

        String[] labels = {
            "Username :", "ID :", "ID Number :", "Name :", "Gender :",
            "Country :", "Address :", "Phone :", "Email :"
        };

        int y = 80;
        for (int i = 0; i < labels.length; i++) {
            JLabel l = new JLabel(labels[i]);
            l.setBounds(50, y, 120, 25);
            l.setFont(new Font("Tahoma", Font.BOLD, 14));
            add(l);
            y += 40;
        }

        JLabel lblUsername = new JLabel();
        lblUsername.setBounds(180, 80, 200, 25);
        add(lblUsername);

        JLabel lblId = new JLabel();
        lblId.setBounds(180, 120, 200, 25);
        add(lblId);

        JLabel lblNumber = new JLabel();
        lblNumber.setBounds(180, 160, 200, 25);
        add(lblNumber);

        JLabel lblName = new JLabel();
        lblName.setBounds(180, 200, 200, 25);
        add(lblName);

        JLabel lblGender = new JLabel();
        lblGender.setBounds(180, 240, 200, 25);
        add(lblGender);

        JLabel lblCountry = new JLabel();
        lblCountry.setBounds(500, 80, 200, 25);
        add(lblCountry);

        JLabel lblAddress = new JLabel();
        lblAddress.setBounds(500, 120, 200, 25);
        add(lblAddress);

        JLabel lblPhone = new JLabel();
        lblPhone.setBounds(500, 160, 200, 25);
        add(lblPhone);

        JLabel lblEmail = new JLabel();
        lblEmail.setBounds(500, 200, 250, 25);
        add(lblEmail);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
            if (rs.next()) {
                lblUsername.setText(rs.getString("username"));
                lblId.setText(rs.getString("id_type"));
                lblNumber.setText(rs.getString("number"));
                lblName.setText(rs.getString("name"));
                lblGender.setText(rs.getString("gender"));
                lblCountry.setText(rs.getString("country"));
                lblAddress.setText(rs.getString("address"));
                lblPhone.setText(rs.getString("phone"));
                lblEmail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton delete = new JButton("Delete ?");
        delete.setBounds(150, 300, 120, 30);
        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);
        add(delete);

        JButton back = new JButton("Back");
        back.setBounds(300, 300, 120, 30);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        add(back);

        back.addActionListener(e -> setVisible(false));

        // Image of avatars at the bottom
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLabel = new JLabel(i3);
        imgLabel.setBounds(200, 370, 400, 100);
        add(imgLabel);
    }

    public static void main(String[] args) {
        new UpdateCustomer("vedha").setVisible(true);
    }
}
