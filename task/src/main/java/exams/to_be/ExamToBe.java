package exams.to_be;

import exams.ExamText;
import exams.Exams;
import exams.IExam;
import javafx.scene.control.Label;

public class ExamToBe implements IExam {

    private ExamText exam = new ExamText();

    @Override
    public void getExamList(Label[] arrayOfOffersExam, Label[] number, Label[] correctly, int START, String m) {
        Exams exams = new Exams(arrayOfOffersExam, number, correctly, START, m);
        exams.getExamListDDD();
        System.out.println("test to be");
    }
}
