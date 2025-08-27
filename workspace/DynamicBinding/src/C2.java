import java.util.Scanner;

public class C2 extends P {
	float p,q,r;
	Scanner sc=new Scanner(System.in);
	void accept()
	{
		System.out.println("Enter 2 numbers:-");
		p=sc.nextFloat();
		q=sc.nextFloat();
	}
	void sum()
	{
		r=p+q;
		System.out.println("Addition="+r);
	}
}
