import javax.swing.*;
import java.awt.*;

public class QuizWindow {



    private JFrame frame;
    private JLabel questionLabel;
    private JLabel pointLabel;

    //Erstellt Buttons
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private QuizManager quizManager;

    private int points = 0;

    //Konstruktor des Quizwindows (erstellen)
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

                Color startColor = Color.ORANGE;
                Color endColor = Color.GREEN;

                GradientPaint verlauf = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
                g2d.setPaint(verlauf);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.setContentPane(backgroundPanel);


        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 22));

        pointLabel = new JLabel("Punkte: 0", SwingConstants.CENTER);
        pointLabel.setFont(new Font("Arial", Font.BOLD, 18));
        pointLabel.setForeground(Color.WHITE);

        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);

        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);

        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(2, 2, 15, 15));


        answerPanel.setOpaque(false);

        answerPanel.add(button1);
        answerPanel.add(button2);
        answerPanel.add(button3);
        answerPanel.add(button4);


        backgroundPanel.add(questionLabel, BorderLayout.NORTH);
        backgroundPanel.add(answerPanel, BorderLayout.CENTER);
        backgroundPanel.add(pointLabel, BorderLayout.SOUTH);

        button1.addActionListener(e -> selection(button1.getText()));
        button2.addActionListener(e -> selection(button2.getText()));
        button3.addActionListener(e -> selection(button3.getText()));
        button4.addActionListener(e -> selection(button4.getText()));

        showQuestion();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
//zeigt die frage an
    private void showQuestion() {

        Question question = quizManager.getCurrentQuestion();

        if (question == null) {
            return;
        }

        questionLabel.setText(question.getText());

        String[] answers = question.getAnswers();

        button1.setText(answers[0]);
        button2.setText(answers[1]);
        button3.setText(answers[2]);
        button4.setText(answers[3]);

        button4.setVisible(!answers[3].equals("- Nicht belegt -"));
    }

//Auswahl
    private void selection(String chosenQuestion) {

        Question question = quizManager.getCurrentQuestion();

        if (question.isCorrect(chosenQuestion)) {

            points++;

            pointLabel.setText("Punkte: " + points);

            JOptionPane.showMessageDialog(
                    frame,
                    "Richtig!"
            );

        } else {

            JOptionPane.showMessageDialog(
                    frame,
                    "Falsch!\nDie richtige Antwort lautet:\n"
                            + question.getCorrectAnswer()
            );
        }

        quizManager.nextQuestion();

        if (quizManager.moreQuestions()) {

            showQuestion();

        } else {

            JOptionPane.showMessageDialog(
                    frame,
                    "Quiz beendet!\n\n"
                            + "Du hast "
                            + points
                            + " von 10 Punkten erreicht."
            );

            frame.dispose();
        }
    }
}
