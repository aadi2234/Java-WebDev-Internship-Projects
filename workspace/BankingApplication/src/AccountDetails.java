import java.sql.*;
import java.util.Scanner;

public class AccountDetails 
{
    String accNo,cname,cmob;
    int cbal;
    Scanner sc = new Scanner(System.in);

    public void addUser() 
    {
    	Connection con=MysqlCon.getCon();
        System.out.println("Enter Account No.:");
        accNo = sc.next();
        sc.nextLine();
        System.out.println("Enter Account Holder Name:");
        cname = sc.nextLine();
        System.out.println("Enter Mobile Number:");
        cmob = sc.nextLine();
        System.out.println("Enter Account Opening Balance:");
        cbal = sc.nextInt();
      
        try
        {
        	Statement st=con.createStatement();
        	int i=st.executeUpdate("insert into accounts values('"+accNo+"','"+cname+"','"+cmob+"','"+cbal+"')");
        	if(i > 0)
        	{
        		System.out.println("Account created Successfully...!!");
        	}
        	else
        	{
        		System.err.println("Failed to create account...!!");
        	}
        }
        catch(SQLException e)
        {
        	System.out.println(e);
        	e.printStackTrace();
        }
    }

    public void viewUser() 
    {
    	Connection con=MysqlCon.getCon();
    	sc.nextLine();
        System.out.println("Enter Account No.: ");
        accNo=sc.nextLine();
    	
        try
        {
        	Statement st1=con.createStatement();
        	ResultSet rs=st1.executeQuery("select * from accounts where accno='"+accNo+"'");
        	while(rs.next())
        	{
        		System.out.println("------------------------------------------");
        		System.out.println("Account Number="+rs.getString(1));
        		System.out.println("Account Holder Name="+rs.getString(2));
        		System.out.println("Mobile Number="+rs.getString(3));
        		System.out.println("Balance="+rs.getInt(4));
        		System.out.println("------------------------------------------");
        	}
        }
        catch(SQLException e)
        {
        	System.out.println(e);
        	e.printStackTrace();
        }
    }

    void checkBalance() 
    {
    	Connection con=MysqlCon.getCon();
        try
        {
        	Statement st1=con.createStatement();
        	ResultSet rs=st1.executeQuery("select * from accounts");
        	while(rs.next())
        	{
        		System.out.println("------------------------------------------");
        		System.out.println("Account Number="+rs.getString(1));
        		System.out.println("Account Holder Name="+rs.getString(2));
        		System.out.println("Mobile Number="+rs.getString(3));
        		System.out.println("Balance="+rs.getInt(4));
        		System.out.println("------------------------------------------");
        	}
        }
        catch(SQLException e)
        {
        	System.out.println(e);
        	e.printStackTrace();
        }
    }
}
