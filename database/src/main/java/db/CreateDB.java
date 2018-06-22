package db;

import java.sql.*;

/**
 * Класс создающий базу данных и таблицы имеет один главный параметр <>connection</>
 */
public class CreateDB implements TableDB
{
    /** Подключение к БД */
    private static Connection connection;

    /**
     * Процедура создания новой БД
     * @throws SQLException - ошибка в работе с базой данных
     * @throws ClassNotFoundException - отсутствие драйвера JDBC
     */
    public static void newDB() throws SQLException, ClassNotFoundException {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate(NEW_DB);
    }

    /**
     * Процедура создающая таблицу {@link exam.AddMistakesTable}
     * @throws SQLException - ошибка в работе с базой данных
     * @throws ClassNotFoundException - отсутствие драйвера JDBC
     */
    public static void newCounterFirstRun() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
        Statement statement = connection.createStatement();
        statement.executeUpdate(counterExam);
    }

    /**
     * Функция проверяющая наличие базы данных
     * @return - вернет false если БД нет и вернет true если БД создана
     */
    public static boolean connectDB() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Statement statement;
        try {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
//            e.printStackTrace();
                System.out.println("CreateDB.connectDB1");
            }

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from pg_database WHERE datname = 'text_proposal'");
            while (resultSet.next()) {
                if (resultSet.getString("datname").equals("text_proposal")){
                    resultSet.close();
                    connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Функция проверяющая наличие таблицы ошибок при запуске приложения
     * @return - вернет false если таблица отсутствует и вернет true если создана
     */
    public static boolean newCounterRun() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT table_name FROM information_schema.tables " +
                "WHERE table_name = 'counter';");
        while (resultSet.next()) {
            if (resultSet.getString("table_name").equals("counter")){
                resultSet.close();
                return true;
            }
        }
        return false;
    }
}
