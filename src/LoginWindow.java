import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {

    public LoginWindow() {

        // Fenster-Einstellungen
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Elemente werden automatisch angeordnet
        setLayout(new FlowLayout());

        // Komponenten erstellen
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);
        JButton startButton = new JButton("Start");

        // Komponenten zum Fenster hinzufügen
        add(nameLabel);
        add(nameField);
        add(startButton);

        // Reaktion auf Button-Klick
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Loginfenster schließen
                dispose();

                // Quiz öffnen
                new QuizWindow();
            }
        });

        // Fenster anzeigen
        setVisible(true);
    }
}