package QUIZ;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println(".....WELCOME.......");

        boolean exit = false;
        while (!exit) {
            System.out.println("Press 1 if you are an admin.");
            System.out.println("Press 2 to write the exam.");
            System.out.println("Press 3 to exit.");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    DataBaseManager.userInput(1);
                    break;
                case 2:
                    System.out.println("All the Best!");
                    DataBaseManager.userInput(2);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you! Prepare well.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
	
