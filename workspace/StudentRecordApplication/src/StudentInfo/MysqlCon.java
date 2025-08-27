package StudentInfo;
import java.sql.*;
import java.sql.DriverManager;

public class MysqlCon {
	public static Connection con=null;
	public static Connection getCon()
	{
		try
		{
			if(con==null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studdb","root","");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		return con;
	}
}
