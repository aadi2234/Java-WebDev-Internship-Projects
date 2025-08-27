package ThreadPR;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Number implements Runnable {
	public void run()
	{
		System.out.println("----Reversed Timer----\n");
		try
		{
			for(int i=10;i>=1;i--)
			{
				System.out.println("     "+i);
				Thread.sleep(1000);
			}
			System.out.println("----Timer----\n");
			for(int i=1;i<=10;i++)
			{
				System.out.println("     "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie)
		{
			System.out.println(ie);
		}
	}
	public static void main(String args[])
	{
		Number n1=new Number();
		Thread t1=new Thread(n1);
		t1.start();
		Number n2=new Number();
		Thread t2=new Thread(n2);
		t2.start();
	}
}
