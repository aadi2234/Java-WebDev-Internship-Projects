package Object;

public class Child extends Parent {
	void show()
	{
		System.out.println("Child show method is called");
	}
	public static void main(String args[]) {
		Parent obj = new Child();
	    obj.show();
	}
}
