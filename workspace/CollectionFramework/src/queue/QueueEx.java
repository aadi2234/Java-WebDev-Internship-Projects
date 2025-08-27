package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Queue<String> queue = new LinkedList<>();

	        // Adding elements to the queue
	        queue.add("Apple");
	        queue.offer("Banana");
	        queue.offer("Cherry");

	        // Displaying the queue
	        System.out.println("Queue: " + queue);

	        // Removing and displaying elements from the queue
	        String removedElement = queue.remove();
	        System.out.println("Removed Element: " + removedElement);
	        System.out.println("Queue after removal: " + queue);

	        String polledElement = queue.poll();
	        System.out.println("Polled Element: " + polledElement);
	        System.out.println("Queue after polling: " + queue);

	        // Accessing the front element of the queue
	        String frontElement = queue.element();
	        System.out.println("Front Element: " + frontElement);

	        // Checking if the queue is empty
	        System.out.println("Is Queue empty? " + queue.isEmpty());

	        // Clearing the queue
	        queue.clear();
	        System.out.println("Queue after clearing: " + queue);
	}

}
