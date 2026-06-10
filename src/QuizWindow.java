import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizWindow extends JFrame {

    private JLabel frageLabel;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    // Speichert die aktuelle Frage
    private int frage = 1;

    public QuizWindow() {

        setTitle("Quiz");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        // Erste Frage anzeigen
        frageLabel = new JLabel("Wie heißt die Hauptstadt von Deutschland?");

        // Antwort-Buttons
        button1 = new JButton("Berlin");
        button2 = new JButton("Hamburg");
        button3 = new JButton("München");

        add(frageLabel);
        add(button1);
        add(button2);
        add(button3);

        // Klick auf Button 1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswahl("Berlin");
            }
        });

        // Klick auf Button 2
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswahl("Hamburg");
            }
        });

        // Klick auf Button 3
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswahl("München");
            }
        });

        setVisible(true);
    }

    // Prüft die ausgewählte Antwort
    private void auswahl(String antwort) {

        // Frage 1
        if (frage == 1) {

            if (antwort.equals("Berlin")) {
                JOptionPane.showMessageDialog(this, "Richtig!");
            } else {
                JOptionPane.showMessageDialog(this, "Falsch!");
            }

            // Nächste Frage laden
            frage = 2;

            frageLabel.setText("Wie viele Tage hat eine Woche?");
            button1.setText("5");
            button2.setText("7");
            button3.setText("10");
        }


        // Quiz beenden
        JOptionPane.showMessageDialog(this, "Quiz beendet!");
        dispose();
    }
}