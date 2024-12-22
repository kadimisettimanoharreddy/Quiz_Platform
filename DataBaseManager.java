package QUIZ;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;



public class DataBaseManager {
	static void userInput(int i) throws SQLException,IOException,ClassNotFoundException {
		if(i==1) {
		boolean connect=false;
		while(!connect) {
			System.out.println("press 1 to create table in only ones in the database to store exam paper details ");
			System.out.println("press 2 to insert questions");
			System.out.println("press 3 to delete a question");
			System.out.println("press 4 to update a question");
			System.out.println("press 5 to exit");
			Scanner sc=new Scanner(System.in );
			int x=sc.nextInt();
			sc.nextLine( );
			switch(x) {
			case 1:
				   DataBaseManager.createTable( );
			       break;
		    case 2:
		    	   System.out.println("Enter number of questions u want to insert");
		    	   int n=sc.nextInt( );
		    	   for(int j=0;j<n;j++) {
		    		  System.out.println("Enter Question number:");
		    		  insertQuestion( );
		    	   }
			       break;
			case 3:
				   System.out.println("Please enter the question number you want to delete");
				   int y=sc.nextInt();
				   deleteQuestion(y);
		    	   break;
			case 4:
				   System.out.println("Please enter the question u want to update ");
				   int z=sc.nextInt();
				   updateQuestion(z);
				   break;
			
		    case 5:
                   connect= true;
                   System.out.println("Thank you");
                   break;
            default:
            	   System.out.println("Invalid Option");
                   break;
			}
		}
		}
		if(i==2) {
		ConductQuiz.QuestionPaper( );
			   
		}
		}
				  
	
	static void createTable( )throws SQLException,IOException,ClassNotFoundException{
		Connection con=Jdbc.jdbcConnection( );
		Statement st=con.createStatement();
		st.execute("use codegnan");
		String query="create table Quiz(qid int, qd varchar(5000), Options varchar(5000),correctOption varchar(1))";
		st.executeUpdate(query);
		System.out.println("Table created successfully");
		con.close( );
		
	}
	static void insertQuestion( ) throws SQLException,IOException,ClassNotFoundException{
		Connection con=Jdbc.jdbcConnection();
		Statement st=con.createStatement( );
		st.execute("use codegnan");
		String query="insert into Quiz values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		Scanner sc=new Scanner(System.in);
		int Qid=sc.nextInt( );
		sc.nextLine( );
		System.out.println("Enter Question description");
		String Qd=sc.nextLine( );
		
		int c=97;
		 StringBuilder r = new StringBuilder( );
		for(int i=0;i<4;i++) {
			System.out.println("Enter option "+(char)c+" ");
			String option=sc.nextLine();
			r.append((char)c).append( ",").append(option);
			if(i<3) {
				r.append(" , ");
			}
			c++;
		}
		System.out.println("Enter correct option:");
		String co=sc.next( );
		ps.setInt(1,Qid);
		ps.setString(2,Qd);
		ps.setString(3,String.valueOf(r));
		ps.setString(4,co);
		ps.executeUpdate( );
		System.out.println("Question inserted successfully");
		
	}
	static void deleteQuestion(int x) throws SQLException,IOException,ClassNotFoundException{
		Connection con=Jdbc.jdbcConnection();
		Statement st=con.createStatement( );
		st.execute("use codegnan");
		String query="delete from Quiz where qid="+x;
		st.execute(query);
		System.out.println("Question successfully Deleted");
		con.close( );
		
	}
	static void updateQuestion(int x) throws SQLException,IOException,ClassNotFoundException{
		Connection con=Jdbc.jdbcConnection();
		Statement st=con.createStatement( );
		st.execute("use codegnan");
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter Update question Description:");
	    String qd=sc.nextLine( );
	    int c=97;
	    StringBuilder r=new StringBuilder( );
	    for(int i=0;i<4;i++) {
	    	System.out.println("Enter option:"+(char)c+":");
	    	String option=sc.nextLine( );
	    	r.append((char)c).append(".").append(option);
	    	if(i<3) {
	    		r.append(",");
	    		
	    	}
	    	c++;
	    }
	    System.out.println("Enter correct option(a,b,c or d):");
	    String co=sc.next( );
	    String query="UPDATE Quiz SET qd=?,Options=?,correctOption=? WHERE qid="+x; 
	    PreparedStatement ps=con.prepareStatement(query);
	    ps.setString(2,qd);
	    ps.setString(3,String.valueOf(r));
	    ps.setString(4,co);
	    ps.executeUpdate();
	    System.out.println("Updated successfully");
	    con.close( );
	}
	  		  
			
			
			}
			