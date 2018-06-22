package interfaceRoot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockDisplay implements Root
{
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    private static DateTimeFormatter format2 = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static Label uiTimer = new Label();
    private static String s1 = "Дата: ";
    private static String s2 = "\nВремя: ";
    private static KeyFrame keyFrame = new KeyFrame(Duration.seconds(1),
            event -> uiTimer.setText(s1 + LocalDateTime.now().format(format) +
            s2 + LocalDateTime.now().format(format2)));
    private static Timeline timeline = new Timeline(keyFrame);

    public static void clock() {
        uiTimer.setLayoutX(widthSize / 25);
        uiTimer.setLayoutY(heightSize / 20);
        uiTimer.setFont(EffectFont.getFontTextExam());
        uiTimer.setTextFill(EffectColor.getColorClock());
        uiTimer.setWrapText(true);
        uiTimer.setAlignment(Pos.CENTER);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        ROOT.getChildren().addAll(uiTimer);
    }
}
