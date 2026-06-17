import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFenster extends JFrame {

    private JTextField benutzerfeld;
    private JPasswordField passwortfeld;
    private JButton loginButton;

    public LoginFenster() {
        setTitle("Quiz-App Anmeldung");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("  Benutzername:"));
        benutzerfeld = new JTextField();
        add(benutzerfeld);

        add(new JLabel("  Passwort:"));
        passwortfeld = new JPasswordField();
        add(passwortfeld);

        add(new JLabel(""));

        loginButton = new JButton("Einloggen");
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pruefeAnmeldung();
            }
        });
    }

    private void pruefeAnmeldung() {
        String benutzer = benutzerfeld.getText();
        String passwort = new String(passwortfeld.getPassword());

        if (benutzer.equals("admin") && passwort.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Anmeldung erfolgreich! Das Quiz startet jetzt.");


            new QuizWindow();

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Falscher Benutzername oder Passwort!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
    }