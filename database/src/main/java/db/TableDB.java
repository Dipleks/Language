package db;

/**
 * Интерфейс с параметрами входа в базу данных
 * <>db</>, <>DB_URL</>, <>USER</>, <>PASS</>, <>NEW_DB</>, <>my_words</>, <>counterExam</>
 */
public interface TableDB
{
    /** Имя базы данных */
    String db = "text_proposal";

    /** URL базы данных с портом входа 5432 */
    String DB_URL = "jdbc:postgresql://127.0.0.1:5432/";

    /** Логин для авторизации в базе данных */
    String USER = "postgres";

    /** Пароль для авторизации в базе данных */
    String PASS = "353808";

    /** Команда SQL для создания новой базы данных */
    String NEW_DB = "CREATE DATABASE text_proposal;";

    /** Команда SQL для создания таблицы "мои слова" */
    String my_words = "CREATE TABLE IF NOT EXISTS my_words (id SERIAL PRIMARY KEY, word_en TEXT, word_ru TEXT);";

    /** Команда SQL для создания таблицы "статистики ошибок" */
    String counterExam = "CREATE TABLE IF NOT EXISTS counter " +
            "(id SERIAL PRIMARY KEY, date_time timestamp, numb text, " +
            "original text, mistakes text, part VARCHAR(12));";
}
