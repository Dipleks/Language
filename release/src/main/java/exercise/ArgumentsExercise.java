package exercise;

import interfaceRoot.Root;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Интерфейс значений {@link FillingColumnsExercise}
 */
public interface ArgumentsExercise extends Root
{
    /** Контейнер для ячеек со значениями */
    VBox leftColumn = new VBox();

    /** Контейнер для ячеек со значениями */
    VBox rightColumn = new VBox();

    /** Контейнер для {@link control.Control#enBut}, {@link control.Control#ruBut},
     * {@link control.Control#exit}
     * */
    HBox groupRadBut = new HBox();
}
