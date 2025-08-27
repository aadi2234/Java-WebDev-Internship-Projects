
public class Student extends Person {
	int marks;
	void getData()
	{
		System.out.println("Enter Marks:-");
		marks=sc.nextInt();
	}
	void display()
	{
		System.out.println("Marks="+marks);
	}
}
