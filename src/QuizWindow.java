import javax.swing.*;
import java.awt.*;

public class QuizWindow {

    // Hauptfenster des Quiz
    private JFrame frame;

    // Zeigt die aktuelle Frage an
    private JLabel questionLabel;

    // Zeigt die aktuelle Punktzahl an
    private JLabel pointLabel;

    // Antwortbuttons
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    // Verwaltet Fragen und Quizablauf
    private QuizManager quizManager;

    // Speichert die erreichten Punkte
    private int points = 0;

    // Konstruktor: Erstellt das komplette Quizfenster
    public QuizWindow() {

        quizManager = new QuizManager();

        // Fenster erstellen
        frame = new JFrame("Das große SWP-Quiz");
        frame.setSize(850, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hintergrundpanel mit Farbverlauf
        JPanel backgroundPanel = new JPanel(new BorderLayout(15, 15)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);

                Color startColor = Color.ORANGE;
                Color endColor = Color.GREEN;

                // Farbverlauf zeichnen
                GradientPaint verlauf =
                        new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);

                g2d.setPaint(verlauf);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // Abstand zum Fensterrand
        backgroundPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.setContentPane(backgroundPanel);

        // Frageanzeige
        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 22));

        // Punkteanzeige
        pointLabel = new JLabel("Punkte: 0", SwingConstants.CENTER);
        pointLabel.setFont(new Font("Arial", Font.BOLD, 18));
        pointLabel.setForeground(Color.WHITE);

        // Antwortbuttons erstellen
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);

        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);

        // Panel für die Antwortmöglichkeiten
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(2, 2, 15, 15));
        answerPanel.setOpaque(false);

        // Buttons zum Panel hinzufügen
        answerPanel.add(button1);
        answerPanel.add(button2);
        answerPanel.add(button3);
        answerPanel.add(button4);

        // Komponenten im Fenster platzieren
        backgroundPanel.add(questionLabel, BorderLayout.NORTH);
        backgroundPanel.add(answerPanel, BorderLayout.CENTER);
        backgroundPanel.add(pointLabel, BorderLayout.SOUTH);

        // Klickereignisse der Buttons
        button1.addActionListener(e -> selection(button1.getText()));
        button2.addActionListener(e -> selection(button2.getText()));
        button3.addActionListener(e -> selection(button3.getText()));
        button4.addActionListener(e -> selection(button4.getText()));

        // Erste Frage anzeigen
        showQuestion();

        // Fenster zentrieren und anzeigen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Zeigt die aktuelle Frage und ihre Antworten an
    private void showQuestion() {

        Question question = quizManager.getCurrentQuestion();

        // Falls keine Frage vorhanden ist
        if (question == null) {
            return;
        }

        // Fragetext setzen
        questionLabel.setText(question.getText());

        // Antworten laden
        String[] answers = question.getAnswers();

        // Antworten auf die Buttons verteilen
        button1.setText(answers[0]);
        button2.setText(answers[1]);
        button3.setText(answers[2]);
        button4.setText(answers[3]);

        // Vierten Button nur anzeigen, wenn eine vierte Antwort existiert
        button4.setVisible(!answers[3].equals("- Nicht belegt -"));
    }

    // Wird aufgerufen, wenn eine Antwort ausgewählt wurde
    private void selection(String chosenQuestion) {

        Question question = quizManager.getCurrentQuestion();

        // Prüfen, ob die Antwort richtig ist
        if (question.isCorrect(chosenQuestion)) {

            // Punkt erhöhen
            points++;

            // Punkteanzeige aktualisieren
            pointLabel.setText("Punkte: " + points);

            // Meldung anzeigen
            JOptionPane.showMessageDialog(
                    frame,
                    "Richtig!"
            );

        } else {

            // Richtige Antwort anzeigen
            JOptionPane.showMessageDialog(
                    frame,
                    "Falsch!\nDie richtige Antwort lautet:\n"
                            + question.getCorrectAnswer()
            );
        }

        // Zur nächsten Frage wechseln
        quizManager.nextQuestion();

        // Falls noch Fragen vorhanden sind
        if (quizManager.moreQuestions()) {

            showQuestion();

        } else {

            // Endergebnis anzeigen oder so
            JOptionPane.showMessageDialog(
                    frame,
                    "Quiz beendet!\n\n"
                            + "Du hast "
                            + points
                            + " von 10 Punkten erreicht."
            );

            // Fenster schließen
            frame.dispose();
        }
    }
}