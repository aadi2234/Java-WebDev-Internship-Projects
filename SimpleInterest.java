class SimpleInterest
{
	double SI,principal,rate;
	int time;
	void getData()
	{
		principal=44000;
		rate=5.2;
		time=2;
	}
	void calSI()
	{
		SI=(principal*rate*time)/100;
	}
	void display()
	{
        System.out.println("Principal Amount=" + principal);
        System.out.println("Rate of interest=" + rate + "%");
        System.out.println("Time=" + time + " year(s)");
        System.out.println("Simple Interest=" + SI);
	}
	public static void main(String args[]) 
	{
        SimpleInterest s=new SimpleInterest();
		s.getData();
		s.calSI();
        s.display();
    }
}