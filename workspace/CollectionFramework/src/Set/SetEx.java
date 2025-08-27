package Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx {
	public static void main() 
	{
		Set <String> st= new HashSet<String>();
		st.add("1");
		st.add("200");
		st.add("Aditya");
		st.add("Shailesh");
		System.out.println("Does the Set contains 'Shailesh'?" + st.contains("Shailesh"));   
		System.out.println(st);
		boolean rem=st.remove("Shailesh");
		System.out.println("Remove Element at index 0:"+rem);
		int sz=st.size();
		System.out.println("Size of List:"+sz);
		boolean b=st.isEmpty();
		System.out.println("Check list empty or not:"+b);
		Iterator itr=st.iterator();  
		while(itr.hasNext())
		{  
			System.out.println(itr.next());  
		}  
		st.clear();
		System.out.println("Cleared List:"+st);
	}
}
