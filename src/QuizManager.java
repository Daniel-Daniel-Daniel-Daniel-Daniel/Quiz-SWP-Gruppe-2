import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private List<Frage> fragenListe;
    private int aktuelleFrageIndex;

    public QuizManager() {
        fragenListe = new ArrayList<>();
        aktuelleFrageIndex = 0;
        initFragen();
    }

    private void initFragen() {
        // --- FRAGE 1 ---
        fragenListe.add(new Frage(
                "Frage 1: Was ist die Hauptstadt von Burkina Faso?",
                "Luanda", "Ouagadougou", "Yamoussoukro", "Nouakchott",
                "Ouagadougou"
        ));

        // --- FRAGE 2 ---
        fragenListe.add(new Frage(
                "Frage 2: Was ist der Unterschied zwischen einem Compiler und einem Interpreter?",
                "Compiler übersetzt alles vorab / Interpreter Zeile für Zeile",
                "Interpreter übersetzt alles vorab / Compiler Zeile für Zeile",
                "Es gibt überhaupt keinen Unterschied",
                "- Nicht belegt -",
                "Compiler übersetzt alles vorab / Interpreter Zeile für Zeile"
        ));

        // --- FRAGE 3 ---
        fragenListe.add(new Frage(
                "Frage 3: Was ist das Land mit der höchsten Durchschnittshöhe?",
                "Nepal", "Lesotho", "Bhutan", "Tadschikistan",
                "Bhutan"
        ));

        // --- FRAGE 4 ---
        fragenListe.add(new Frage(
                "Frage 4: Was unterscheidet ein Array von einer Liste?",
                "Eine Liste hat immer eine feste Größe",
                "Ein Array hat eine feste Größe, Listen sind dynamisch",
                "Arrays können dynamisch wachsen",
                "- Nicht belegt -",
                "Ein Array hat eine feste Größe, Listen sind dynamisch"
        ));

        // --- FRAGE 5 ---
        fragenListe.add(new Frage(
                "Frage 5: Zwischen welchen Ländern liegt der Kilimandscharo?",
                "Tansania/Kenya", "Äthiopien/Somalia", "Ägypten/Israel", "Gabun/Kongo",
                "Tansania/Kenya"
        ));

        // --- FRAGE 6 ---
        fragenListe.add(new Frage(
                "Frage 6: Was bedeutet der Datentyp 'Boolean'?",
                "Ein Text-Datentyp für Wörter",
                "Ein Datentyp für Zahlen mit Komma",
                "Ein logischer Datentyp für true oder false",
                "- Nicht belegt -",
                "Ein logischer Datentyp für true oder false"
        ));

        // --- FRAGE 7 ---
        fragenListe.add(new Frage(
                "Frage 7: Wie viele Spieler stehen beim Basketball auf dem Platz?",
                "6", "3", "5", "7",
                "5"
        ));

        // --- FRAGE 8 ---
        fragenListe.add(new Frage(
                "Frage 8: Wer schrieb den Roman „1984“?",
                "Franz Kafka", "George Orwell", "Karl Marx", "Shawn Carter",
                "George Orwell"
        ));

        // --- FRAGE 9 ---
        fragenListe.add(new Frage(
                "Frage 9: Wer malte das Bild „Mona Lisa“?",
                "Jean-Michel Basquiat", "Michelangelo Buonarroti", "Pablo Picasso", "Leonardo Da Vinci",
                "Leonardo Da Vinci"
        ));

        // --- FRAGE 10 ---
        fragenListe.add(new Frage(
                "Frage 10: Für was steht die Abkürzung 'USB'?",
                "Universal Serial Bus", "United Serial Button", "Ultra Speed Bus", "- Nicht belegt -",
                "Universal Serial Bus"
        ));
    }

    public Frage getAktuelleFrage() {
        if (aktuelleFrageIndex < fragenListe.size()) {
            return fragenListe.get(aktuelleFrageIndex);
        }
        return null; // Keine Fragen mehr übrig
    }

    public void naechsteFrage() {
        aktuelleFrageIndex++;
    }

    public boolean hatMehrFragen() {
        return aktuelleFrageIndex < fragenListe.size();
    }
}