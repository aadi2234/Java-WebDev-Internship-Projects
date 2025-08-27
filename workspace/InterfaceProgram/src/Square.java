import java.util.Scanner;

public class Square implements Shape {
	Scanner sc= new Scanner(System.in);
	@Override
	public void area() {
		// TODO Auto-generated method stub
			double s,ar;
			System.out.println("Enter Side of Square:-");
			s=sc.nextDouble();
			ar=s*s;
			System.out.println("Area of Square="+ar);
		}
}
