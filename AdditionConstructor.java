import java.util.*;
class AdditionDefaultConstructor
{
    int a,b,c;
    AdditionDefaultConstructor()
    {
        System.out.print("\nDefault Constructor called");
        a=10;
        b=20;
    }
    AdditionDefaultConstructor(int x,int y)
    {
        System.out.print("\nParamaterized Constructor called");
        a=x;
        b=y;
    }
    void sum()
    {
        c=a+b;
    }
    void display()
    {
		System.out.println("\nA:"+a);
		System.out.println("B:"+b);
        System.out.println("Addition of "+a+" & "+b+" = "+c);
    }
    public static void main(String args[]) 
	{
        AdditionDefaultConstructor a=new AdditionDefaultConstructor();
		a.sum();
        a.display();
        AdditionDefaultConstructor b=new AdditionDefaultConstructor(50,30);
		b.sum();
        b.display();
    }
}
