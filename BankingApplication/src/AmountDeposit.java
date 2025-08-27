import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class AmountDeposit extends AccountDetails {
  int damt;

    public void deposit() 
    {
    	Connection con=MysqlCon.getCon();
    	try 
    	{	
	    	System.out.println("Enter Amount Number:");
	        accNo = sc.nextLine();
	        System.out.println("Enter Amount to deposit:");
	        damt = sc.nextInt();
	        
	        PreparedStatement ps1=con.prepareStatement("select * from accounts where accno=?");
	        ps1.setString(1, accNo);
	        ResultSet rs=ps1.executeQuery();
	        while(rs.next())
	        {
	        	cbal=rs.getInt("bal");
	        }
	        cbal=cbal+damt;
	        PreparedStatement ps2=con.prepareStatement("update accounts set bal=? where accno=?");
	        ps2.setInt(1, cbal);
	        ps2.setString(2, accNo);
	        int i=ps2.executeUpdate();
	        if(i>0)
	        {
	        	System.out.println("Deposited Successfully.....");
	        }
	        else
	        {
	        	System.out.println("Failed to Deposit.....");
	        }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }

    void currentBal() 
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