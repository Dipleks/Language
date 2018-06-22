package interfaceRoot;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public interface Root
{
    // Главное окно:
    Stage WINDOW = new Stage();
    Screen SCREEN = Screen.getPrimary();
    double widthSize = SCREEN.getBounds().getWidth();
    double heightSize = SCREEN.getBounds().getHeight();
    Group ROOT = new Group();
    Scene SCENE_ROOT = new Scene(ROOT, widthSize*0.95, heightSize*0.95, EffectColor.getColorScene());

    // Окно первого запуска программы:
    Label showTextOne = new Label();
    Label showTextTwo = new Label();
    VBox showDB = new VBox();
    HBox showNoDB = new HBox();
    BorderPane rootShowDB = new BorderPane();
    Stage showStageDB = new Stage();
    Scene showSceneDB = new Scene(rootShowDB, 450, 200);
    Button yesDB = new Button("Да, создать!");
    Button noDB = new Button("Использовать без БД!");

    SoundClick soundClick = new SoundClick();
}
