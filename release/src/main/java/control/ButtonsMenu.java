package control;

import exercise.Exercises;
import exercise.IExercises;
import interfaceRoot.ClockDisplay;
import interfaceRoot.EffectColor;
import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

import static interfaceRoot.ArgumentsExercise.groupRadBut;
import static interfaceRoot.Root.*;

public class ButtonsMenu
{
    private HBox lengthButtonApp = new HBox();
    private HBox lengthButtonNeg = new HBox();
    private HBox lengthButtonQues = new HBox();
    private HBox lengthButtonExam = new HBox();

    private ToggleGroup group = new ToggleGroup();
    private RadioButton enBut = new RadioButton("English");
    private RadioButton ruBut = new RadioButton("Русский");
    private RadioButton exit = new RadioButton("В меню");

    private Label appL = new Label();
    private Label negL = new Label();
    private Label quesL = new Label();
    private Label examL = new Label();

    public RadioButton getEnBut() {
        return enBut;
    }

    public RadioButton getRuBut() {
        return ruBut;
    }

    public Label getExamL() {
        return examL;
    }

    public HBox getLengthButtonApp() {
        return lengthButtonApp;
    }

    public HBox getLengthButtonNeg() {
        return lengthButtonNeg;
    }

    public HBox getLengthButtonQues() {
        return lengthButtonQues;
    }

    public HBox getLengthButtonExam() {
        return lengthButtonExam;
    }

    protected void radioBut(){
        enBut.setToggleGroup(group);
        enBut.setSelected(true);
        ruBut.setToggleGroup(group);
        groupRadBut.getChildren().addAll(enBut, ruBut, exit);
        groupRadBut.setSpacing(widthSize-widthSize/1.03);
//        groupRadBut.setStyle("-fx-border-color: RED");
        groupRadBut.setPadding(new Insets(10, 10, 10, 10));
        groupRadBut.setLayoutX(widthSize-widthSize/1.5);
        groupRadBut.setLayoutY(heightSize-heightSize/1.04);
        ROOT.getChildren().addAll(groupRadBut);
    }
    protected void removeBut(HBox lengthButtonApp, HBox lengthButtonNeg, HBox lengthButtonQues, HBox lengthButtonExam){
        ROOT.getChildren().remove(lengthButtonApp);
        ROOT.getChildren().remove(lengthButtonNeg);
        ROOT.getChildren().remove(lengthButtonQues);
        ROOT.getChildren().remove(lengthButtonExam);
        ROOT.getChildren().removeAll(appL, negL, quesL, examL);
    }
    protected void methodAppNegQues(){

        appL.setText("Утверждения");
//        appL.setStyle("-fx-border-color: RED");
        appL.setPrefWidth(widthSize-widthSize/1.25);
        appL.setAlignment(Pos.CENTER);
        appL.setFont(EffectFont.getFontTitle());
        appL.setTextFill(EffectColor.getColorTitle());
        appL.setLayoutX((widthSize/2)-(widthSize-widthSize/1.25)/2);
        appL.setLayoutY(heightSize-heightSize/1.15);

        negL.setText("Отрицания");
//        negL.setStyle("-fx-border-color: RED");
        negL.setPrefWidth(widthSize-widthSize/1.25);
        negL.setAlignment(Pos.CENTER);
        negL.setFont(EffectFont.getFontTitle());
        negL.setTextFill(EffectColor.getColorTitle());
        negL.setLayoutX((widthSize/2)-(widthSize-widthSize/1.25)/2);
        negL.setLayoutY(appL.getLayoutY()+heightSize-heightSize/1.2);

        quesL.setText("Вопросительные предложения");
//        quesL.setStyle("-fx-border-color: RED");
        quesL.setPrefWidth(widthSize-widthSize/1.25);
        quesL.setAlignment(Pos.CENTER);
        quesL.setFont(EffectFont.getFontTitle());
        quesL.setTextFill(EffectColor.getColorTitle());
        quesL.setLayoutX((widthSize/2)-(widthSize-widthSize/1.25)/2);
        quesL.setLayoutY(negL.getLayoutY()+heightSize-heightSize/1.2);

        ROOT.getChildren().addAll(appL, negL, quesL);
    }
    protected void buttonListExam(){
        examL.setText("Контрольные работы");
//        quesL.setStyle("-fx-border-color: RED");
        examL.setPrefWidth(widthSize-widthSize/1.25);
        examL.setAlignment(Pos.CENTER);
        examL.setFont(EffectFont.getFontTitle());
        examL.setTextFill(EffectColor.getColorTitle());
        examL.setLayoutX((widthSize/2)-(widthSize-widthSize/1.25)/2);
        examL.setLayoutY(heightSize-heightSize/1.15);
        ROOT.getChildren().add(examL);
    }
    protected void groupButton(Exercises[] appnegquest, int finalI, IExercises iExercises){
        enBut.setOnAction(e ->
        {
            ClearDisplay.clearColumn();
            ClockDisplay.clock();
            appnegquest[finalI].getEnRu("LEFT", "EN", iExercises);
            appnegquest[finalI].getEnRu("RIGHT", "EN", iExercises);
        });
        ruBut.setOnAction(e ->
        {
            ClearDisplay.clearColumn();
            ClockDisplay.clock();
            appnegquest[finalI].getEnRu("LEFT", "RU", iExercises);
            appnegquest[finalI].getEnRu("RIGHT", "RU", iExercises);
        });
        exit.setOnAction(e -> iExercises.clearExercise());
    }
}
