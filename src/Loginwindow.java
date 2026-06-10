import javax.swing.*;
import java.awt.*;

public class Loginwindow extends JFrame {

    public Loginwindow() {

        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);
        JButton startButton = new JButton("Start");

        add(nameLabel);
        add(nameField);
        add(startButton);

        startButton.addActionListener(e -> {
            new QuizWindow();
        });

        setVisible(true);
    }
}