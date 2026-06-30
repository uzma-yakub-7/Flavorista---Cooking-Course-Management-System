package ui;

import dao.UserDAO;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginFrame() {

        setTitle("Flavorista Login");
        setSize(400, 420);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Logo
        ImageIcon icon = new ImageIcon(getClass().getResource("/logo/flavorista.jpg"));
        Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(img));
        logoLabel.setBounds(140, 10, 120, 120);
        add(logoLabel);

        JLabel titleLabel = new JLabel("Flavorista Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(120, 135, 200, 30);
        add(titleLabel);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(60, 180, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(140, 180, 180, 25);
        add(emailField);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(60, 220, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 220, 180, 25);
        add(passwordField);

        // Buttons
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(140, 265, 180, 30);
        add(loginBtn);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(140, 305, 180, 30);
        add(registerBtn);

        // Login action
        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if(email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Enter email and password!");
                return;
            }

            int userId = UserDAO.login(email, password);
            if(userId != -1) {
                JOptionPane.showMessageDialog(this,"Login Successful!");
                new DashboardFrame(userId); // open dashboard
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Invalid email or password!");
            }
        });

        // Register action
        registerBtn.addActionListener(e -> new RegisterFrame());

        setVisible(true);
    }
}
