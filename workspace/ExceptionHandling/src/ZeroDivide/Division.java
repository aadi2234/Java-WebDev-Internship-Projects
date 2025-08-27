package ZeroDivide;

import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a,b,res;
		try{
			System.out.println("Enter 2 numbers:-");
			a=sc.nextInt();
			b=sc.nextInt();
			res=a/b;
			System.out.println("Division="+res);
		}
		catch(Exception e)
		{
			System.out.println("Check input \n Cannot divide by Zero");
			System.out.println(e);
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Division performed...");
		}
		sc.close();
	}

}
