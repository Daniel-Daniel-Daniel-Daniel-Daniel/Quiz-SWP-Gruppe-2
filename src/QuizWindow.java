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
    private JButton button4;

    private int frageNummer = 1;

    public QuizWindow() {
        frame = new JFrame("Das große SWP-Quiz");
        frame.setSize(650, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        frageLabel = new JLabel("Frage 1: Was ist die Hauptstadt von Burkina Faso?");
        button1 = new JButton("Luanda");
        button2 = new JButton("Ouagadougou");
        button3 = new JButton("Yamoussoukro");
        button4 = new JButton("Nouakchott");

        frame.add(frageLabel);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswahl(button1.getText());
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswahl(button2.getText());
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswahl(button3.getText());
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswahl(button4.getText());
            }
        });

        frame.setVisible(true);
    }

    private void resetButtonColors(){
        button1.setBackground(null);
        button2.setBackground(null);
        button3.setBackground(null);
        button4.setBackground(null);
    }

    private void auswahl(String gewaehlteAntwort) {

        if (frageNummer == 1) {
            if (gewaehlteAntwort.equals("Ouagadougou")) {
                button2.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Richtig! Ouagadougou ist korrekt!");
                resetButtonColors();
            } else {
                JOptionPane.showMessageDialog(frame, "Falsch! Die richtige Antwort ist Ouagadougou.");
            }


            frageNummer = 2;
            frageLabel.setText("Frage 2: Was ist der Unterschied zwischen einem Compiler und einem Interpreter?");
            button1.setText("Compiler übersetzt alles vorab / Interpreter Zeile für Zeile");
            button2.setText("Interpreter übersetzt alles vorab / Compiler Zeile für Zeile");
            button3.setText("Es gibt überhaupt keinen Unterschied");
            button4.setVisible(false);
            return;
        }

        if (frageNummer == 2) {
            if (gewaehlteAntwort.equals("Compiler übersetzt alles vorab / Interpreter Zeile für Zeile")) {
                button2.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Richtig! Compiler macht alles auf einmal.");
                resetButtonColors();
            } else {
                JOptionPane.showMessageDialog(frame, "Falsch! Der Compiler übersetzt den gesamten Code vorab.");
            }

            frageNummer = 3;
            frageLabel.setText("Frage 3: Was ist das Land mit der höchsten Durchschnittshöhe?");
            button1.setText("Nepal");
            button2.setText("Lesotho");
            button3.setText("Bhutan");
            button4.setVisible(true);
            button4.setText("Tadschikistan");
            return;
        }

        if (frageNummer == 3) {
            if (gewaehlteAntwort.equals("Bhutan")) {
                button3.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Richtig! Bhutan hat weltweit die höchste durchschnittliche Geländehöhe.");
                resetButtonColors();
            } else {
                JOptionPane.showMessageDialog(frame, "Falsch! Die richtige Antwort ist Bhutan.");
            }

            frageNummer = 4;
            frageLabel.setText("Frage 4: Was unterscheidet ein Array von einer Liste?");
            button1.setText("Eine Liste hat immer eine feste Größe");
            button2.setText("Ein Array hat eine feste Größe, Listen sind dynamisch");
            button3.setText("Arrays können dynamisch wachsen");
            button4.setVisible(false);
            return;
        }

        if (frageNummer == 4) {
            if (gewaehlteAntwort.equals("Ein Array hat eine feste Größe, Listen sind dynamisch")) {
                button2.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Richtig! Listen können flexibel wachsen.");
                resetButtonColors();
            } else {
                JOptionPane.showMessageDialog(frame, "Leider falsch! Arrays besitzen eine feste Größe.");
            }

            frageNummer = 5;
            frageLabel.setText("Frage 5: Zwischen welchen Ländern liegt der Kilimandscharo?");
            button1.setText("Tansania/Kenya");
            button2.setText("Äthiopien/Somalia");
            button3.setText("Ägypten/Israel");
            button4.setVisible(true);
            button4.setText("Gabun/Kongo");
            return;
        }

        if (frageNummer == 5) {
            if (gewaehlteAntwort.equals("Tansania/Kenya")) {
                button1.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Richtig! Er befindet sich an der Grenze von Tansania und Kenia.");
                resetButtonColors();
            } else {
                JOptionPane.showMessageDialog(frame, "Falsch! Richtige Antwort ist Tansania/Kenya.");
            }

            frageNummer = 6;
            frageLabel.setText("Frage 6: Was bedeutet der Datentyp 'Boolean'?");
            button1.setText("Ein Text-Datentyp für Wörter");
            button2.setText("Ein Datentyp für Zahlen mit Komma");
            button3.setText("Ein logischer Datentyp für true oder false");
            button4.setVisible(false);
            return;
        }

        if (frageNummer == 6) {
            if (gewaehlteAntwort.equals("Ein logischer Datentyp für true oder false")) {
                button3.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Richtig! Ein Boolean kennt nur wahr oder falsch.");
                resetButtonColors();
            } else {
                JOptionPane.showMessageDialog(frame, "Falsch! Er steht ausschließlich für true oder false.");
            }

            frageNummer = 7;
            frageLabel.setText("Frage 7: Wie viele Spieler stehen beim Basketball auf dem Platz?");
            button1.setText("6");
            button2.setText("3");
            button3.setText("5");
            button4.setVisible(true);
            button4.setText("7");
            return;
        }

        if (frageNummer == 7) {
            if (gewaehlteAntwort.equals("5")) {
                button3.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Richtig! Es stehen pro Team 5 Feldspieler auf dem Platz.");
                resetButtonColors();
            } else {
                JOptionPane.showMessageDialog(frame, "Falsch! Es sind 5 Spieler.");
            }

            frageNummer = 8;
            frageLabel.setText("Frage 8: Wer schrieb den Roman „1984“?");
            button1.setText("Franz Kafka");
            button2.setText("George Orwell");
            button3.setText("Karl Marx");
            button4.setText("Shawn Carter");
            return;
        }

        if (frageNummer == 8) {
            if (gewaehlteAntwort.equals("George Orwell")) {
                button2.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Richtig! George Orwell schrieb diesen weltbekannten Roman.");
                resetButtonColors();
            } else {
                JOptionPane.showMessageDialog(frame, "Falsch! Der Autor heißt George Orwell.");
            }

            frageNummer = 9;
            frageLabel.setText("Frage 9: Wer malte das Bild „Mona Lisa“?");
            button1.setText("Jean-Michel Basquiat");
            button2.setText("Michelangelo Buonarroti");
            button3.setText("Pablo Picasso");
            button4.setText("Leonardo Da Vinci");
            return;
        }

        if (frageNummer == 9) {
            if (gewaehlteAntwort.equals("Leonardo Da Vinci")) {
                button4.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Absolut richtig! Leonardo Da Vinci hat sie weltberühmt gemacht.");
                resetButtonColors();
            } else {
                JOptionPane.showMessageDialog(frame, "Falsch! Es war Leonardo Da Vinci.");
            }

            frageNummer = 10;
            frageLabel.setText("Frage 10: Für was steht die Abkürzung 'USB'?");
            button1.setText("Universal Serial Bus");
            button2.setText("United Serial Button");
            button3.setText("Ultra Speed Bus");
            button4.setVisible(false);
            return;
        }

        if (frageNummer == 10) {
            if (gewaehlteAntwort.equals("Universal Serial Bus")) {
                button1.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(frame, "Korrekt! USB bedeutet Universal Serial Bus.");
                resetButtonColors();
            } else {
                JOptionPane.showMessageDialog(frame, "Leider fasch!");
            }


            JOptionPane.showMessageDialog(frame, "Du hast die gemischte Runde mit 10 Fragen geschafft! Quiz beendet.");
            frame.dispose();
        }
    }
}