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
        JButton startButton = new JButton("Start");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                new QuizWindow();
            }
        });

        frame.setVisible(true);
    }
}