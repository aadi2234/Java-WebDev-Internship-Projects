class AreaOfCircle
{
	int r;
	double ar;
	void getData()
	{
		r=5;
	}
	void calArea()
	{
		ar=3.14*r*r;
	}
	void display()
	{
		System.out.println("Radius of Circle="+r);
		System.out.println("Area of Circle="+ar);
	}
	public static void main(String args[])
	{
		AreaOfCircle a=new AreaOfCircle();
		a.getData();
		a.calArea();
		a.display();
	}
}