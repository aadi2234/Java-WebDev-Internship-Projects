package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEx {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

        // Adding elements to the map
        map.put("John", 25);
        map.put("Alice", 30);
        map.put("Bob", 35);

        // Printing the map
        System.out.println("Map: " + map);

        // Accessing values using keys
        int johnAge = map.get("John");
        System.out.println("John's age: " + johnAge);

        // Checking if a key exists
        boolean hasAlice = map.containsKey("Alice");
        System.out.println("Has Alice? " + hasAlice);

        // Checking if a value exists
        boolean hasAge30 = map.containsValue(30);
        System.out.println("Has age 30? " + hasAge30);

        // Updating a value
        map.put("Bob", 40);
        System.out.println("Updated map: " + map);

        // Removing a key-value pair
        map.remove("John");
        System.out.println("Map after removing John: " + map);

        // Iterating over the map using entrySet()
        System.out.println("Iterating over the map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + ": " + value);
        }

        // Getting all the keys
        Set<String> keys = map.keySet();
        System.out.println("Keys: " + keys);

        // Getting all the values
        Collection<Integer> values = map.values();
        System.out.println("Values: " + values);

        // Checking the size of the map
        int size = map.size();
        System.out.println("Size: " + size);

        // Clearing the map
        map.clear();
        System.out.println("Cleared map: " + map);

        // Checking if the map is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is map empty? " + isEmpty);

	}

}
