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

        loginButton.addActionListener(e -> pruefeAnmeldung());      //auf dem Button ist ein Action Listener, wenn der Button gedürckt wird wird die Methode pruefeAnmeldung aufgerufen

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void pruefeAnmeldung() {        //Methode zur Überprüfung der Anmeldedaten

        String benutzer = benutzerfeld.getText();       //text aus benutzerfeld wird gelesen
        String passwort = new String(passwortfeld.getPassword());       //Text aus Passwortfeld wird gelesen

        if (benutzer.equals("admin") && passwort.equals("1234")) {      //hier wird geprüft, ob der Benutzername "admin" und das Passwort "1234" ist

            JOptionPane.showMessageDialog(      //falls es stimmt, wird das Quiz gestartet
                    this,
                    "Anmeldung erfolgreich!\nDas Quiz startet jetzt."
            );

            new QuizWindow();

            dispose();

        } else {

            JOptionPane.showMessageDialog(      //falls die Login - Eingaben nicht stimmen, wird eine Fehlermeldung ausgegeben
                    this,
                    "Falscher Benutzername oder Passwort!",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}