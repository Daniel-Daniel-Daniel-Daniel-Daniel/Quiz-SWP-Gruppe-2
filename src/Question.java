public class Question {
    private String text;
    private String[] answers;
    private String correctAnswer;

    public Question(String text,                //Konstruktor für die Frage
                    String antwort1,
                    String antwort2,
                    String antwort3,
                    String antwort4,
                    String correctAnswer) {

        this.text = text;
        this.answers = new String[]{            //Antwortmöglichkeiten werden zu einem Array zusammengefasst
                antwort1,
                antwort2,
                antwort3,
                antwort4
        };
        this.correctAnswer = correctAnswer;     //korrekte Antwort wird gespeichert
    }

    public String getText() {                   //holt die Frage
        return text;
    }

    public String[] getAnswers() {              //holt die Antwortmöglichkeiten
        return answers;
    }

    public String getCorrectAnswer() {          //holt die richtige Antwort
        return correctAnswer;
    }

    public boolean isCorrect(String gewaehlteAntwort) {     //Methode zur Überprüfung der Antwort
        return correctAnswer.equals(gewaehlteAntwort);
    }
}