package DownCasting;

public class Car extends Vehicle {
	 static void method(Vehicle v)
	    {
	        if (v instanceof Car) {
	            Car c = (Car)v;
	            System.out.println("Downcasting performed");
	        }
	    }
	 public static void main(String[] args)
	    {
	        Vehicle v = new Car();
	        Car.method(v);
	    }
}
