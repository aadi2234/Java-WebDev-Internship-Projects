package Exception;

import java.util.Scanner;
class NotMatchException extends Exception
{
    String msg;
    NotMatchException(String msg)
    {
        super(msg);
    }
}
class Password
{
    public static void main(String args[])
    {
        System.out.println("Enter a Password:-");
        Scanner sc= new Scanner(System.in);
        String p=sc.next();
        try {
            {
                if(p.equals("adi2234"))
                {
                    System.out.println("You inputted correct Password");
                }
                else
                {
                    throw new NotMatchException("You inputted incorrect Password");
                }
            }
        }
        catch(NotMatchException e)
        {
            System.err.println(e);
        }
        finally
        {
        	if(p.equals("adi2234"))
            {
                System.out.println("Password is Matched..!!");
            }
            else
            {
            	System.out.println("Password is not Matched..!!");
            }
        }
    }
}
