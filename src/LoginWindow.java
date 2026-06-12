import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {

    public LoginWindow() {

        JFrame frame = new JFrame("Login");

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Passwort:");
        JPasswordField passwordField = new JPasswordField(15);

        JButton startButton = new JButton("Start");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = nameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("User 1")
                        || username.equals("User 2")
                        || username.equals("User 3")) {

                    if (password.equals("1234")) {

                        frame.dispose();
                        new QuizWindow();

                    } else {

                        JOptionPane.showMessageDialog(
                                frame,
                                "Falsches Passwort!"
                        );
                    }

                } else {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Benutzername nicht gefunden!"
                    );
                }
            }
        });

        frame.setVisible(true);
    }
}