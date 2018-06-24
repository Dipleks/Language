package exams;

import javafx.scene.layout.HBox;

/**
 * Класс создающий таблицу {@link Exams#getExamListDDD()} с параметрами
 * <>dateTime</>, <>numberText</>, <>originalText</>, <>mistakesText</>, <>numberPart</>
 */
public class AddMistakesTable
{
    /** Время и дата ошибки */
    private String dateTime;

    /** Номер значения */
    private String numberText;

    /** Оригинальное значение */
    private String originalText;

    /** Полученое значение от пользователя */
    private HBox mistakesText;

    /** Номер выполняемой контрольной */
    private String numberPart;

    /**
     * Конструктор создающий новый объект с параметрами
     * @param dateTime - дата и время
     * @param numberText - номер значения
     * @param originalText - значение
     * @param mistakesText - значние полученное от пользователя
     * @param numberPart - номер части Контрольной
     */
    public AddMistakesTable(String dateTime, String numberText, String originalText, HBox mistakesText, String numberPart) {
        this.dateTime = dateTime;
        this.numberText = numberText;
        this.originalText = originalText;
        this.mistakesText = mistakesText;
        this.numberPart = numberPart;
    }

    /**
     * Функция возврата
     * @return - {@link AddMistakesTable#dateTime}
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Функция возврата
     * @return - {@link AddMistakesTable#numberText}
     */
    public String getNumberText() {
        return numberText;
    }

    /**
     * Функция возврата
     * @return - {@link AddMistakesTable#originalText}
     */
    public String getOriginalText() {
        return originalText;
    }

    /**
     * Функция возврата
     * @return - {@link AddMistakesTable#mistakesText}
     */
    public HBox getMistakesText() {
        return mistakesText;
    }

    /**
     * Функция возврата
     * @return - {@link AddMistakesTable#numberPart}
     */
    public String getNumberPart() {
        return numberPart;
    }

    /**
     * Функция возврата
     * @return - возврат строкового значения
     */
    @Override
    public String toString() {
        return "AddMistakesTable{" +
                "dateTime='" + dateTime + '\'' +
                ", numberText='" + numberText + '\'' +
                ", originalText='" + originalText + '\'' +
                ", mistakesText=" + mistakesText +
                ", numberPart='" + numberPart + '\'' +
                '}';
    }
}
