
public class TestBank {

	public static void main(String[] args) {
		Bank b;  
		b=new SBI();  
		System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
		b=new BOB();  
		System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
	}

}
