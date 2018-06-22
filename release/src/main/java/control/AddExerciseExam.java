package control;

import exam.FillingColumnsExam;
import exercise.FillingColumnsExercise;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Класс выводящий список кнопок и колонки с заданиями и контрольными.
 * Входные параметры класса: <>appPS</>, <>negPS</>, <>quesPS</>, <>examPS</>,
 * <>appToBe</>, <>negToBe</>, <>quesToBe</>, <>examToBe</>,
 * <>controlExercisePS</>, <>controlExamPS</>, <>controlExerciseToBe</>, <>controlExamToBe</>
 */
public class AddExerciseExam
{
    /** утверждения PS */
    private FillingColumnsExercise[] appPS = new FillingColumnsExercise[7];

    /** отрицания PS */
    private FillingColumnsExercise[] negPS = new FillingColumnsExercise[4];

    /** вопросы PS */
    private FillingColumnsExercise[] quesPS = new FillingColumnsExercise[7];

    /** контрольные PS */
    private FillingColumnsExam[] examPS = new FillingColumnsExam[7];

    /** утверждения To Be */
    private FillingColumnsExercise[] appToBe = new FillingColumnsExercise[6];

    /** отрицания To Be */
    private FillingColumnsExercise[] negToBe = new FillingColumnsExercise[4];

    /** вопросы To Be */
    private FillingColumnsExercise[] quesToBe = new FillingColumnsExercise[7];

    /** контрольные To Be */
    private FillingColumnsExam[] examToBe = new FillingColumnsExam[1];

    /** кнопки выбора упражнений PS */
    private Control controlExercisePS = new Control();

    /** кнопки выбора контрольных PS*/
    private Control controlExamPS = new Control();

    /** кнопки выбора упражнений To Be*/
    private Control controlExerciseToBe = new Control();

    /** кнопки выбора контрольных To Be*/
    private Control controlExamToBe = new Control();

    /**
     * Процедура добавления кнопок упражнений PS
     */
    public void AddMenuButtonPS(){
        getExercisePS();
    }

    /**
     * Процедура добавления кнопок контрольных PS
     */
    public void AddMenuButtonExamPS(){
        getExamPS();
    }

    /**
     * Процедура добавления кнопок упражнений To Be
     */
    public void AddMenuButtonToBe(){
        getExerciseToBe();
    }

    /**
     * Процедура добавления кнопок контрольных To Be
     */
    public void AddMenuButtonExamToBe(){
        getExamToBe();
    }

    /**
     * Процедура добавления кнопок и вызова по клику упражнений PS
     */
    private void getExercisePS(){

        appPS[0] = new FillingColumnsExercise(new Label[15], new Label[15],0, 15, "PS");
        appPS[1] = new FillingColumnsExercise(new Label[15], new Label[15],30, 45, "PS");
        appPS[2] = new FillingColumnsExercise(new Label[15], new Label[15], 60, 75, "PS");
        appPS[3] = new FillingColumnsExercise(new Label[15], new Label[15],90, 105, "PS");
        appPS[4] = new FillingColumnsExercise(new Label[15], new Label[15],120, 135, "PS");
        appPS[5] = new FillingColumnsExercise(new Label[15], new Label[15],150, 165, "PS");
        appPS[6] = new FillingColumnsExercise(new Label[6], new Label[7],180, 186, "PS");

        negPS[0] = new FillingColumnsExercise(new Label[15], new Label[15],193, 208, "PS");
        negPS[1] = new FillingColumnsExercise(new Label[15], new Label[15],223, 238, "PS");
        negPS[2] = new FillingColumnsExercise(new Label[15], new Label[15],253, 268, "PS");
        negPS[3] = new FillingColumnsExercise(new Label[14], new Label[15],283, 297, "PS");

        quesPS[0] = new FillingColumnsExercise(new Label[15], new Label[15],312, 327, "PS");
        quesPS[1] = new FillingColumnsExercise(new Label[15], new Label[15],342, 357, "PS");
        quesPS[2] = new FillingColumnsExercise(new Label[15], new Label[15],372, 387, "PS");
        quesPS[3] = new FillingColumnsExercise(new Label[15], new Label[15],402, 417, "PS");
        quesPS[4] = new FillingColumnsExercise(new Label[15], new Label[15],432, 447, "PS");
        quesPS[5] = new FillingColumnsExercise(new Label[15], new Label[15],462, 477, "PS");
        quesPS[6] = new FillingColumnsExercise(new Label[12], new Label[12],492, 504, "PS");

        controlExercisePS.exercise(appPS, negPS, quesPS,
                new Button[7], new Button[4], new Button[7], "AddMenuButtonPS");
    }

    /**
     * Процедура добавления кнопок и вызова по клику контрольных PS
     */
    private void getExamPS(){

        examPS[0] = new FillingColumnsExam(new Label[100], new Label[100], new Label[100],  0, "ExamPS");
        examPS[1] = new FillingColumnsExam(new Label[100], new Label[100], new Label[100],  100, "ExamPS");
        examPS[2] = new FillingColumnsExam(new Label[100], new Label[100], new Label[100],  200, "ExamPS");
        examPS[3] = new FillingColumnsExam(new Label[100], new Label[100], new Label[100],  300, "ExamPS");
        examPS[4] = new FillingColumnsExam(new Label[100], new Label[100], new Label[100],  400, "ExamPS");
        examPS[5] = new FillingColumnsExam(new Label[100], new Label[100], new Label[100],  500, "ExamPS");
        examPS[6] = new FillingColumnsExam(new Label[100], new Label[100], new Label[100],  600, "ExamPS");

        controlExamPS.examMethod(examPS,new Button[7], "AddMenuButtonExamPS");
    }

    /**
     * Процедура добавления кнопок и вызова по клику упражнений To Be
     */
    private void getExerciseToBe(){

        appToBe[0] = new FillingColumnsExercise(new Label[15], new Label[15],0, 15, "ToBe");
        appToBe[1] = new FillingColumnsExercise(new Label[15], new Label[15],30, 45, "ToBe");
        appToBe[2] = new FillingColumnsExercise(new Label[15], new Label[15], 60, 75, "ToBe");
        appToBe[3] = new FillingColumnsExercise(new Label[15], new Label[15],90, 105, "ToBe");
        appToBe[4] = new FillingColumnsExercise(new Label[15], new Label[15],120, 135, "ToBe");
        appToBe[5] = new FillingColumnsExercise(new Label[19], new Label[19],150, 169, "ToBe");

        negToBe[0] = new FillingColumnsExercise(new Label[15], new Label[15],193, 208, "ToBe");
//        negToBe[1] = new FillingColumnsExercise(new Label[15], new Label[15],223, 238);
//        negToBe[2] = new FillingColumnsExercise(new Label[15], new Label[15],253, 268);
//        negToBe[3] = new FillingColumnsExercise(new Label[14], new Label[15],283, 297);

        quesToBe[0] = new FillingColumnsExercise(new Label[15], new Label[15],312, 327, "ToBe");
//        quesToBe[1] = new FillingColumnsExercise(new Label[15], new Label[15],342, 357);
//        quesToBe[2] = new FillingColumnsExercise(new Label[15], new Label[15],372, 387);
//        quesToBe[3] = new FillingColumnsExercise(new Label[15], new Label[15],402, 417);
//        quesToBe[4] = new FillingColumnsExercise(new Label[15], new Label[15],432, 447);
//        quesToBe[5] = new FillingColumnsExercise(new Label[15], new Label[15],462, 477);
//        quesToBe[6] = new FillingColumnsExercise(new Label[12], new Label[12],492, 504);

        controlExerciseToBe.exercise(appToBe, negToBe, quesToBe,
                new Button[6], new Button[1], new Button[1], "AddMenuButtonToBe");
    }

    /**
     * Процедура добавления кнопок и вызова по клику контрольных To Be
     */
    private void getExamToBe(){

        examToBe[0] = new FillingColumnsExam(new Label[100], new Label[100], new Label[100],  0, "ExamToBe");
//        examToBe[1] = new FillingColumnsExam(new Label[100], new Label[100], new Label[100],  100);

        controlExamToBe.examMethod(examToBe,new Button[1], "AddMenuButtonExamToBe");
    }


}
