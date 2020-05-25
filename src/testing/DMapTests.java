package testing;

import dMapsSets.DHashTableOpen;

public class DMapTests {
	public DMapTests() {
		DHashTableOpen<Integer, String> dMap = new DHashTableOpen<Integer, String>();
		System.out.println(dMap.isEmpty());

		// does the array index wrap around as it should
		// are collisions resolved correctly
		dMap.put(10, "Douglas");
		dMap.put(110, "Meredith");
		dMap.put(210, "John");
		String entry = dMap.get(210);
		System.out.println(entry);
				
		// are duplicate keys handled appropriately
		dMap.put(10, "John");
		System.out.println(dMap.get(10));
		
		// deleted keys remain in the table but are no longer accessible
		dMap.remove(10);
		System.out.println(dMap.get(10));
		// rehashing occurs at correct load factor (0.75 for open and 3.0 for chaining)
		for(int i = 0; i < 6; i++) {
			dMap.put(i, "Douglas");
		}
		System.out.println(dMap.size());
	}
}
