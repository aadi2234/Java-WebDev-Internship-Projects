package Gross_Salary;

import java.util.Scanner;

public class Employee{
	Scanner sc=new Scanner(System.in);
	int age;
    String name;
    void accept()
    {
        System.out.print("Enter age:-");
        age= sc.nextInt();
        System.out.print("Enter Name:-");
        name= sc.next();
    }
    void display()
    {
        System.out.println("Name-"+name+"\nAge="+age);
    }
    
}
