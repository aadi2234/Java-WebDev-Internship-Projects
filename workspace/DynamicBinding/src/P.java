import java.util.Scanner;

public class P {
	int a,b,c;
	Scanner sc=new Scanner(System.in);
	void accept()
	{
		System.out.println("Enter 2 numbers:-");
		a=sc.nextInt();
		b=sc.nextInt();
	}
	void sum()
	{
		c=a+b;
		System.out.println("Addition="+c);
	}
}
