import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizWindow {

    private JFrame frame;
    private JLabel frageLabel;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    private int frage = 1;

    public QuizWindow() {

        frame = new JFrame("Quiz");

        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        frageLabel = new JLabel("Wie heißt die Hauptstadt von Deutschland?");

        button1 = new JButton("Berlin");
        button2 = new JButton("Hamburg");
        button3 = new JButton("München");

        frame.add(frageLabel);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswahl("Berlin");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswahl("Hamburg");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswahl("München");
            }
        });

        frame.setVisible(true);
    }

    private void auswahl(String antwort) {

        if (frage == 1) {

            if (antwort.equals("Berlin")) {
                JOptionPane.showMessageDialog(frame, "Richtig!");
            } else {
                JOptionPane.showMessageDialog(frame, "Falsch!");
            }

            JOptionPane.showMessageDialog(frame, "Quiz beendet!");
            frame.dispose();
        }
    }
}