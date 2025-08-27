import java.util.*;
class Addition
{
    int a,b,c;
    void getData()
    {
        a=10;
        b=20;
    }
    void sum()
    {
        c=a+b;
    }
    void display()
    {
		System.out.println("A:"+a);
		System.out.println("B:"+b);
        System.out.println("Addition of "+a+" & "+b+" = "+c);
    }
    public static void main(String args[]) 
	{
        Addition a=new Addition();
		a.getData();
		a.sum();
        a.display();
    }
}
