package Remainder;

import java.util.Scanner;

public class ReaminderHome 
{
		public static void main(String[] args) 
		{
			int ch;
			Profile p=new Profile();
			Scanner sc = new Scanner(System.in);
			do{
				System.out.println("------Welcome to Remainder App------");
				System.out.println("1. Login");
				System.out.println("2. Register");
				System.out.println("------------------------------------");
				System.out.println("Enter your choice:");
				ch=sc.nextInt();
				switch (ch) 
				{
					case 1:
						p.login();
						break;
					case 2:
						p.register();
						break;
					default:
						 System.out.println("Invalid choice.");
						break;
				}
			}while(ch!=3);
		}

}
