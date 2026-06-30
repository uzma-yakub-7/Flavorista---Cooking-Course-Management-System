package ui;

import javax.swing.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame(int userId) {
        setTitle("Flavorista Dashboard");
        setSize(400,300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel welcome = new JLabel("Welcome User ID: " + userId);
        welcome.setBounds(120, 100, 200, 30);
        add(welcome);

        setVisible(true);
    }
}
