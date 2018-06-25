package exams;

import javafx.scene.layout.HBox;

public class _AddMistakesTable
{
    private String dateTime;
    private String numberText;
    private String originalText;
    private HBox mistakesText;
    private String numberPart;

    public _AddMistakesTable(String dateTime, String numberText, String originalText, HBox mistakesText, String numberPart) {
        this.dateTime = dateTime;
        this.numberText = numberText;
        this.originalText = originalText;
        this.mistakesText = mistakesText;
        this.numberPart = numberPart;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getNumberText() {
        return numberText;
    }

    public String getOriginalText() {
        return originalText;
    }

    public HBox getMistakesText() {
        return mistakesText;
    }

    public String getNumberPart() {
        return numberPart;
    }

    @Override
    public String toString() {
        return "_AddMistakesTable{" +
                "dateTime='" + dateTime + '\'' +
                ", numberText='" + numberText + '\'' +
                ", originalText='" + originalText + '\'' +
                ", mistakesText=" + mistakesText +
                ", numberPart='" + numberPart + '\'' +
                '}';
    }
}
