import java.util.*;
class AdditionConstructor
{
    int a,b,c;
    /*AdditionConstructor()
    {
        System.out.print("\nDefault Constructor called");
        a=10;
        b=20;
    }*/
    AdditionConstructor(int a,int b)
    {
        System.out.print("\nParamaterized Constructor called");
        this.a=a;
        this.b=b;
    }
    AdditionConstructor(AdditionConstructor o1,AdditionConstructor o2)
    {
        a=o1.a+o1.a;
        b=o2.b+o2.b;
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
        /*AdditionConstructor a=new AdditionConstructor();
		a.sum();
        a.display();*/
        AdditionConstructor b=new AdditionConstructor(10,30);
		b.sum();
        b.display();
        AdditionConstructor obj3=new AdditionConstructor(50,30);
		obj3.sum();
        obj3.display();
        /*AdditionConstructor d=new AdditionConstructor(b,obj3);
		d.sum();
        d.display();*/
    }
}
