
public class Employee extends Person {
	long salary;
	void getData()
	{
		System.out.println("Enter Salary:-");
		salary=sc.nextLong();
	}
	void display()
	{
		System.out.println("Salary="+salary);
	}
}
