import javax.swing.*;
import java.awt.*;

public class QuizWindow extends JFrame {

    private JLabel frageLabel;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    private int frage = 1;

    public QuizWindow() {

        setTitle("Quiz");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        frageLabel = new JLabel("Wie heißt die Hauptstadt von Deutschland?");

        button1 = new JButton("Berlin");
        button2 = new JButton("Hamburg");
        button3 = new JButton("München");

        add(frageLabel);
        add(button1);
        add(button2);
        add(button3);

        button1.addActionListener(e -> auswahl("Berlin"));
        button2.addActionListener(e -> auswahl("Hamburg"));
        button3.addActionListener(e -> auswahl("München"));

        setVisible(true);
    }

    private void auswahl(String antwort) {

        if (frage == 1) {

            if (antwort.equals("Berlin")) {
                JOptionPane.showMessageDialog(this, "Richtig!");
            } else {
                JOptionPane.showMessageDialog(this, "Falsch!");
            }
        }
    }
}