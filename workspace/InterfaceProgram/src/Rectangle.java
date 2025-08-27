import java.util.Scanner;

public class Rectangle implements Shape {
	Scanner sc= new Scanner(System.in);
	@Override
	public void area() {
		// TODO Auto-generated method stub
			double l,b,ar;
			System.out.println("Enter length and breadth of Rectangle:-");
			l=sc.nextDouble();
			b=sc.nextDouble();
			ar=l*b;
			System.out.println("Area of Rectangle="+ar);
		}

	}

