
public class TestPR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1=new Person();
		Person p2=new Person();
		Student s=new Student();
		Employee emp=new Employee();
		System.out.println("Enter Data of Student:-\n");
		p1.getData();
		s.getData();
		System.out.println("Enter Data of Employee:-\n");
		p2.getData();
		emp.getData();
		System.out.println("Information of Student:-\n");
		p1.display();
		s.display();
		System.out.println("Information of Employee:-\n");
		p2.display();
		emp.display();
	}

}
