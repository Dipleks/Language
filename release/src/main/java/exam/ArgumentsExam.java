package exam;

import db.CreateDB;
import db.TableDB;
import interfaceRoot.EffectColor;
import interfaceRoot.EffectFont;
import interfaceRoot.Root;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Интерфейс с параметрами и методами управления БД для {@link FillingColumnsExam}, со значениями
 * <b>examPane</b>, <b>improveV</b>, <b>str</b>, <b>improve</b>, <b>improveClick1</b>, <b>nameExam</b>,
 * <b>counterVB</b>, <b>counterYES</b>, <b>counterNO</b>, <b>YES</b>, <b>NO</b>, <b>numberColumn</b>,
 * <b>iprColumn</b>, <b>columnExam</b>, <b>groupExam</b>, <b>exitInMenu</b>
 * @author Загороднев Д.М.
 * @version 2.0
 */
public interface ArgumentsExam extends Root
{
    /** Панель с контейнерами значений */
    ScrollPane examPane = new ScrollPane();

    /** Панель с вызовом окна подсказки, текстовым полем, возвратом в меню Контрольных */
    VBox improveV = new VBox();

    /** Текстовое значение окна подсказки */
    String str = "Введите текст и нажмите на предложение из списка! " +
            "Красный - не верно! Зеленый - верно!\n " +
            "Если вы уверены в своем переводе нажмите на номер предложения!";

    /** Текстовое поле проверки */
    TextField improve = new TextField();

    /** Ячека информации для работы с текстовым полем */
    Label improveClick1 = new Label(str);

    /** Ячейка с именем части экзамена */
    Label nameExam = new Label();

    /** Контейнер для ячеек счетчика ошибок */
    VBox counterVB = new VBox();

    /** Ячека счетчика с информацией о колличестве положительных ответов */
    Label counterYES = new Label();

    /** Ячека счетчика с информацией о колличестве отрицательных ответов */
    Label counterNO = new Label();

    /** Информационная ячейка положительных ответов */
    Label YES = new Label("Верно:");

    /** Информационная ячейка отрицательных ответов */
    Label NO = new Label("Не верно:");

    /** Контейнер для ячеек с номерами значений */
    VBox numberColumn = new VBox();

    /** Контейнер с ячейками положительных/отрицательных ответов */
    VBox iprColumn = new VBox();

    /** Контейнер с ячейками значений */
    VBox columnExam = new VBox();

    /** Контейнер группировки {@link ArgumentsExam#numberColumn}, {@link ArgumentsExam#iprColumn},
     * {@link ArgumentsExam#columnExam} */
    HBox groupExam = new HBox();

    /** Кнопка возврата в меню выбора */
    Button exitInMenu = new Button("В меню");

    /**
     * Процедура вызова окна подсказок
     * @param str - текст подсказки
     */
    default void panes(String str) {
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

    /**
     * Процедура вызова {@link ArgumentsExam#counterVB}
     * Может вызвать иключения:
     * @throws SQLException - ошибка в работе с базой данных
     * @throws ClassNotFoundException - отсутствие драйвера JDBC
     */
    default void counter() throws SQLException, ClassNotFoundException {
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

    /**
     * Процедура очистки таблицы базы данных со статистикой
     */
    default void counterDeleteStatistic(){
        try {
            Connection connection = DriverManager.getConnection(TableDB.DB_URL + TableDB.db, TableDB.USER, TableDB.PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM counter; ALTER SEQUENCE counter_id_seq RESTART WITH 1;");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Процедура вызова окна со статистикой
     */
    default void statisticsWindow() {
        Stage statistics = new Stage();
        Group rootStatistics = new Group();
        Scene sceneStatistics = new Scene(rootStatistics, widthSize/1.4, heightSize/2);
        TableView<AddMistakesTable> tableStatisticExam = new TableView<>();

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

        TableColumn<AddMistakesTable, String> dateTime = new TableColumn<>("Дата");
        TableColumn<AddMistakesTable, String> returnNumber = new TableColumn<>("№");
        TableColumn<AddMistakesTable, String> returnOriginal = new TableColumn<>("Правильный текст");
        TableColumn<AddMistakesTable, HBox> returnMistakes = new TableColumn<>("Ошибка");
        TableColumn<AddMistakesTable, String> returnPart = new TableColumn<>("Часть");
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

        ObservableList<AddMistakesTable> list = FXCollections.observableArrayList();
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

                list.add(new AddMistakesTable(result, rs1.getString("numb"),
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
