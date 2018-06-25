package exercise;

import interfaceRoot.*;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Exercises implements ArgumentsExercise
{
    private Label[] arrayOfOffersLeft;
    private Label[] arrayOfOffersRight;
    private int START;
    private int CLOSE;

    public Exercises(Label[] arrayOfOffersLeft, Label[] arrayOfOffersRight,
                     int START, int CLOSE) {

        this.arrayOfOffersLeft = arrayOfOffersLeft;
        this.arrayOfOffersRight = arrayOfOffersRight;
        this.START = START;
        this.CLOSE = CLOSE;
    }
    public void getEnRu(String leftRight, String ENRU, IExercises iExercises){
        if (ENRU.equals("EN")) {
            if (leftRight.equals("LEFT")) {
                getColumnLabEn(arrayOfOffersLeft, leftColumn, 6, START, "EN", "RU", iExercises);
            } else if (leftRight.equals("RIGHT")) {
                getColumnLabEn(arrayOfOffersRight, rightColumn, 1.9, CLOSE, "EN", "RU", iExercises);
            }
        } else if (ENRU.equals("RU")){
            if (leftRight.equals("LEFT")) {
                getColumnLabEn(arrayOfOffersLeft, leftColumn, 6, START, "RU", "EN", iExercises);
            } else if (leftRight.equals("RIGHT")){
                getColumnLabEn(arrayOfOffersRight, rightColumn, 1.9, CLOSE, "RU", "EN", iExercises);
            }
        }
    }

    private void getColumnLabEn(Label[] list, VBox listCol, double coordinateX,
                                int START_CLOSE, String set, String get, IExercises iExercises) {
        for (int i = 0; i < list.length; i++) {
            list[i] = new Label();
            list[i].setFont(EffectFont.getFontText());
            list[i].setTextFill(EffectColor.getColorText());
//            list[i].setStyle("-fx-border-color: RED");
            list[i].setPrefWidth(widthSize-widthSize/1.45);
            list[i].setWrapText(true);
            list[i].setText(iExercises.methodExercise(i, START_CLOSE, set));

            int finalI = i;
            list[i].setCursor(Cursor.HAND);
            list[i].setOnMouseClicked(event -> {
                soundClick.soundClick();
                if (list[finalI].getText().equals(iExercises.methodExercise(finalI, START_CLOSE, set))){
                    list[finalI].setText(iExercises.methodExercise(finalI, START_CLOSE, get));
                    list[finalI].setTextFill(EffectColor.getColorTextClick());
                } else {
                    list[finalI].setText(iExercises.methodExercise(finalI, START_CLOSE, set));
                    list[finalI].setTextFill(EffectColor.getColorText());
                }
            });
        }
//        listCol.setStyle("-fx-border-color: RED");
        listCol.setSpacing(heightSize-heightSize/1.009);
        listCol.setLayoutX(widthSize/coordinateX);
        listCol.setLayoutY(heightSize-heightSize/1.12);
        listCol.setPadding(new Insets(0, 0, 0, 0));
        listCol.setPrefSize(widthSize/3.2, heightSize/1.25);
        listCol.getChildren().addAll(list);

        ROOT.getChildren().addAll(listCol);
    }
}