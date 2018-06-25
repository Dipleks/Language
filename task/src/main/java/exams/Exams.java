package exams;

import db.CreateDB;
import db.TableDB;
import interfaceRoot.EffectColor;
import interfaceRoot.EffectFont;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static interfaceRoot.ArgumentsExam.*;
import static interfaceRoot.Root.soundClick;
import static interfaceRoot.Root.widthSize;

public class Exams
{
    private Label[] arrayOfOffersExam;
    private Label[] number;
    private Label[] correctly;
    private int START;
    private String m;
    
    private ExamText exam = new ExamText();

    public Exams(Label[] arrayOfOffersExam, Label[] number, Label[] correctly, int START, String m) {

        this.arrayOfOffersExam = arrayOfOffersExam;
        this.number = number;
        this.correctly = correctly;
        this.START = START;
        this.m = m;
    }

    public void getExamListDDD(){
        getExamColumnLab("RUS", "ENG");
    }

    private String methodExam(int a, int b, String lang){
        if (lang.equals("RUS")) {
            switch (m) {
                case "_ExamPS":
                    return exam.getExamRuPS().get(a + b);
                case "_ExamToBe":
                    return exam.getExamRuToBe().get(a + b);
            }
        } else if (lang.equals("ENG")){
            switch (m) {
                case "_ExamPS":
                    return exam.getExamEnPS().get(a + b);
                case "_ExamToBe":
                    return exam.getExamEnToBe().get(a + b);
            }
        }
        return "No files";
    }

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
                //TODO correctly не доработан
                WorkCounter workCounter = new WorkCounter();
                workCounter.counterRun(correctly);
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
    private void panes(String str) {
        Stage win = new Stage();
        Label label = new Label(str);
        Button button = new Button("Закрыть");
        button.setOnAction(e -> win.close());
        VBox group = new VBox();
        group.setSpacing(20);
        group.setAlignment(Pos.CENTER);
        group.getChildren().addAll(label, button);
        Scene scene = new Scene(group, widthSize/2.5, heightSize/5.5);
        win.initModality(Modality.APPLICATION_MODAL);
        win.setScene(scene);
        win.show();
    }
    private void counter() throws SQLException, ClassNotFoundException {
        if (CreateDB.newCounterRun()) {
            ROOT.getChildren().remove(counterVB);
            YES.setFont(EffectFont.getFontTextExam());
            YES.setTextFill(EffectColor.getColorTextClickPERU());
            NO.setFont(EffectFont.getFontTextExam());
            NO.setTextFill(EffectColor.getColorTextClickPERU());
            counterYES.setFont(EffectFont.getFontTextExam());
            counterNO.setFont(EffectFont.getFontTextExam());
            counterYES.setText("0");
            counterNO.setText("0");
            // Кнопка "Счетчик":
            Button resultExam = new Button("Статистика");
            resultExam.setStyle("-fx-background-color: #c1b8b8;");
            resultExam.setOnAction(event -> statisticsWindow());

            counterVB.setSpacing(10);
            counterVB.setAlignment(Pos.CENTER);
            counterVB.setLayoutX(widthSize / 10);
            counterVB.setLayoutY(heightSize / 5);
//            counterVB.setStyle("-fx-border-color: RED");
            counterVB.getChildren().addAll(YES, counterYES, NO, counterNO, resultExam);
            ROOT.getChildren().add(counterVB);
        } else {
            CreateDB.newCounterFirstRun();
            counter();
        }
    }
    private void counterDeleteStatistic(){
        try {
            Connection connection = DriverManager.getConnection(TableDB.DB_URL + TableDB.db, TableDB.USER, TableDB.PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM counter; ALTER SEQUENCE counter_id_seq RESTART WITH 1;");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void statisticsWindow() {
        Stage statistics = new Stage();
        Group rootStatistics = new Group();
        Scene sceneStatistics = new Scene(rootStatistics, widthSize/1.4, heightSize/2);
        TableView<_AddMistakesTable> tableStatisticExam = new TableView<>();

        Button deleteCounter = new Button("Очистить статистику");
        deleteCounter.setOnAction(event -> {
            counterDeleteStatistic();
            statistics.close();
        });
        HBox buttPane = new HBox();
        buttPane.setSpacing(sceneStatistics.getWidth()/10);
        buttPane.setLayoutX(10);
        buttPane.setLayoutY(sceneStatistics.getHeight()/1.08);
        buttPane.getChildren().addAll(deleteCounter);

        TableColumn<_AddMistakesTable, String> dateTime = new TableColumn<>("Дата");
        TableColumn<_AddMistakesTable, String> returnNumber = new TableColumn<>("№");
        TableColumn<_AddMistakesTable, String> returnOriginal = new TableColumn<>("Правильный текст");
        TableColumn<_AddMistakesTable, HBox> returnMistakes = new TableColumn<>("Ошибка");
        TableColumn<_AddMistakesTable, String> returnPart = new TableColumn<>("Часть");
        dateTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        dateTime.setPrefWidth(sceneStatistics.getWidth()/6.7);
        dateTime.setStyle( "-fx-alignment: CENTER;");
        returnNumber.setCellValueFactory(new PropertyValueFactory<>("numberText"));
        returnNumber.setPrefWidth(sceneStatistics.getWidth()/19);
        returnNumber.setStyle( "-fx-alignment: CENTER;");
        returnOriginal.setCellValueFactory(new PropertyValueFactory<>("originalText"));
        returnOriginal.setPrefWidth(sceneStatistics.getWidth()/2.9);
        returnMistakes.setCellValueFactory(new PropertyValueFactory<>("mistakesText"));
        returnMistakes.setPrefWidth(sceneStatistics.getWidth()/2.9);
        returnPart.setCellValueFactory(new PropertyValueFactory<>("numberPart"));
        returnPart.setPrefWidth(sceneStatistics.getWidth()/11);
        returnPart.setStyle( "-fx-alignment: CENTER;");
        tableStatisticExam.setStyle("-fx-background-color: gray;");
        tableStatisticExam.setPrefWidth(sceneStatistics.getWidth());

        ObservableList<_AddMistakesTable> list = FXCollections.observableArrayList();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(TableDB.DB_URL + TableDB.db, TableDB.USER, TableDB.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            assert connection != null;
            Statement stmt2 = connection.createStatement();
            ResultSet rs1 = stmt2.executeQuery("SELECT date_time, numb, original, mistakes, part " +
                    "FROM (SELECT DISTINCT ON (mistakes) date_time, numb, " +
                    "original, mistakes, part FROM counter) AS td " +
                    "ORDER BY date_time;"); //sql запрос
            while (rs1.next()) {
                Timestamp timestamp = rs1.getTimestamp("date_time");
                java.util.Date date = new Date(timestamp.getTime());
                SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy" + "г. в "+ "HH:mm:ss",
                        Locale.getDefault());
                String result = newDateFormat.format(date);

                // Выделение цветом ошибок:
                String original = rs1.getString("original");
                String mistakes = rs1.getString("mistakes");
                Label[] originalL = new Label[original.length()];
                Label[] mistakesL = new Label[mistakes.length()];
                HBox mistakesCallus = new HBox();
                int length;
                if (original.length()<mistakes.length()){
                    length = original.length();
                } else {
                    length = mistakes.length();
                }
                for (int i = 0; i < length; i++) {
                    char c;
                    char d;
                    c = original.charAt(i);
                    d = mistakes.charAt(i);
                    if (c==d){
                        originalL[i] = new Label();
                        mistakesL[i] = new Label();
                        originalL[i].setText(String.valueOf(c));
                        mistakesL[i].setText(String.valueOf(d));
                        mistakesCallus.getChildren().addAll(mistakesL[i]);
                    } else {
                        originalL[i] = new Label();
                        mistakesL[i] = new Label();
                        originalL[i].setTextFill(Color.RED);
                        mistakesL[i].setTextFill(Color.RED);
                        originalL[i].setText(String.valueOf(c));
                        mistakesL[i].setText(String.valueOf(d));
                        mistakesCallus.getChildren().addAll(mistakesL[i]);
                    }
                }

                list.add(new _AddMistakesTable(result, rs1.getString("numb"),
                        rs1.getString("original"), mistakesCallus, rs1.getString("part")));
            }
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
        tableStatisticExam.setItems(list);
        tableStatisticExam.getColumns().addAll(dateTime, returnNumber, returnOriginal, returnMistakes, returnPart);

        rootStatistics.getChildren().addAll(tableStatisticExam, buttPane);
        statistics.setTitle("Статистика");
        statistics.initModality(Modality.APPLICATION_MODAL);
        statistics.setScene(sceneStatistics);
        statistics.show();
    }

}
