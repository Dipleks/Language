package interfaceRoot;

import interfaceRoot.Root;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public interface ArgumentsMyWords extends Root
{
    // Menu_my_words
    VBox leftC = new VBox();
    VBox rightC = new VBox();
    HBox groupMy = new HBox();
    VBox addElement = new VBox();
    HBox addTextAndButton = new HBox();
    ScrollPane textMy = new ScrollPane();
    TextField textEn = new TextField();
    TextField textRu = new TextField();
    TextField textSearch = new TextField();
    Label[] my_word_en = new Label[500];
    Label[] my_word_ru = new Label[500];
    Button searchWords = new Button("Поиск");
    Button addWords = new Button("Добавить");
}
