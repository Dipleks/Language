package exam;

import javafx.scene.control.Label;

public class Exam
{
    private Label[] arrayOfOffersExam;
    private Label[] number;
    private Label[] correctly;
    private int START;
    private String m;
    private ExamText exam = new ExamText();

    IExam exams;

    public Exam(IExam exams) {
        this.exams = exams;
    }

    public static void main(String[] args) {
        Exam exam = new Exam(new ExamPS());
        exam.exams.getExamList();
    }
}
