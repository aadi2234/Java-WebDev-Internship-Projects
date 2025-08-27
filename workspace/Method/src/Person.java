import java.util.Scanner;

public class Person {
	String name;
	int age;
	Scanner sc=new Scanner(System.in);
	void getData()
	{
		System.out.println("Enter name & age:-");
		name=sc.nextLine();
		age=sc.nextInt();
	}
	void display()
	{
		System.out.println("Name="+name);
		System.out.println("Age="+age);
	}
}
