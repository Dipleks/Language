package exam;

import interfaceRoot.EffectColor;
import interfaceRoot.EffectFont;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;

import static interfaceRoot.Root.soundClick;
import static interfaceRoot.Root.widthSize;

public class Numerations
{
    protected void numberingOfExam(Label[] labels, Label[] arrayOfOffersExam, int START, IExam iExam){
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new Label();
            labels[i].setFont(EffectFont.getFontTextExam());
            labels[i].setTextFill(EffectColor.getColorTitle());
//                    number[i].setStyle("-fx-border-color: RED");
            labels[i].setPrefWidth(widthSize-widthSize/1.45);
            labels[i].setAlignment(Pos.CENTER);
            labels[i].setCursor(Cursor.HAND);
            labels[i].setText("-"+(i+1+START)+"-");
            int finalI = i;
            labels[i].setOnMouseClicked(ev -> {
                soundClick.soundClick();
                if (arrayOfOffersExam[finalI].getText().equals(iExam.getExamRUS(finalI, START))){
                    arrayOfOffersExam[finalI].setText(iExam.getExamENG(finalI, START));
                    arrayOfOffersExam[finalI].setTextFill(EffectColor.getColorTextImpr());
                }
            });
        }
    }
}
