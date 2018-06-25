package exercise;

import control.ButtonsMenu;
import interfaceRoot.ArgumentsExam;
import interfaceRoot.ArgumentsExercise;
import interfaceRoot.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class ExerciseParts extends ButtonsMenu implements Root, ArgumentsExercise
{
    public void exercise(final Exercises[] app, final Exercises[] neg, final Exercises[] ques,
                  final Button[] buttonApp, final Button[] buttonNeg, final Button[] buttonQues, IExercises iExercises)
    {
        methodAppNegQues();
        for (int i = 0; i < buttonApp.length; i++) {
            buttonApp[i] = new Button();
            buttonApp[i].setText("Задание " + (i+1));
            buttonApp[i].setPrefWidth(widthSize-widthSize/1.07);
            buttonApp[i].setPrefHeight(widthSize-widthSize/1.03);
            int finalI = i;
            buttonApp[i].setOnAction(event -> {
                soundClick.soundClick();
                radioBut();
                groupButton(app, finalI, iExercises);
                app[finalI].getEnRu("LEFT", "EN", iExercises);
                app[finalI].getEnRu("RIGHT", "EN", iExercises);
                removeBut(getLengthButtonApp(), getLengthButtonNeg(), getLengthButtonQues(), getLengthButtonExam());
                getLengthButtonApp().getChildren().removeAll(buttonApp);
                getLengthButtonNeg().getChildren().removeAll(buttonNeg);
                getLengthButtonQues().getChildren().removeAll(buttonQues);
            });
        }
//          lengthButtonApp.setStyle("-fx-border-color: RED");
        getLengthButtonApp().setSpacing(widthSize-widthSize/1.03);
        getLengthButtonApp().setPrefWidth((buttonApp[0].getPrefWidth()+getLengthButtonApp().getSpacing())*buttonApp.length);
        getLengthButtonApp().setLayoutX(widthSize/2-((getLengthButtonApp().getPrefWidth())/2));
        getLengthButtonApp().setLayoutY(heightSize-heightSize/1.2);
        getLengthButtonApp().setPadding(new Insets(10, 10, 10, 10));
        getLengthButtonApp().getChildren().addAll(buttonApp);
        ROOT.getChildren().addAll(getLengthButtonApp());

        for (int i = 0; i < buttonNeg.length; i++) {
            buttonNeg[i] = new Button();
            buttonNeg[i].setText("Задание " + (i + 1));
            buttonNeg[i].setPrefWidth(widthSize-widthSize/1.07);
            buttonNeg[i].setPrefHeight(widthSize-widthSize/1.03);
            int finalI = i;
            buttonNeg[i].setOnAction(event -> {
                soundClick.soundClick();
                radioBut();
                groupButton(neg, finalI, iExercises);
                neg[finalI].getEnRu("LEFT", "EN", iExercises);
                neg[finalI].getEnRu("RIGHT", "EN", iExercises);
                removeBut(getLengthButtonApp(), getLengthButtonNeg(), getLengthButtonQues(), getLengthButtonExam());
                getLengthButtonApp().getChildren().removeAll(buttonApp);
                getLengthButtonNeg().getChildren().removeAll(buttonNeg);
                getLengthButtonQues().getChildren().removeAll(buttonQues);

            });
        }
//          lengthButtonNeg.setStyle("-fx-border-color: RED");
        getLengthButtonNeg().setSpacing(widthSize-widthSize/1.03);
        getLengthButtonNeg().setPrefWidth((buttonNeg[0].getPrefWidth()+getLengthButtonNeg().getSpacing())*buttonNeg.length);
        getLengthButtonNeg().setLayoutX(widthSize/2-((getLengthButtonNeg().getPrefWidth())/2));
        getLengthButtonNeg().setLayoutY(getLengthButtonApp().getLayoutY()+heightSize-heightSize/1.2);
        getLengthButtonNeg().setPadding(new Insets(10, 10, 10, 10));
        getLengthButtonNeg().getChildren().addAll(buttonNeg);
        ROOT.getChildren().addAll(getLengthButtonNeg());

        for (int i = 0; i < buttonQues.length; i++) {
            buttonQues[i] = new Button();
            buttonQues[i].setText("Задание " + (i + 1));
            buttonQues[i].setPrefWidth(widthSize-widthSize/1.07);
            buttonQues[i].setPrefHeight(widthSize-widthSize/1.03);
            int finalI = i;
            buttonQues[i].setOnAction(event -> {
                soundClick.soundClick();
                radioBut();
                groupButton(ques, finalI, iExercises);
                ques[finalI].getEnRu("LEFT", "EN", iExercises);
                ques[finalI].getEnRu("RIGHT", "EN", iExercises);
                removeBut(getLengthButtonApp(), getLengthButtonNeg(), getLengthButtonQues(), getLengthButtonExam());
                getLengthButtonApp().getChildren().removeAll(buttonApp);
                getLengthButtonNeg().getChildren().removeAll(buttonNeg);
                getLengthButtonQues().getChildren().removeAll(buttonQues);
            });
        }
//          lengthButtonQues.setStyle("-fx-border-color: RED");
        getLengthButtonQues().setSpacing(widthSize-widthSize/1.03);
        getLengthButtonQues().setPrefWidth((buttonQues[0].getPrefWidth()+getLengthButtonQues().getSpacing())*buttonQues.length);
        getLengthButtonQues().setLayoutX(widthSize/2-((getLengthButtonQues().getPrefWidth())/2));
        getLengthButtonQues().setLayoutY(getLengthButtonNeg().getLayoutY()+heightSize-heightSize/1.2);
        getLengthButtonQues().setPadding(new Insets(10, 10, 10, 10));
        getLengthButtonQues().getChildren().addAll(buttonQues);
        ROOT.getChildren().addAll(getLengthButtonQues());
    }

}
