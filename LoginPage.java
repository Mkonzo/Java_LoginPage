
package Swing;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginPage {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::createLoginWindow);
    }

    public static void createLoginWindow() {

        JFrame frame = new JFrame("Java LoginPage System");

        frame.setSize(650, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        // Main outer panel
        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(Color.WHITE);

        // LoginPage form panel
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setPreferredSize(new Dimension(460, 320));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);

        // Title
        JLabel title = new JLabel("LOGIN SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 28));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        loginPanel.add(title, gbc);

        // Feedback message
        JLabel messageLabel = new JLabel(" ");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;

        loginPanel.add(messageLabel, gbc);

        // User ID label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;

        loginPanel.add(usernameLabel, gbc);

        // User ID field
        JTextField usernameField = new JTextField(18);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 17));
        usernameField.setPreferredSize(new Dimension(220, 38));

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        loginPanel.add(usernameField, gbc);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;

        loginPanel.add(passwordLabel, gbc);

        // Password field
        JPasswordField passwordField = new JPasswordField(18);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 17));
        passwordField.setPreferredSize(new Dimension(220, 38));

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        loginPanel.add(passwordField, gbc);

        // Buttons panel
        JPanel buttonsPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 20, 5)
        );

        buttonsPanel.setBackground(Color.WHITE);

        JButton loginButton = new JButton("Login");
        JButton resetButton = new JButton("Reset");

        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));

        loginButton.setPreferredSize(new Dimension(130, 42));
        resetButton.setPreferredSize(new Dimension(130, 42));

        buttonsPanel.add(loginButton);
        buttonsPanel.add(resetButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        loginPanel.add(buttonsPanel, gbc);

        // LOGIN BUTTON FUNCTIONALITY
        loginButton.addActionListener(e -> {

            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            // Check empty fields
            if (username.isEmpty() || password.isEmpty()) {

                messageLabel.setForeground(Color.RED);
                messageLabel.setText(
                        "Please enter your User ID and password."
                );

                return;
            }

            loginButton.setEnabled(false);

            try {

                boolean authenticated =
                        Authentication.login(username, password);

                if (authenticated) {

                    messageLabel.setForeground(new Color(0, 128, 0));
                    messageLabel.setText("LoginPage successful!");

                    frame.dispose();

                    Dashboard.openDashboard(username);

                } else {

                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText(
                            "Invalid Username or password. Try again."
                    );
                }

            } catch (SQLException ex) {

                messageLabel.setForeground(Color.RED);
                messageLabel.setText(
                        "Database connection error. Please try again."
                );

                ex.printStackTrace();

            } finally {

                loginButton.setEnabled(true);
            }
        });

        // RESET BUTTON FUNCTIONALITY
        resetButton.addActionListener(e -> {

            // Clear User ID
            usernameField.setText("");

            // Clear password
            passwordField.setText("");

            // Clear feedback message
            messageLabel.setText(" ");

            // Return cursor to User ID field
            usernameField.requestFocusInWindow();
        });

        // Add login panel to outer panel
        outerPanel.add(loginPanel);

        frame.add(outerPanel);

        frame.setVisible(true);
    }
}
