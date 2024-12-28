package QUIZ;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ConductQuiz {
    static ArrayList<String> userOptions = new ArrayList<>();

    static void QuestionPaper() throws SQLException, IOException, ClassNotFoundException {
        Connection con = Jdbc.jdbcConnection();
        Statement st = con.createStatement();
        st.execute("USE codegnan");
        ResultSet rs = st.executeQuery("SELECT * FROM Quiz");

        if (!rs.isBeforeFirst()) {
            System.out.println("No questions available. Please consult the admin.");
            return;
        }

        System.out.println("Instructions:");
        System.out.println("1. Each question will be displayed only once.");
        System.out.println("2. Enter a, b, c, or d for your answer.");
        System.out.println("3. You cannot revisit a previous question.");

        int totalQuestions = 0;
        while (rs.next()) {
            System.out.println(rs.getInt(1) + ". " + rs.getString(2));
            String[] options = rs.getString(3).split(",");
            for (String option : options) System.out.println(option);
            System.out.println("Enter your option:");
            Scanner sc = new Scanner(System.in);
            String userOption = sc.next();
            userOptions.add(userOption);
            totalQuestions++;
        }

        System.out.println("Your Result: " + Score() + " out of " + totalQuestions);
    }

    static int Score() throws SQLException, IOException, ClassNotFoundException {
        Connection con = Jdbc.jdbcConnection();
        Statement st = con.createStatement();
        st.execute("USE codegnan");
        ResultSet rs = st.executeQuery("SELECT * FROM Quiz");

        int score = 0;
        int index = 0;
        while (rs.next()) {
            if (rs.getString(4).equalsIgnoreCase(userOptions.get(index))) {
                score++;
            }
            index++;
        }

        return score;
    }
}
