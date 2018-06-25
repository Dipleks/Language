package exam;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static interfaceRoot.Root.heightSize;
import static interfaceRoot.Root.widthSize;

public class PanelTips
{
    protected static void panes(String str) {
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
}
