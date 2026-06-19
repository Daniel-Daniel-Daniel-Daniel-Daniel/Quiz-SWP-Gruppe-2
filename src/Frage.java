public class Frage {
    private String text;
    private String[] antworten;
    private String korrekteAntwort;

    public Frage(String text, String antwort1, String antwort2, String antwort3, String antwort4, String korrekteAntwort) {
        this.text = text;
        this.antworten = new String[]{antwort1, antwort2, antwort3, antwort4};
        this.korrekteAntwort = korrekteAntwort;
    }

    public String getText() {
        return text;
    }

    public String[] getAntworten() {
        return antworten;
    }

    public boolean istKorrekt(String gewaehlteAntwort) {
        return korrekteAntwort.equals(gewaehlteAntwort);
    }

    public String getKorrekteAntwort() {
        return korrekteAntwort;
    }
}