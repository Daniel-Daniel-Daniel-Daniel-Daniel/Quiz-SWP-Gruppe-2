import javax.swing.*;
import java.awt.*;

public class QuizWindow {

    private JFrame frame;
    private JLabel frageLabel;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private QuizManager quizManager;

    public QuizWindow() {

        quizManager = new QuizManager();

        frame = new JFrame("Das große SWP-Quiz");
        frame.setSize(700, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        button1.addActionListener(e -> auswahl(button1.getText()));
        button2.addActionListener(e -> auswahl(button2.getText()));
        button3.addActionListener(e -> auswahl(button3.getText()));
        button4.addActionListener(e -> auswahl(button4.getText()));

        zeigeFrage();

        frame.setVisible(true);
    }

    private void zeigeFrage() {

        Question frage = quizManager.getAktuelleFrage();

        if (frage == null) {
            return;
        }

        frageLabel.setText(frage.getText());

        String[] antworten = frage.getAntworten();

        button1.setText(antworten[0]);
        button2.setText(antworten[1]);
        button3.setText(antworten[2]);
        button4.setText(antworten[3]);

        button4.setVisible(!antworten[3].equals("- Nicht belegt -"));
    }

    private void auswahl(String gewaehlteAntwort) {

        Question frage = quizManager.getAktuelleFrage();

        if (frage.istKorrekt(gewaehlteAntwort)) {
            JOptionPane.showMessageDialog(frame, "Richtig!");
        } else {
            JOptionPane.showMessageDialog(
                    frame,
                    "Falsch! Richtige Antwort: "
                            + frage.getKorrekteAntwort()
            );
        }

        quizManager.naechsteFrage();

        if (quizManager.hatMehrFragen()) {
            zeigeFrage();
        } else {
            JOptionPane.showMessageDialog(
                    frame,
                    "Quiz beendet!"
            );
            frame.dispose();
        }
    }
}