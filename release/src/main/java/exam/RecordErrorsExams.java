package exam;

import db.TableDB;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static interfaceRoot.ArgumentsExam.improve;
import static interfaceRoot.ArgumentsExam.nameExam;

public class RecordErrorsExams
{
    protected static void mistakesINdb(Label[] arrayOfOffersExam, Label[] number, int i, int START, IExam iExam){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(TableDB.DB_URL + TableDB.db, TableDB.USER, TableDB.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            assert connection != null;
            Statement stmt1 = connection.createStatement();
            arrayOfOffersExam[i].setText(iExam.getExamENG(i, START));
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            String localDateTime = LocalDateTime.now().format(format);
            stmt1.executeUpdate("INSERT INTO counter " +
                    "(date_time, numb, original, mistakes, part)" +
                    "VALUES ('"+localDateTime+"', '"+number[i].getText()+"', '"+
                    arrayOfOffersExam[i].getText()+"', '"+improve.getText()+"', '"+ nameExam.getText() +"');");
            arrayOfOffersExam[i].setText(iExam.getExamRUS(i, START));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
