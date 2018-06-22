package exercise;

import interfaceRoot.*;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Класс заполнения колонок упражнений меню "Задания" со свойствами
 * <b>arrayOfOffersLeft</b>, <b>arrayOfOffersRight</b>, <b>START</b>, <b>CLOSE</b>,
 * <b>m</b> и <b>text</b>.
 * @author Загороднев Д.М.
 * @version 2.0
 */
public class Exercises implements ArgumentsExercise
{
    /** Левый столбец с предложениями */
    private Label[] arrayOfOffersLeft;
    /** Правый столбец с предложениями */
    private Label[] arrayOfOffersRight;
    /** Номер предложения с которого начинается столбец */
    private int START;
    /** Номер предложения на котором столбец заканчивается */
    private int CLOSE;
    /** Значение определяющее временную форму предложений (PS, To be,...) */
    private String m;
    /** Класс со списком значений */
    private ExerciseText text = new ExerciseText();

    /**
     * Конструктор создающий новый объект с параметрами
     * @param arrayOfOffersLeft - левый столбец предложений
     * @param arrayOfOffersRight - правый столбец предложений
     * @param START - начало столбца
     * @param CLOSE - конец столбца
     * @param m - временная форма (PS, To be...)
     */
    public Exercises(Label[] arrayOfOffersLeft, Label[] arrayOfOffersRight,
                     int START, int CLOSE, String m) {

        this.arrayOfOffersLeft = arrayOfOffersLeft;
        this.arrayOfOffersRight = arrayOfOffersRight;
        this.START = START;
        this.CLOSE = CLOSE;
        this.m = m;
    }

    /**
     * Метод определяющий язык колонок {@link Exercises#arrayOfOffersLeft#arrayOfOffersRight}
     * @param leftRight - левая/правая колонка
     * @param ENRU - язык английский/русский
     */
    public void getEnRu(String leftRight, String ENRU){
        if (ENRU.equals("EN")) {
            if (leftRight.equals("LEFT")) {
                getColumnLabEn(arrayOfOffersLeft, leftColumn, 6, START, "EN", "RU");
            } else if (leftRight.equals("RIGHT")) {
                getColumnLabEn(arrayOfOffersRight, rightColumn, 1.9, CLOSE, "EN", "RU");
            }
        } else if (ENRU.equals("RU")){
            if (leftRight.equals("LEFT")) {
                getColumnLabEn(arrayOfOffersLeft, leftColumn, 6, START, "RU", "EN");
            } else if (leftRight.equals("RIGHT")){
                getColumnLabEn(arrayOfOffersRight, rightColumn, 1.9, CLOSE, "RU", "EN");
            }
        }
    }

    /**
     * Функция получения значений {@link ExerciseText}
     * @param a - номер предложения
     * @param b - номер ячейки в которую будет помещено значение
     * @param lang - язык значения
     * @return возвращает значение на выбранном языке
     */
    private String methodExercise(int a, int b, String lang){
        if (lang.equals("EN")) {
            switch (m) {
                case "PS":
                    return text.getPsFileEn().get(a + b);
                case "ToBe":
                    return text.getToBeFileEn().get(a + b);
            }
        } else if (lang.equals("RU")) {
            switch (m) {
                case "PS":
                    return text.getPsFileRu().get(a + b);
                case "ToBe":
                    return text.getToBeFileRu().get(a + b);
            }
        }
        return "No files";
    }

    /**
     * Процедура заполнения колонок на выбранном языке {@link Exercises#getEnRu(String, String)}}
     * @param list - поле со значением {@link Exercises#text}
     * @param listCol - колонка в которую заполняются значения
     * @param coordinateX - положение колонки в приложении
     * @param START_CLOSE - номер значения с которого начинается колонка
     * @param set - начальный язык значения
     * @param get - изменённый язык значения
     */
    private void getColumnLabEn(Label[] list, VBox listCol, double coordinateX,
                                int START_CLOSE, String set, String get) {
        for (int i = 0; i < list.length; i++) {
            list[i] = new Label();
            list[i].setFont(EffectFont.getFontText());
            list[i].setTextFill(EffectColor.getColorText());
//            list[i].setStyle("-fx-border-color: RED");
            list[i].setPrefWidth(widthSize-widthSize/1.45);
            list[i].setWrapText(true);
            list[i].setText(methodExercise(i, START_CLOSE, set));

            int finalI = i;
            list[i].setCursor(Cursor.HAND);
            list[i].setOnMouseClicked(event -> {
                soundClick.soundClick();
                if (list[finalI].getText().equals(methodExercise(finalI, START_CLOSE, set))){
                    list[finalI].setText(methodExercise(finalI, START_CLOSE, get));
                    list[finalI].setTextFill(EffectColor.getColorTextClick());
                } else {
                    list[finalI].setText(methodExercise(finalI, START_CLOSE, set));
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