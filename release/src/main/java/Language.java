import control.MenuBarEngRus;
import db.CreateDB;
import interfaceRoot.ClockDisplay;
import interfaceRoot.Root;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Language extends Application implements Root
{
    private MenuBarEngRus menuBarEngRus = new MenuBarEngRus();

    @Override
    public void start(Stage primaryStage) {

        try {
            if (CreateDB.connectDB()) {
                runMethod();
            } else {
                showWindow();
            }
        } catch (Exception e) {

            // TODO действие если БД нет вообще на ПК

            System.out.println("test2");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void showWindow(){

        showTextOne.setText("Первый вход в программу!");
        showTextTwo.setText("Создать базу данных?");
        showTextOne.setFont(Font.font("Time New Romane", 15));
        showTextTwo.setFont(Font.font("Time New Romane", 15));

        yesDB.setOnAction(e -> {
            try {
                CreateDB.newDB();
                CreateDB.newCounterFirstRun();
            } catch (SQLException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            runMethod();
            showStageDB.close();
        });
        noDB.setOnAction(e -> {
            runMethod();
            showStageDB.close();
        });
        showNoDB.setSpacing(10);
        showNoDB.getChildren().addAll(yesDB, noDB);
        showNoDB.setAlignment(Pos.CENTER);
        showDB.setSpacing(3);
        showDB.getChildren().addAll(showTextOne, showTextTwo, showNoDB);
        showDB.setAlignment(Pos.CENTER);

        rootShowDB.setPadding(new Insets(20, 40, 20, 40));
        rootShowDB.setCenter(showDB);

        showStageDB.setScene(showSceneDB);
        showStageDB.setTitle("Вход...");
        showStageDB.show();
    }
    private void runMethod() {
        menuBarEngRus.getMenu();
        ClockDisplay.clock();

        ROOT.getChildren().addAll();

        WINDOW.setTitle("EngRus");
        WINDOW.setMaximized(true); //устанавливаем размер окна на весь экран
        WINDOW.setScene(SCENE_ROOT);
        WINDOW.show();
    }
}