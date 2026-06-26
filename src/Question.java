public class Question {
    private String text;
    private String[] answers;
    private String correctAnswer;

    public Question(String text,
                    String antwort1,
                    String antwort2,
                    String antwort3,
                    String antwort4,
                    String correctAnswer) {

        this.text = text;
        this.answers = new String[]{
                antwort1,
                antwort2,
                antwort3,
                antwort4
        };
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(String gewaehlteAntwort) {
        return correctAnswer.equals(gewaehlteAntwort);
    }
}