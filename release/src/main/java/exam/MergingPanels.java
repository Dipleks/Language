package exam;

import interfaceRoot.EffectColor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import static interfaceRoot.ArgumentsExam.*;
import static interfaceRoot.Root.heightSize;
import static interfaceRoot.Root.widthSize;

public class MergingPanels
{
    protected void addPaneExam(Label[] number, Label[] correctly, Label[] arrayOfOffersExam){
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
            PanelTips.panes(str);
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
}
