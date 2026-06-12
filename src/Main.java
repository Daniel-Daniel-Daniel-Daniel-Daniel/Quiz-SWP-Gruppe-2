public class Main {

    // Das ist das Haupttor, durch das Java das Programm startet
    public static void main(String[] args) {

        // Wir erstellen einfach das LoginFenster
        LoginFenster startFenster = new LoginFenster();

        // Und machen es sichtbar, damit der Benutzer sich einloggen kann
        startFenster.setVisible(true);

    }
}