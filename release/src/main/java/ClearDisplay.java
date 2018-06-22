import control.AddExerciseExam;
import control.MenuBarEngRus;
import exam.ArgumentsExam;
import interfaceRoot.ClockDisplay;
import myWords_TTT.ArgumentsMyWords;
import exercise.ArgumentsExercise;

public class ClearDisplay implements ArgumentsExam, ArgumentsExercise, ArgumentsMyWords
{
    // Очистка колонок упражнений:
    public static void clearColumn() {
        columnExam.getChildren().clear();
        rightColumn.getChildren().clear();
        leftColumn.getChildren().clear();
        ROOT.getChildren().clear();
        MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
        menuBarEngRus.getMenu();
        ROOT.getChildren().addAll(groupRadBut);
    }
    // Полная зачистка главного окна:
    public static void clearMethod() {
        leftC.getChildren().clear();
        rightC.getChildren().clear();
        groupMy.getChildren().clear();
        addElement.getChildren().clear();
        addTextAndButton.getChildren().clear();
        columnExam.getChildren().clear();
        rightColumn.getChildren().clear();
        leftColumn.getChildren().clear();
        groupRadBut.getChildren().clear();
        groupExam.getChildren().clear();
        iprColumn.getChildren().clear();
        numberColumn.getChildren().clear();
        improveV.getChildren().clear();
        counterVB.getChildren().clear();
        ROOT.getChildren().clear();
        ClockDisplay.clock();
    }
    // Зачистка окна упражнений:
    public static void methodClearExercise(String m) {
        if (m.equals("AddMenuButtonPS")){
            clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            AddExerciseExam addExerciseExam = new AddExerciseExam();
            addExerciseExam.AddMenuButtonPS();
        } else if (m.equals("AddMenuButtonToBe")){
            clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            AddExerciseExam addExerciseExam = new AddExerciseExam();
            addExerciseExam.AddMenuButtonToBe();
        }
    }
    // Зачистка окна контрольных:
    public static void methodClearExam(String m) {
        if (m.equals("AddMenuButtonExamPS")){
            clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            AddExerciseExam addExerciseExam = new AddExerciseExam();
            addExerciseExam.AddMenuButtonExamPS();
        } else if (m.equals("AddMenuButtonExamToBe")){
            clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            AddExerciseExam addExerciseExam = new AddExerciseExam();
            addExerciseExam.AddMenuButtonExamToBe();
        }
    }




}
