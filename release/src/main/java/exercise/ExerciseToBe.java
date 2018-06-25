package exercise;

import control.AddExerciseExam;
import control.ButtonsMenu;
import control.MenuBarEngRus;

import static control.ClearDisplay.clearMethod;

public class ExerciseToBe implements IExercises
{
    ExerciseText text = new ExerciseText();

//        @Override
//    public String getExerciseRUS(int a, int b, String rus) {
//        return text.getToBeFileRu().get(a + b);
//    }
//
//    @Override
//    public String getExerciseENG(int a, int b, String eng) {
//        return text.getToBeFileEn().get(a + b);
//    }

    @Override
    public String methodExercise(int a, int b, String lang){
        if (lang.equals("EN")) {
            return text.getToBeFileEn().get(a + b);
        } else if (lang.equals("RU")) {
            return text.getToBeFileRu().get(a + b);
        }
        return "No files";
    }

    @Override
    public void clearExercise() {
        clearMethod();
        MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
        menuBarEngRus.getMenu();
        AddExerciseExam addExerciseExam = new AddExerciseExam();
        addExerciseExam.AddMenuButtonToBe();
    }
}
