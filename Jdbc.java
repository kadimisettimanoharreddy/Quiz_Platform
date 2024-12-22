package QUIZ;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbc {
    static Connection jdbcConnection( )  throws ClassNotFoundException, IOException,SQLException{
    	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Properties properties=new Properties( );
	FileReader fr=new FileReader("C:\\Users\\MANOHAR REDDY\\Downloads\\UserDetails.txt");
	properties.load(fr);
	String url = properties.getProperty("url");
    String userName = properties.getProperty("username");
    String password = properties.getProperty("password");
	Connection con=DriverManager.getConnection(url,userName,password);
	return con;

}
	}