package testing;

import java.util.HashMap;
import java.util.HashSet;

import dList.DoubleLinkedList;

public class DoubleLinkedListTest {
	
	public DoubleLinkedListTest() {
		
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.add("Douglas");
		list.add("John");
		list.add("Meredith");
		list.add("Kelly");
		
		list.remove(2);
		list.delete("Douglas");
		
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(1, "Douglas");
		hmap.put(3, "John");
		hmap.put(0, "Kelly");
		hmap.put(4, "Douglas");
		hmap.put(8, "Meredith");
		
		hmap.remove(8);
		
		HashSet<String> hSet = new HashSet<String>();
		hSet.add("Douglas");
		hSet.add("John");
		hSet.add("Kelly");
		hSet.add("Douglas");
		hSet.add("Meredith");
		
		hSet.remove("Meredith");
		
	}
}
