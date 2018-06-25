package exam;

import control.AddExerciseExam;
import control.MenuBarEngRus;

import static control.ClearDisplay.clearMethod;

public class ExamTobe implements IExam
{
    private ExamText exam = new ExamText();

    public ExamTobe() {
    }

    @Override
    public String getExamRUS(int a, int b){

        return exam.getExamRuToBe().get(a + b);

    }

    @Override
    public String getExamENG(int a, int b) {

        return exam.getExamEnToBe().get(a + b);

    }

    @Override
    public void clearExams() {
            clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            AddExerciseExam addExerciseExam = new AddExerciseExam();
            addExerciseExam.AddMenuButtonExamToBe();
    }
}
