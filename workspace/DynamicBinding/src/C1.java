import java.util.Scanner;

public class C1 extends P {
	double x,y,z;
	Scanner sc=new Scanner(System.in);
	void accept()
	{
		System.out.println("Enter 2 numbers:-");
		x=sc.nextDouble();
		y=sc.nextDouble();
	}
	void sum()
	{
		z=x+y;
		System.out.println("Addition="+z);
	}
}
