package QUIZ;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class ConductQuiz {
	static ArrayList<String> userOptions=new ArrayList< >( );
	static void QuestionPaper( ) throws SQLException,IOException,ClassNotFoundException{
		Connection con=Jdbc.jdbcConnection();
		Statement st=con.createStatement( );
		st.execute("use codegnan");
		ResultSet rs=st.executeQuery("select * from Quiz");
		if(rs.getFetchSize( )>0) {
			System.out.println("Instruction:");
			System.out.println("1.Each question will be displayed only onces");
			System.out.println("2.Once question is displayed you have to enter an either a or b or c or d");
			System.out.println("you cannot revist the previous question");
			
		}
		String arr[]=null;
		int totalQuestions=0;
		while(rs.next( )) {
			System.out.println(rs.getInt(1)+"."+rs.getString(2));
			arr=rs.getString(3).split( ",");
			for(String i:arr) System.out.println(i);
			System.out.println( );
			System.out.println("Enter your option");
			Scanner sc=new Scanner(System.in);
			String op=sc.next( );
			userOptions.add(op);
			System.out.println( );
			totalQuestions++;
		}
		if(arr==null) {
			System.out.println("Exam paper Not prepared Yet please wait for some time...otherwise...please consult you Admin");
			System.out.println();
		}
		else System.out.println("Your Result is "+Score( )+"out of"+totalQuestions);
	}
	static int Score( ) throws SQLException,IOException,ClassNotFoundException{
		Connection con=Jdbc.jdbcConnection();
		Statement st=con.createStatement();
		st.execute("use codegnan");
	    ResultSet rs=st.executeQuery("select *from Quiz");
	    int result=0;
	    int i=0;
	    while(rs.next( )) {
	    	if(rs.getString(4).equals(userOptions.get(i)))
	    	{
	    		result++;
	    	}
	    	i++;
	    }
	    return result;
	    	
			
			
	
		}
		
	}