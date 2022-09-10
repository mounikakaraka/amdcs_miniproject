package training;
//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Types;

public class Dbconnection {
	static Connection con;
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521/orcl.iiht.tech";
		String username="scott";
		String password="tiger";
	    con=DriverManager.getConnection(url,username,password);
		if(con!=null)
			System.out.println("connected successfully");
		else
			System.out.println("connection refused");
		
		/*Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(select * from customer);
		System.out.println("Connected Successfully");*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		/*catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}*/
		}
		
        

	
	
	}


