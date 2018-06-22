package interfaceRoot;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public interface ArgumentsExam extends Root
{
    ScrollPane examPane = new ScrollPane();
    VBox improveV = new VBox();
    String str = "Введите текст и нажмите на предложение из списка! " +
            "Красный - не верно! Зеленый - верно!\n " +
            "Если вы уверены в своем переводе нажмите на номер предложения!";
    TextField improve = new TextField();
    Label improveClick1 = new Label(str);
    Label nameExam = new Label();
    VBox counterVB = new VBox();
    Label counterYES = new Label();
    Label counterNO = new Label();
    Label YES = new Label("Верно:");
    Label NO = new Label("Не верно:");
    VBox numberColumn = new VBox();
    VBox iprColumn = new VBox();
    VBox columnExam = new VBox();
    HBox groupExam = new HBox();
    Button exitInMenu = new Button("В меню");
}
