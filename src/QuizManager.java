import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    private List<Question> questionList;
    private int currentQuestion;

    public QuizManager() {
        questionList = new ArrayList<>();
        currentQuestion = 0;
        initFragen();
    }

    private void initFragen() {

        questionList.add(new Question(
                "Frage 1: Was ist die Hauptstadt von Burkina Faso?",
                "Luanda",
                "Ouagadougou",
                "Yamoussoukro",
                "Nouakchott",
                "Ouagadougou"
        ));

        questionList.add(new Question(
                "Frage 2: Wie viele Einwohner hat Reutte?",
                "6200",
                "9100",
                "7300",
                "- Nicht belegt -",
                "7300"
        ));

        questionList.add(new Question(
                "Frage 3: Was ist das Land mit der höchsten Durchschnittshöhe?",
                "Nepal",
                "Lesotho",
                "Bhutan",
                "Tadschikistan",
                "Bhutan"
        ));

        questionList.add(new Question(
                "Frage 4: Was unterscheidet ein Array von einer Liste?",
                "Eine Liste hat immer eine feste Größe",
                "Array --> feste Größe, Listen --> dynamisch",
                "Arrays können dynamisch wachsen",
                "- Nicht belegt -",
                "Array --> feste Größe, Listen --> dynamisch"
        ));

        questionList.add(new Question(
                "Frage 5: Zwischen welchen Ländern liegt der Kilimandscharo?",
                "Tansania/Kenya",
                "Äthiopien/Somalia",
                "Ägypten/Israel",
                "Gabun/Kongo",
                "Tansania/Kenya"
        ));

        questionList.add(new Question(
                "Frage 6: Was bedeutet der Datentyp Boolean?",
                "Ein Text-Datentyp für Wörter",
                "Ein Datentyp für Zahlen mit Komma",
                "Ein logischer Datentyp für true oder false",
                "- Nicht belegt -",
                "Ein logischer Datentyp für true oder false"
        ));

        questionList.add(new Question(
                "Frage 7: Wie viele Spieler stehen beim Basketball auf dem Platz?",
                "6",
                "3",
                "5",
                "7",
                "5"
        ));

        questionList.add(new Question(
                "Frage 8: Wer schrieb den Roman 1984?",
                "Franz Kafka",
                "George Orwell",
                "Karl Marx",
                "Shawn Carter",
                "George Orwell"
        ));

        questionList.add(new Question(
                "Frage 9: Wer malte die Mona Lisa?",
                "Jean-Michel Basquiat",
                "Michelangelo Buonarroti",
                "Pablo Picasso",
                "Leonardo Da Vinci",
                "Leonardo Da Vinci"
        ));

        questionList.add(new Question(
                "Frage 10: Für was steht die Abkürzung USB?",
                "Universal Serial Bus",
                "United Serial Button",
                "Ultra Speed Bus",
                "- Nicht belegt -",
                "Universal Serial Bus"
        ));
    }

    public Question getCurrentQuestion() {
        if (currentQuestion < questionList.size()) {
            return questionList.get(currentQuestion);
        }
        return null;
    }

    public void nextQuestion() {
        currentQuestion++;
    }

    public boolean moreQuestions() {
        return currentQuestion < questionList.size();
    }
}