package exam;

import db.TableDB;
import interfaceRoot.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс заполнения таблицы меню "Контрольные" со свойствами
 * <b>arrayOfOffersExam</b>, <b>number</b>, <b>correctly</b>, <b>START</b>, <b>m</b>, <b>exam</b>
 * @author Загороднев Д.М.
 * @version 2.0
 */
public class FillingColumnsExam implements ArgumentsExam
{
    /** Ячейки для значений таблицы */
    private Label[] arrayOfOffersExam;

    /** Нумерация ячеек */
    private Label[] number;

    /** Ячейка для отображения информации о правельности полученного перевода */
    private Label[] correctly;

    /** Номер значения с которого начинает заполнятся таблица */
    private int START;

    /** Временная форма к которой отностися данная контрольная работа (PS, to be...) */
    private String m;

    /** Класс со списком значений */
    private Exam exam = new Exam();

    /**
     * Конструктор создающий новый объект с параметрами
     * @param arrayOfOffersExam - ячейка со значением
     * @param number - номер ячейки
     * @param correctly - корректность перевода (ВЕРНО, НЕ ВЕРНО)
     * @param START - номер первого значения таблицы
     * @param m - отношение контрольной ко времени (PS, to be...)
     */
    public FillingColumnsExam(Label[] arrayOfOffersExam, Label[] number, Label[] correctly, int START, String m) {

        this.arrayOfOffersExam = arrayOfOffersExam;
        this.number = number;
        this.correctly = correctly;
        this.START = START;
        this.m = m;
    }

    /**
     * Процедура получения таблицы {@link FillingColumnsExam#getExamColumnLab(String, String)}
     */
    public void getExamList(){
        getExamColumnLab("RUS", "ENG");
    }

    /**
     * Функция получения значений {@link Exam}
     * @param a - номер предложения
     * @param b - номер ячейки в которую будет помещено значение
     * @param lang - язык значения
     * @return возвращает значение на выбранном языке
     */
    private String methodExam(int a, int b, String lang){
        if (lang.equals("RUS")) {
            switch (m) {
                case "ExamPS":
                    return exam.getExamRuPS().get(a + b);
                case "ExamToBe":
                    return exam.getExamRuToBe().get(a + b);
            }
        } else if (lang.equals("ENG")){
            switch (m) {
                case "ExamPS":
                    return exam.getExamEnPS().get(a + b);
                case "ExamToBe":
                    return exam.getExamEnToBe().get(a + b);
            }
        }
        return "No files";
    }

    /**
     * Процедура заполнения ячеек {@link FillingColumnsExam#arrayOfOffersExam}
     * @param rus - язык значения, русский
     * @param eng - язык значения, английский
     */
    private void getExamColumnLab(String rus, String eng) {
        for (int i = 0; i < arrayOfOffersExam.length; i++) {
            arrayOfOffersExam[i] = new Label();
            arrayOfOffersExam[i].setFont(EffectFont.getFontTextExam());
            arrayOfOffersExam[i].setTextFill(EffectColor.getColorText());
//            arrayOfOffersExam[i].setStyle("-fx-border-color: RED");
            arrayOfOffersExam[i].setPrefWidth(widthSize-widthSize/2.45);
            arrayOfOffersExam[i].setWrapText(true);
            arrayOfOffersExam[i].setText(methodExam(i, START, rus));
            arrayOfOffersExam[i].setCursor(Cursor.HAND);

            correctly[i] = new Label();
            correctly[i].setFont(EffectFont.getFontTextExam());
//            correctly[i].setStyle("-fx-border-color: RED");
            correctly[i].setPrefWidth(widthSize-widthSize/1.45);
            correctly[i].setAlignment(Pos.BASELINE_RIGHT);

            int finalI = i;
            arrayOfOffersExam[i].setOnMouseClicked(event -> {
                soundClick.soundClick();
                if (improve.getText().replaceAll("[!?.'^]", "").equalsIgnoreCase(methodExam(finalI, START, eng).
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
                    mistakesINdb(finalI, eng, rus);
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
                    panes("Напишите перевод для проверки...");
                }
                // Работа счетчика:
                counterRun();
            });
        }
        // Счетчик:
        try {
            counter();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Нумерация контольных:
        numberingOfExam("RUS", "ENG");
        // Добавляем все на панели:
        addPaneExam();
    }

    /**
     * Процедура подсчеёта данных {@link FillingColumnsExam#correctly}
     */
    private void counterRun(){
        int a = 0;
        int b = 0;
        for (int j = 0; j < 100; j++) {
            if (correctly[j].getText().equals("ВЕРНО!!!")){
                ++a;
            } else if (correctly[j].getText().equals("НЕ ВЕРНО!!!")) {
                ++b;
            }
        }
        counterYES.setText(String.valueOf(a));
        counterNO.setText(String.valueOf(b));
    }

    /**
     * Процедура нумерации {@link FillingColumnsExam#number}
     * и получения корректного ответа {@link FillingColumnsExam#arrayOfOffersExam}
     * @param rus - язык значения, Русский
     * @param eng - язык значения, Английский
     */
    private void numberingOfExam(String rus, String eng){
        for (int i = 0; i < number.length; i++) {
            number[i] = new Label();
            number[i].setFont(EffectFont.getFontTextExam());
            number[i].setTextFill(EffectColor.getColorTitle());
//                    number[i].setStyle("-fx-border-color: RED");
            number[i].setPrefWidth(widthSize-widthSize/1.45);
            number[i].setAlignment(Pos.CENTER);
            number[i].setCursor(Cursor.HAND);
            number[i].setText("-"+(i+1+START)+"-");
            int finalI = i;
            number[i].setOnMouseClicked(ev -> {
                soundClick.soundClick();
                if (arrayOfOffersExam[finalI].getText().equals(methodExam(finalI, START, rus))){
                    arrayOfOffersExam[finalI].setText(methodExam(finalI, START, eng));
                    arrayOfOffersExam[finalI].setTextFill(EffectColor.getColorTextImpr());
                }
            });
        }
    }

    /**
     * Процедура объединения всех данных в одну панель {@link interfaceRoot.Root#ROOT}
     */
    private void addPaneExam(){
        //          numberColumn.setStyle("-fx-border-color: RED");
        numberColumn.setSpacing(heightSize-heightSize/1.009);
        numberColumn.setPadding(new Insets(0, 0, 0, 0));
        numberColumn.setPrefSize(widthSize/25, heightSize/1.25);
        numberColumn.getChildren().addAll(number);

//          iprColumn.setStyle("-fx-border-color: RED");
        iprColumn.setSpacing(heightSize-heightSize/1.009);
        iprColumn.setPadding(new Insets(0, 0, 0, 0));
        iprColumn.setPrefSize(widthSize/11, heightSize/1.25);
        iprColumn.getChildren().addAll(correctly);

//          columnExam.setStyle("-fx-border-color: RED");
        columnExam.setSpacing(heightSize-heightSize/1.009);
        columnExam.setPadding(new Insets(0, 0, 0, 0));
        columnExam.setPrefSize(widthSize/2.5, heightSize/1.25);
        columnExam.getChildren().addAll(arrayOfOffersExam);

        groupExam.setSpacing(heightSize-heightSize/1.009);
        groupExam.getChildren().addAll(numberColumn, columnExam, iprColumn);

        examPane.setContent(groupExam);
//        examPane.setStyle("-fx-background-color: transparent; -fx-background: #FFFFFF;");
        examPane.setLayoutX(widthSize - widthSize / 1.25);
        examPane.setLayoutY(heightSize - heightSize / 1.16);
        examPane.setPrefSize(widthSize / 1.8, heightSize / 1.5);

        HBox hBox = new HBox();
        Button button = new Button("?");
        button.setOnAction(e -> {
            panes(str);
        });
        improve.setPrefWidth(widthSize/3);
        hBox.setSpacing(10);
        hBox.getChildren().addAll(button, improve, exitInMenu, nameExam);
        improveClick1.setAlignment(Pos.CENTER);
        improveClick1.setTextFill(EffectColor.getColorTextClickPERU());
        improveV.getChildren().addAll(improveClick1, hBox);
        improveV.setSpacing(heightSize-heightSize/1.009);
        improveV.setLayoutX(widthSize-widthSize/1.4);
        improveV.setLayoutY(heightSize-heightSize/1.05);

        ROOT.getChildren().addAll(examPane, improveV);
    }

    /**
     * Процедура подключения {@link FillingColumnsExam#getExamColumnLab(String, String)}
     * к базе данных и занесения в неё значений {@link FillingColumnsExam#arrayOfOffersExam}
     * не равных {@link FillingColumnsExam#improve}
     * @param i - ячейка значения и её номер
     * @param en - язык значения, Английский
     * @param ru - язык значения, Русский
     */
    private void mistakesINdb(int i, String en, String ru){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(TableDB.DB_URL + TableDB.db, TableDB.USER, TableDB.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            assert connection != null;
            Statement stmt1 = connection.createStatement();
            arrayOfOffersExam[i].setText(methodExam(i, START, en));
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            String localDateTime = LocalDateTime.now().format(format);
            stmt1.executeUpdate("INSERT INTO counter " +
                    "(date_time, numb, original, mistakes, part)" +
                    "VALUES ('"+localDateTime+"', '"+number[i].getText()+"', '"+
                    arrayOfOffersExam[i].getText()+"', '"+improve.getText()+"', '"+ nameExam.getText() +"');");
            arrayOfOffersExam[i].setText(methodExam(i, START, ru));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
