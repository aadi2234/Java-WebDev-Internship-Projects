import java.util.Scanner;

public class Circle implements Shape {
	Scanner sc= new Scanner(System.in);
	@Override
	public void area() {
		// TODO Auto-generated method stub
		double r,ar;
		System.out.println("Enter radius of Circle:-");
		r=sc.nextDouble();
		ar=3.14*r*r;
		System.out.println("Area of Circle="+ar);
	}

}
