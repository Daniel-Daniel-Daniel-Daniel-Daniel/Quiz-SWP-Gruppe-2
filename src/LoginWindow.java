import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {

    private JTextField benutzerfeld;
    private JPasswordField passwortfeld;
    private JButton loginButton;

    public LoginWindow() {

        setTitle("Quiz-App Anmeldung");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.lightGray);

        JLabel titel = new JLabel(
                "SWP Quiz Login",
                SwingConstants.CENTER
        );

        titel.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Benutzername:"));

        benutzerfeld = new JTextField();
        panel.add(benutzerfeld);

        panel.add(new JLabel("Passwort:"));

        passwortfeld = new JPasswordField();
        panel.add(passwortfeld);

        panel.add(new JLabel(""));

        loginButton = new JButton("Einloggen");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(loginButton);

        setLayout(new BorderLayout(10, 10));

        add(titel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        loginButton.addActionListener(e -> pruefeAnmeldung());

        setLocationRelativeTo(null);
        setVisible(true);
    }
//Prüfe Anmeldung
    private void pruefeAnmeldung() {

        String benutzer = benutzerfeld.getText();
        String passwort = new String(passwortfeld.getPassword());

        if (benutzer.equals("admin") && passwort.equals("1234")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Anmeldung erfolgreich!\nDas Quiz startet jetzt."
            );

            new QuizWindow();

            dispose();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Falscher Benutzername oder Passwort!",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}