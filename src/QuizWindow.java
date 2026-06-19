import javax.swing.*;
import java.awt.*;

public class QuizWindow {

    private JFrame frame;
    private JLabel frageLabel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private QuizManager quizManager; // Der Manager liefert die Daten

    public QuizWindow() {
        quizManager = new QuizManager();

        frame = new JFrame("Das große SWP-Quiz");
        frame.setSize(650, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        frageLabel = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        frame.add(frageLabel);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        // ActionListener nutzen Lambda-Ausdrücke für besseren Stil
        button1.addActionListener(e -> auswahl(button1.getText()));
        button2.addActionListener(e -> auswahl(button2.getText()));
        button3.addActionListener(e -> auswahl(button3.getText()));
        button4.addActionListener(e -> auswahl(button4.getText()));

        // Erste Frage anzeigen
        zeigeAktuelleFrage();

        frame.setVisible(true);
    }

    private void zeigeAktuelleFrage() {
        Frage aktuelleFrage = quizManager.getAktuelleFrage();

        if (aktuelleFrage != null) {
            // UI mit den Texten der aktuellen Frage befüllen
            frageLabel.setText(aktuelleFrage.getText());
            String[] antworten = aktuelleFrage.getAntworten();
            button1.setText(antworten[0]);
            button2.setText(antworten[1]);
            button3.setText(antworten[2]);
            button4.setText(antworten[3]);
        } else {
            // Keine Fragen mehr da -> Quiz beendet
            JOptionPane.showMessageDialog(frame, "Du hast alle Fragen geschafft! Quiz beendet.");
            frame.dispose();
        }
    }

    private void auswahl(String gewaehlteAntwort) {
        Frage aktuelleFrage = quizManager.getAktuelleFrage();

        if (aktuelleFrage != null) {
            // Prüfung über die Frage-Klasse
            if (aktuelleFrage.istKorrekt(gewaehlteAntwort)) {
                JOptionPane.showMessageDialog(frame, "Richtig! " + gewaehlteAntwort + " ist korrekt!");
            } else {
                JOptionPane.showMessageDialog(frame, "Falsch! Die richtige Antwort ist: " + aktuelleFrage.getKorrekteAntwort());
            }

            // Zur nächsten Frage springen und UI aktualisieren
            quizManager.naechsteFrage();
            zeigeAktuelleFrage();
        }
    }
}