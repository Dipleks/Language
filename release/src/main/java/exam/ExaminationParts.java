package exam;

import control.ButtonsMenu;
import interfaceRoot.ArgumentsExercise;
import interfaceRoot.EffectColor;
import interfaceRoot.EffectFont;
import interfaceRoot.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import static interfaceRoot.ArgumentsExam.*;

public class ExaminationParts extends ButtonsMenu implements Root, ArgumentsExercise
{


    public void examMethod(final Exams[] exam, final Button[] buttonExam, IExam iExam){

        buttonListExam();

        for (int i = 0; i < buttonExam.length; i++) {
            buttonExam[i] = new Button();
            buttonExam[i].setText("Часть №" + (i + 1));
            buttonExam[i].setPrefWidth(widthSize-widthSize/1.06);
            buttonExam[i].setPrefHeight(widthSize-widthSize/1.03);
            int finalI = i;
            buttonExam[i].setOnAction(event -> {

                nameExam.setText(buttonExam[finalI].getText());
                nameExam.setFont(EffectFont.getFontTextExam());
                nameExam.setTextFill(EffectColor.getColorText());

                soundClick.soundClick();
                groupRadBut.setSpacing(widthSize-widthSize/1.03);
//                groupRadBut.setStyle("-fx-border-color: RED");
                groupRadBut.setPadding(new Insets(10, 10, 10, 10));
                groupRadBut.setLayoutX(widthSize-widthSize/2.8);
                groupRadBut.setLayoutY(heightSize-heightSize/1.09);
                ROOT.getChildren().addAll(groupRadBut);
                exitInMenu.setOnAction(e -> iExam.clearExams());
                exam[finalI].getExamList(iExam);
                ROOT.getChildren().remove(getLengthButtonExam());
                ROOT.getChildren().removeAll(getExamL());
                getLengthButtonExam().getChildren().removeAll(buttonExam);
            });
        }
//        lengthButtonQues.setStyle("-fx-border-color: RED");
        getLengthButtonExam().setSpacing(widthSize-widthSize/1.03);
        getLengthButtonExam().setPrefWidth((buttonExam[0].getPrefWidth()+getLengthButtonExam().getSpacing())*buttonExam.length);
        getLengthButtonExam().setLayoutX(widthSize/2-((getLengthButtonExam().getPrefWidth())/2));
        getLengthButtonExam().setLayoutY(getLengthButtonQues().getLayoutY()+heightSize-heightSize/1.2);
        getLengthButtonExam().setPadding(new Insets(10, 10, 10, 10));
        getLengthButtonExam().getChildren().addAll(buttonExam);
        ROOT.getChildren().addAll(getLengthButtonExam());
    }
}
