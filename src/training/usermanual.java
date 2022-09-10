package training;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
@SuppressWarnings("unused")
public class usermanual {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub,
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		while(true) {
		
		System.out.println("select an option\n 1.open account 2.withdraw 3.deposit 4.Check balance 5.exit\n");
		int p=sc.nextInt();
		Banking b=new Banking();
	     switch(p) {
	     case 1:
	   	 System.out.println("enter account type to be opened\n");
	    	 String type=sc.next();
	    	 System.out.println("enter name of customer\n");
	    	 String name=sc.next();
	    	System.out.println("enter initial amount\n");
	    	 int balance=sc.nextInt();
	        b.openAccount(type,name,balance);
	         break;
	         
	           case 2:
	    	 System.out.println("enter amount to withdraw \n");
	    	  long w=sc.nextLong();
	    	  System.out.println("enter account number \n");
	    	  long acno=sc.nextLong();
	  		 b.withdraw(w,acno);
	    	   break;
	     case 3:
	    	 System.out.println("enter amount to be deposited");
	    	 long d=sc.nextLong();
	    	 System.out.println("enter account number \n");
	    	 acno=sc.nextLong();
	 		
	    	 b.deposit(d,acno);
	    	 break;
	     case 4:
	    	 System.out.println("enter your account id");
	    	 long accno=sc.nextLong();
	    	 b.checkBal(accno);
	    	 break;
	     case 5:
	    	 System.out.println("exit");
	    	 return;
	    	 default:
	    		 System.out.println("please enter correct input");
	    		 break;
	     }
	}
	}
}


	
