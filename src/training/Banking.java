package training;
import training.Dbconnection;
import java.sql.*;
import java.sql.Types;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import oracle.jdbc.driver.OracleDriver;
@SuppressWarnings("unused")
public class Banking  {
     static Connection con=Dbconnection.getConnection();

     public void openAccount(String type, String name, int balance)throws ClassNotFoundException,SQLException {
		try {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT MAX(cid) FROM Cus");
			long max=0;
			//balance=1000;
			while(result.next())
			{
				max=result.getLong("MAX(cid)");
			}
			max+=100;
			String q="Insert into cus(cid,cname,cbalance,ctype)VALUES("+max+","+name+","+balance+","+type+")";
			int count=stmt.executeUpdate(q);
			if(count>0)
			{
				System.out.println("account with account id"+max+" is created");
			}
			else
				System.out.println("oops! something went wrong");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void withdraw(long amt,long acno)throws ClassNotFoundException,SQLException {
	try
	{
		Statement stmt=con.createStatement();
		ResultSet result=stmt.executeQuery("SELECT cbalance from cus where cid="+acno+" ");
		long amnt=0;
		while(result.next())
			 amnt=result.getInt(1);
		if(amnt<amt) {
			System.out.println("insufficient balance");
		}else {
			amnt=amnt-amt;
			ResultSet res=stmt.executeQuery("UPDATE cus SET cbalance =" +amnt+ "where cid=" +acno+ " ");
			ResultSet rest=stmt.executeQuery("SELECT cbalance from cus where cid="+acno+" ");
			long amtt=0;
			while(rest.next()) {
				amtt=rest.getInt("cbalance");
			}
			System.out.println("successful withdraw..current balance is"+amtt);
			
		}
	}
		catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	public void checkBal(long acno)throws ClassNotFoundException,SQLException {
		try {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT cbalance from cus where cid="+acno+" ");
			int amt=0;
			while(result.next())
			{
				amt=result.getInt("cbalance");
				
			}
			System.out.println("current balance is:"+amt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
    public void deposit(long amt, long acno)throws ClassNotFoundException,SQLException {
		try {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT cbalance from cus where cid="+acno+" ");
		     long amnt=0;
			while(result.next())
			{
				amt=result.getInt("cbalance");
				
			}
			amnt=amnt+amt;
			@SuppressWarnings("unused")
			ResultSet res=stmt.executeQuery("UPDATE cus SET cbalance="+amnt+"where cid="+acno+" ");
			ResultSet rest=stmt.executeQuery("SELECT cbalance from cus where cid="+acno+" ");
			long amtt=0;
			while(rest.next()) {
				amtt=rest.getInt("cbalance");
			}
			System.out.println("successful deposit..current balance is"+amtt);
			
		
	}
		catch(Exception e) {
			e.printStackTrace();

}
    }

}
