package exams.to_be;

import exams.Exams;
import exams._IExam;
import javafx.scene.control.Label;

public class _ExamToBe implements _IExam
{

    Label[] arrayOfOffersExam;
    Label[] number;
    Label[] correctly;
    int START;
    String m;

    public _ExamToBe(Label[] arrayOfOffersExam, Label[] number, Label[] correctly, int START, String m) {
        this.arrayOfOffersExam = arrayOfOffersExam;
        this.number = number;
        this.correctly = correctly;
        this.START = START;
        this.m = m;
    }

    @Override
    public void getExamList() {
        Exams exams = new Exams(arrayOfOffersExam, number, correctly, START, m);
        exams.getExamListDDD();
        System.out.println("test to be");
    }
}
