package exam;

import control.AddExerciseExam;
import control.MenuBarEngRus;

import static control.ClearDisplay.clearMethod;

public class ExamPS implements IExam
{
    private ExamText exam = new ExamText();

    public ExamPS() {
    }

    @Override
    public String getExamRUS(int a, int b){

        return exam.getExamRuPS().get(a + b);

    }

    @Override
    public String getExamENG(int a, int b) {

        return exam.getExamEnPS().get(a + b);

    }

    @Override
    public void clearExams() {
            clearMethod();
            MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
            menuBarEngRus.getMenu();
            AddExerciseExam addExerciseExam = new AddExerciseExam();
            addExerciseExam.AddMenuButtonExamPS();
    }
}
