package control;

import db.CreateDB;
import interfaceRoot.Root;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myWords.MyWords;
import texts.TextLevelOne;

public class MenuBarEngRus implements Root
{
    private final MenuBar menuBar = new MenuBar();

    private final Menu menuExercise = new Menu("Задания");
    private final Menu menuExams = new Menu("Контрольные");
    private final Menu menuTexts = new Menu("Тексты");
    private final MenuItem menuPS = new MenuItem("Present Simple");
    private final MenuItem menu_my_words = new MenuItem("Мой словарь");
    private final MenuItem examPS = new MenuItem("Контрольная PS");
    private final MenuItem menuToBe = new MenuItem("Форма \"to be\"");
    private final MenuItem examToBe = new MenuItem("Контрольная \"to be\"");
    private final MenuItem textsLevelOne = new MenuItem("Уровень 1");

    private final Menu menuHelp = new Menu("Подсказки");

    private final Menu menuServes = new Menu("Сервис");
    private final Menu menuSetting = new Menu("Режим");
    private final MenuItem menuWHITE = new MenuItem("День");
    private final MenuItem menuBLACK = new MenuItem("Ночь");
    private final MenuItem about = new MenuItem("О программе");

    public void getMenu() {
        ROOT.getChildren().addAll(getMenuBar());
    }
    private MenuBar getMenuBar() {

        getMenuPS();
        getMenu_my_words();
        getExamPS();
        getAbout();
        getMenuToBe();
        getExamToBe();
        getMenuBLACK();
        getMenuWHITE();
        getTextsLevelOne();

        menuWHITE.setDisable(true);
        menuBLACK.setDisable(true);
        menuHelp.setDisable(true);

        menuBar.setMinWidth(widthSize);
        menuTexts.getItems().addAll(textsLevelOne);
        menuSetting.getItems().addAll(menuWHITE, menuBLACK);
        menuServes.getItems().addAll(menuSetting, about);
        menuExercise.getItems().addAll(menuPS, menuToBe, menu_my_words);
        menuExams.getItems().addAll(examPS, examToBe);
        menuBar.getMenus().addAll(menuExercise, menuExams, menuTexts, menuHelp, menuServes);

        return menuBar;
    }
    private void getMenu_my_words() {

        if (CreateDB.connectDB()) {
            menu_my_words.setOnAction(event -> {
                ClearDisplay.clearMethod();
                MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
                menuBarEngRus.getMenu();
                MyWords fillingColumns = new MyWords();
                fillingColumns.getMyWordsList();
            });
        } else {
            menu_my_words.setVisible(false);
        }
    }
    private void getMenuPS(){
        menuPS.setOnAction(event -> {
            ClearDisplay.clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            AddExerciseExam addExerciseExam = new AddExerciseExam();
            addExerciseExam.AddMenuButtonPS();
        });
    }
    private void getExamPS(){
        examPS.setOnAction(event -> {
            ClearDisplay.clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            AddExerciseExam addExerciseExam = new AddExerciseExam();
            addExerciseExam.AddMenuButtonExamPS();
        });
    }
    private void getAbout(){
        about.setOnAction(event -> {
            Stage window = new Stage();
            StackPane stackPane = new StackPane();
            Scene scene = new Scene(stackPane, widthSize/3, heightSize/3);
            Label label = new Label();
//                label.setStyle("-fx-border-color: RED");
            label.setPrefSize(widthSize/4, heightSize/4);
            label.setText("Автор программы Ghost \n" + "\n" + "Программа предназначена " +
                    "\nдля изучения Английского языка." +
                    "\n\n                                    Версия программы: 2.02" +
                    "\n\n\nИзменения:\nДобавлено выделение ошибок красным цветом.");
            label.setFont(Font.font("Time New Roman", FontWeight.BOLD,
                    FontPosture.ITALIC, heightSize*0.015));
            label.setAlignment(Pos.CENTER);

            stackPane.getChildren().addAll(label);

            window.setScene(scene);
            window.setTitle("О программе");
            window.initModality(Modality.APPLICATION_MODAL);
            window.show();
        });
    }
    private void getMenuToBe(){
        menuToBe.setOnAction(event -> {
            ClearDisplay.clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            AddExerciseExam addExerciseExam = new AddExerciseExam();
            addExerciseExam.AddMenuButtonToBe();
        });
    }
    private void getExamToBe(){
        examToBe.setOnAction(event -> {
            ClearDisplay.clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            AddExerciseExam addExerciseExam = new AddExerciseExam();
            addExerciseExam.AddMenuButtonExamToBe();
        });
    }
    private void getMenuBLACK(){
        menuBLACK.setOnAction(event -> {
//            EffectColor.setColorText(Color.WHITE);
//            EffectColor.setColorTextClick();
//            EffectColor.setColorTextClickPERU();
//            EffectColor.setColorTextClickRED();
//            EffectColor.setColorTextImpr();
//            EffectColor.setColorScene();
//            SCENE_ROOT.setFill(Color.BLACK);
//            EffectColor.setColorTitle();
        });
    }
    private void getMenuWHITE(){
        menuBLACK.setOnAction(event -> {

        });
    }
    private void getTextsLevelOne(){
        textsLevelOne.setOnAction(event -> {
            ClearDisplay.clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            TextLevelOne textLevelOne = new TextLevelOne();
            textLevelOne.text1();
        });
    }
}
