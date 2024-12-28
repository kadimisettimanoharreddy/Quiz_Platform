package QUIZ;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseManager {
    static void userInput(int i) throws SQLException, IOException, ClassNotFoundException {
        if (i == 1) {
            boolean connect = false;
            while (!connect) {
                System.out.println("Press 1 to create the table for storing exam paper details (only once)");
                System.out.println("Press 2 to insert questions");
                System.out.println("Press 3 to delete a question");
                System.out.println("Press 4 to update a question");
                System.out.println("Press 5 to exit");
                Scanner sc = new Scanner(System.in);
                int x = sc.nextInt();
                sc.nextLine();
                switch (x) {
                    case 1:
                        DataBaseManager.createTable();
                        break;
                    case 2:
                        System.out.println("Enter the number of questions to insert:");
                        int n = sc.nextInt();
                        sc.nextLine();
                        for (int j = 0; j < n; j++) {
                            System.out.println("Enter question details:");
                            insertQuestion();
                        }
                        break;
                    case 3:
                        System.out.println("Enter the question ID to delete:");
                        int deleteId = sc.nextInt();
                        deleteQuestion(deleteId);
                        break;
                    case 4:
                        System.out.println("Enter the question ID to update:");
                        int updateId = sc.nextInt();
                        updateQuestion(updateId);
                        break;
                    case 5:
                        connect = true;
                        System.out.println("Thank you!");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }
            }
        } else if (i == 2) {
            ConductQuiz.QuestionPaper();
        }
    }

    static void createTable() throws SQLException, IOException, ClassNotFoundException {
        Connection con = Jdbc.jdbcConnection();
        Statement st = con.createStatement();
        st.execute("CREATE DATABASE IF NOT EXISTS codegnan");
        st.execute("USE codegnan");
        String query = "CREATE TABLE IF NOT EXISTS Quiz (qid INT PRIMARY KEY, qd VARCHAR(500), Options VARCHAR(5000), correctOption CHAR(1))";
        st.executeUpdate(query);
        System.out.println("Table created successfully.");
        con.close();
    }

    static void insertQuestion() throws SQLException, IOException, ClassNotFoundException {
        Connection con = Jdbc.jdbcConnection();
        Statement st = con.createStatement();
        st.execute("USE codegnan");
        String query = "INSERT INTO Quiz VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Question ID:");
        int qid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Question Description:");
        String qd = sc.nextLine();
        System.out.println("Enter 4 options (comma-separated):");
        String options = sc.nextLine();
        System.out.println("Enter the correct option (a, b, c, or d):");
        String correctOption = sc.next();
        ps.setInt(1, qid);
        ps.setString(2, qd);
        ps.setString(3, options);
        ps.setString(4, correctOption);
        ps.executeUpdate();
        System.out.println("Question inserted successfully.");
        con.close();
    }

    static void deleteQuestion(int qid) throws SQLException, IOException, ClassNotFoundException {
        Connection con = Jdbc.jdbcConnection();
        Statement st = con.createStatement();
        st.execute("USE codegnan");
        String query = "DELETE FROM Quiz WHERE qid = " + qid;
        st.executeUpdate(query);
        System.out.println("Question deleted successfully.");
        con.close();
    }

    static void updateQuestion(int qid) throws SQLException, IOException, ClassNotFoundException {
        Connection con = Jdbc.jdbcConnection();
        Statement st = con.createStatement();
        st.execute("USE codegnan");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter updated Question Description:");
        String qd = sc.nextLine();
        System.out.println("Enter updated options (comma-separated):");
        String options = sc.nextLine();
        System.out.println("Enter updated correct option (a, b, c, or d):");
        String correctOption = sc.next();
        String query = "UPDATE Quiz SET qd = ?, Options = ?, correctOption = ? WHERE qid = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, qd);
        ps.setString(2, options);
        ps.setString(3, correctOption);
        ps.setInt(4, qid);
        ps.executeUpdate();
        System.out.println("Question updated successfully.");
        con.close();
    }
}
			
			
