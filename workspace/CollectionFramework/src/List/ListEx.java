package List;

import java.util.*;

public class ListEx {
	public static void main(String args[]) {
		List ls= new ArrayList();
		ls.add("1");
		ls.add("200");
		ls.add(2, "Aditya");
		ls.add("Shailesh");
		ls.contains("Shailesh");
		System.out.println(ls);
		String rem=(String) ls.remove(0);
		System.out.println("Remove Element at index 0:"+rem);
		String gt=(String)ls.get(2);
		System.out.println("Get Element at index 2:"+gt);
		int sz=ls.size();
		System.out.println("Size of List:"+sz);
		boolean b=ls.isEmpty();
		System.out.println("Check list empty or not:"+b);
		int io=ls.indexOf("200");
		System.out.println("Element at index Of:"+io);
		Iterator itr=ls.iterator();  
		while(itr.hasNext())
		{  
			System.out.println(itr.next());  
		}  
		ls.clear();
		System.out.println("Cleared List:"+ls);
	}
}
