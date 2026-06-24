import javax.swing.*;
import java.awt.*;

public class QuizWindow {

    private JFrame frame;
    private JLabel frageLabel;
    private JLabel punkteLabel;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private QuizManager quizManager;

    private int punkte = 0;

    public QuizWindow() {

        quizManager = new QuizManager();

        frame = new JFrame("Das große SWP-Quiz");
        frame.setSize(850, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backgroundPanel = new JPanel(new BorderLayout(15, 15)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                Color startFarbe = Color.CYAN;
                Color endFarbe = Color.MAGENTA;

                GradientPaint verlauf = new GradientPaint(0, 0, startFarbe, 0, getHeight(), endFarbe);
                g2d.setPaint(verlauf);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.setContentPane(backgroundPanel);


        frageLabel = new JLabel("", SwingConstants.CENTER);
        frageLabel.setFont(new Font("Arial", Font.BOLD, 22));

        punkteLabel = new JLabel("Punkte: 0", SwingConstants.CENTER);
        punkteLabel.setFont(new Font("Arial", Font.BOLD, 18));
        punkteLabel.setForeground(Color.WHITE);

        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);

        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);

        JPanel antwortPanel = new JPanel();
        antwortPanel.setLayout(new GridLayout(2, 2, 15, 15));


        antwortPanel.setOpaque(false);

        antwortPanel.add(button1);
        antwortPanel.add(button2);
        antwortPanel.add(button3);
        antwortPanel.add(button4);


        backgroundPanel.add(frageLabel, BorderLayout.NORTH);
        backgroundPanel.add(antwortPanel, BorderLayout.CENTER);
        backgroundPanel.add(punkteLabel, BorderLayout.SOUTH);

        button1.addActionListener(e -> auswahl(button1.getText()));
        button2.addActionListener(e -> auswahl(button2.getText()));
        button3.addActionListener(e -> auswahl(button3.getText()));
        button4.addActionListener(e -> auswahl(button4.getText()));

        zeigeFrage();

        frame.setLocationRelativeTo(null);
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

            punkte++;

            punkteLabel.setText("Punkte: " + punkte);

            JOptionPane.showMessageDialog(
                    frame,
                    "Richtig!"
            );

        } else {

            JOptionPane.showMessageDialog(
                    frame,
                    "Falsch!\nDie richtige Antwort lautet:\n"
                            + frage.getKorrekteAntwort()
            );
        }

        quizManager.naechsteFrage();

        if (quizManager.hatMehrFragen()) {

            zeigeFrage();

        } else {

            JOptionPane.showMessageDialog(
                    frame,
                    "Quiz beendet!\n\n"
                            + "Du hast "
                            + punkte
                            + " von 10 Punkten erreicht."
            );

            frame.dispose();
        }
    }
}
