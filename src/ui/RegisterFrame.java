package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        setTitle("Flavorista - Register");
        setSize(350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(40, 50, 80, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(130, 50, 160, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(40, 90, 80, 25);
        add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(130, 90, 160, 25);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(40, 130, 80, 25);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(130, 130, 160, 25);
        add(passField);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(130, 180, 160, 30);
        add(registerBtn);

        registerBtn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passField.getPassword());

            if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields required!");
                return;
            }

            User user = new User(name, email, password);
            if(UserDAO.register(user)) {
                JOptionPane.showMessageDialog(this, "Registration Successful!");
                dispose(); // close registration window
            } else {
                JOptionPane.showMessageDialog(this, "Registration Failed! Email may exist.");
            }
        });

        setVisible(true);
    }
}
