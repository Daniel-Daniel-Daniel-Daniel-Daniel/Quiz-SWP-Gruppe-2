import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    private List<Question> fragenListe;
    private int aktuelleFrage;

    public QuizManager() {
        fragenListe = new ArrayList<>();
        aktuelleFrage = 0;
        initFragen();
    }

    private void initFragen() {

        fragenListe.add(new Question(
                "Frage 1: Was ist die Hauptstadt von Burkina Faso?",
                "Luanda",
                "Ouagadougou",
                "Yamoussoukro",
                "Nouakchott",
                "Ouagadougou"
        ));

        fragenListe.add(new Question(
                "Frage 2: Was ist der Unterschied zwischen einem Compiler und einem Interpreter?",
                "Compiler übersetzt alles vorab / Interpreter Zeile für Zeile",
                "Interpreter übersetzt alles vorab / Compiler Zeile für Zeile",
                "Es gibt überhaupt keinen Unterschied",
                "- Nicht belegt -",
                "Compiler übersetzt alles vorab / Interpreter Zeile für Zeile"
        ));

        fragenListe.add(new Question(
                "Frage 3: Was ist das Land mit der höchsten Durchschnittshöhe?",
                "Nepal",
                "Lesotho",
                "Bhutan",
                "Tadschikistan",
                "Bhutan"
        ));

        fragenListe.add(new Question(
                "Frage 4: Was unterscheidet ein Array von einer Liste?",
                "Eine Liste hat immer eine feste Größe",
                "Ein Array hat eine feste Größe, Listen sind dynamisch",
                "Arrays können dynamisch wachsen",
                "- Nicht belegt -",
                "Ein Array hat eine feste Größe, Listen sind dynamisch"
        ));

        fragenListe.add(new Question(
                "Frage 5: Zwischen welchen Ländern liegt der Kilimandscharo?",
                "Tansania/Kenya",
                "Äthiopien/Somalia",
                "Ägypten/Israel",
                "Gabun/Kongo",
                "Tansania/Kenya"
        ));

        fragenListe.add(new Question(
                "Frage 6: Was bedeutet der Datentyp Boolean?",
                "Ein Text-Datentyp für Wörter",
                "Ein Datentyp für Zahlen mit Komma",
                "Ein logischer Datentyp für true oder false",
                "- Nicht belegt -",
                "Ein logischer Datentyp für true oder false"
        ));

        fragenListe.add(new Question(
                "Frage 7: Wie viele Spieler stehen beim Basketball auf dem Platz?",
                "6",
                "3",
                "5",
                "7",
                "5"
        ));

        fragenListe.add(new Question(
                "Frage 8: Wer schrieb den Roman 1984?",
                "Franz Kafka",
                "George Orwell",
                "Karl Marx",
                "Shawn Carter",
                "George Orwell"
        ));

        fragenListe.add(new Question(
                "Frage 9: Wer malte die Mona Lisa?",
                "Jean-Michel Basquiat",
                "Michelangelo Buonarroti",
                "Pablo Picasso",
                "Leonardo Da Vinci",
                "Leonardo Da Vinci"
        ));

        fragenListe.add(new Question(
                "Frage 10: Für was steht die Abkürzung USB?",
                "Universal Serial Bus",
                "United Serial Button",
                "Ultra Speed Bus",
                "- Nicht belegt -",
                "Universal Serial Bus"
        ));
    }

    public Question getAktuelleFrage() {
        if (aktuelleFrage < fragenListe.size()) {
            return fragenListe.get(aktuelleFrage);
        }
        return null;
    }

    public void naechsteFrage() {
        aktuelleFrage++;
    }

    public boolean hatMehrFragen() {
        return aktuelleFrage < fragenListe.size();
    }
}