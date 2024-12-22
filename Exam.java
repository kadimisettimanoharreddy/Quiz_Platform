package QUIZ;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//1.Create properties file UserDetails.txt in file manager
//2.Create data base name as Codegnan in my sql
//3.Create these 4 classes
//4.Run Exam File
public class Exam {
	public static void main(String[] args) throws SQLException,IOException,ClassNotFoundException {
		Scanner sc=new Scanner(System.in) ;
		System.out.println(".....WELCOME.......");
		boolean tryThis=false;
		while(!tryThis) {
			System.out.println("If you are admin please press 1:");
				System.out.println( );
				System.out.println("Do you want to write exam? please press 2");
				System.out.println( );
				System.out.println("Press enter 3 to exit");
				System.out.println();
				int n=sc.nextInt( );
				switch(n) {
				case 1:
					   DataBaseManager.userInput(n);	
					   break;
				case 2:
					   System.out.println("All the Best");
					   DataBaseManager.userInput(n);
					   break;
				case 3:
					  tryThis=true;
					  System.out.println("...Thankyou for visting....Thankyou Prepare Well....");
					  break;
			   default:
				      System.out.println("invaild Option Sorry");
				      break;
				}
		}
	}
}