package exams;

import exams.presenSimple.ExamPS;
import exams.to_be.ExamToBe;
import javafx.scene.control.Label;

public class AddExerciseExamDouble {

    private static ConstructorExam classControl = new ConstructorExam(new ExamPS());
    private static ConstructorExam classControl1 = new ConstructorExam(new ExamToBe());

    public static void main(String[] args) {


        classControl.iExam.getExamList(new Label[100], new Label[100], new Label[100],  0, "ExamPS");

        classControl1.iExam.getExamList(new Label[100], new Label[100], new Label[100],  0, "ExamToBe");
    }
}
