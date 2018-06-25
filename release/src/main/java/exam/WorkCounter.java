package exam;

import javafx.scene.control.Label;

import static interfaceRoot.ArgumentsExam.counterNO;
import static interfaceRoot.ArgumentsExam.counterYES;

public class WorkCounter
{
    /**
     * Процедура подсчеёта данных {@link Exams#correctly}
     */
    protected void counterRun(Label[] labels){
        int a = 0;
        int b = 0;
        for (int j = 0; j < 100; j++) {
            if (labels[j].getText().equals("ВЕРНО!!!")){
                ++a;
            } else if (labels[j].getText().equals("НЕ ВЕРНО!!!")) {
                ++b;
            }
        }
        counterYES.setText(String.valueOf(a));
        counterNO.setText(String.valueOf(b));
    }
}
