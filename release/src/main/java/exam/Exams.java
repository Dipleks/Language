package exam;

import interfaceRoot.*;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import java.sql.*;

public class Exams implements ArgumentsExam
{
    private Label[] arrayOfOffersExam = new Label[100];
    private Label[] number = new Label[100];
    private Label[] correctly = new Label[100];
    private int START;

    public Exams(int START) {
        this.START = START;
    }

    public void getExamList(IExam iExam){
        getExamColumnLab(iExam);
    }

    private void getExamColumnLab(IExam iExam) {
        for (int i = 0; i < 100; i++) {
            arrayOfOffersExam[i] = new Label();
            arrayOfOffersExam[i].setFont(EffectFont.getFontTextExam());
            arrayOfOffersExam[i].setTextFill(EffectColor.getColorText());
//            arrayOfOffersExam[i].setStyle("-fx-border-color: RED");
            arrayOfOffersExam[i].setPrefWidth(widthSize-widthSize/2.45);
            arrayOfOffersExam[i].setWrapText(true);
            arrayOfOffersExam[i].setText(iExam.getExamRUS(i, START));
            arrayOfOffersExam[i].setCursor(Cursor.HAND);

            correctly[i] = new Label();
            correctly[i].setFont(EffectFont.getFontTextExam());
//            correctly[i].setStyle("-fx-border-color: RED");
            correctly[i].setPrefWidth(widthSize-widthSize/1.45);
            correctly[i].setAlignment(Pos.BASELINE_RIGHT);

            int finalI = i;
            arrayOfOffersExam[i].setOnMouseClicked(event -> {
                soundClick.soundClick();
                if (improve.getText().replaceAll("[!?.'^]", "").equalsIgnoreCase(iExam.getExamENG(finalI, START).
                        replaceAll("[!?.'^]", ""))){
                    arrayOfOffersExam[finalI].setTextFill(EffectColor.getColorTextClick());
                    correctly[finalI].setText("ВЕРНО!!!");
                    correctly[finalI].setTextFill(EffectColor.getColorTextClick());
                    improveClick1.setFont(EffectFont.getFontTextExam());
                    improveClick1.setTextFill(EffectColor.getColorText());
                    improveClick1.setText(improve.getText());
                    improve.clear();
                } else if (!improve.getText().equalsIgnoreCase("")){
                    /////////////
                    RecordErrorsExams.mistakesINdb(arrayOfOffersExam, number, finalI, START, iExam);
                    /////////////
                    arrayOfOffersExam[finalI].setTextFill(EffectColor.getColorTextClickRED());
                    correctly[finalI].setText("НЕ ВЕРНО!!!");
                    correctly[finalI].setTextFill(EffectColor.getColorTextClickRED());
                    improveClick1.setFont(EffectFont.getFontTextExam());
                    improveClick1.setTextFill(EffectColor.getColorText());
                    improveClick1.setText(improve.getText());
                    improve.clear();
                } else if (improve.getText().equalsIgnoreCase("")) {
                    improveClick1.setFont(EffectFont.getFontTextExam());
                    improveClick1.setTextFill(EffectColor.getColorTextClickRED());
                    improveClick1.setText("Введите текст для проверки!");
                    PanelTips.panes("Напишите перевод для проверки...");
                }
                // Работа счетчика:
                WorkCounter workCounter = new WorkCounter();
                workCounter.counterRun(correctly);
            });
        }
        // Счетчик:
        try {
            Counters counters = new Counters();
            counters.counter();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Нумерация контольных:
        Numerations numerations = new Numerations();
        numerations.numberingOfExam(number, arrayOfOffersExam, START, iExam);

        // Добавляем все на панели:
        MergingPanels mergingPanels = new MergingPanels();
        mergingPanels.addPaneExam(number, correctly, arrayOfOffersExam);
    }
}
