
package Swing;

import javax.swing.*;
import java.awt.*;

public class Dashboard {

    public static void openDashboard(String userID) {

        JFrame frame = new JFrame("Login Dashboard");

        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        JLabel welcomeLabel =
                new JLabel("Welcome, " + userID + "!");

        welcomeLabel.setFont(
                new Font("Arial", Font.BOLD, 25)
        );

        JLabel successLabel =
                new JLabel("You have logged in successfully.");

        successLabel.setFont(
                new Font("Arial", Font.PLAIN, 17)
        );

        JButton logoutButton = new JButton("Logout");

        logoutButton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(15, 15, 15, 15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(welcomeLabel, gbc);

        gbc.gridy = 1;
        panel.add(successLabel, gbc);

        gbc.gridy = 2;
        panel.add(logoutButton, gbc);

        // Logout functionality
        logoutButton.addActionListener(e -> {

            frame.dispose();

            LoginPage.createLoginWindow();

        });

        frame.add(panel);

        frame.setVisible(true);
    }
}
