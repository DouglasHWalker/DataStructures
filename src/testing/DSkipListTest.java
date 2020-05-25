package testing;

import java.util.LinkedList;

import dList.DoubleLinkedList;
import dSkipList.DSkipList;

public class DSkipListTest {
	
	public static final int NUM_TESTS = 2000;
	
	public DSkipListTest() {
		
		LinkedList<Double> skipTests = new LinkedList<Double>();
		LinkedList<Double> listTests = new LinkedList<Double>();
		
		double skipTestOne = 0;
		double skipTestTwo = 0;
		double skipTestThree = 0;
		
		double listTestTwo = 0;
		double listTestOne = 0;
		double listTestThree = 0;

		for(int i = 0; i < NUM_TESTS; i++) {
			for (double d : runListTests(NUM_TESTS)) {
				listTests.add(d);
			}
		}
		for(int i = 0; i < NUM_TESTS; i++) {
			for (double d : runSkipTests(NUM_TESTS)) {
				skipTests.add(d);
			}
		}
		
		// for each test array
		for (int i = 0; i < (NUM_TESTS * 3); i+=3) {
			//for each test in array
			skipTestOne += skipTests.get(i);
			skipTestTwo += skipTests.get(i + 1);
			skipTestThree += skipTests.get(i + 2);
		}
		
		for (int i = 0; i < (NUM_TESTS * 3); i+=3) {
			//for each test in array
			listTestOne += listTests.get(i);
			listTestTwo += listTests.get(i + 1);
			listTestThree += listTests.get(i + 2);
		}
		
		System.out.println(skipTestOne / (NUM_TESTS));
		System.out.println(skipTestTwo / (NUM_TESTS));
		System.out.println(skipTestThree / (NUM_TESTS));
		
		System.out.println(listTestOne / (NUM_TESTS));
		System.out.println(listTestTwo / (NUM_TESTS));
		System.out.println(listTestThree / (NUM_TESTS));
		
		if(skipTestOne < listTestOne) {
			System.out.println("Skip wins insertion");
		} else {
			System.out.println("List wins insertion");
		}
		
		if(skipTestTwo < listTestTwo) {
			System.out.println("Skip wins get last");
		} else {
			System.out.println("List wins get last");
		}
		
		if(skipTestThree < listTestThree) {
			System.out.println("Skip wins get middle");
		} else {
			System.out.println("List wins get middle");
		}
		
	}

	private static double[] runListTests(int numTests) {

		LinkedList<String> list = new LinkedList<String>();
		long startTime = 0;
		long endTime = 0;
		double result = 0;
		double[] listResults = new double[numTests * 3];
		String item = "";
		
		startTime = System.nanoTime();
		for (int i = 0; i < 4; i++) {
			list.add("Douglas");
			list.add("Kelly");
			list.add("John");
			list.add("Meredith");
		}
		list.add("Final");
		endTime = System.nanoTime();
		result = ((double)(endTime - startTime) / 1000000);
		listResults[0] = result;
		System.out.println("List Insert: " + ((double)(endTime - startTime) / 1000000));
		
		int index = 0;
		
		startTime = System.nanoTime();
		item = list.get(16);
		endTime = System.nanoTime();
		result = ((double)(endTime - startTime) / 1000000);
		listResults[1] = result;
		System.out.println("List get last: " + ((double)(endTime - startTime) / 1000000));
		System.out.println(item);
		
		startTime = System.nanoTime();
		item = list.get(list.size()/2);
		endTime = System.nanoTime();
		result = ((double)(endTime - startTime) / 1000000);
		listResults[2] = result;
		System.out.println("List get middle: " + ((double)(endTime - startTime) / 1000000));
		System.out.println(item);
		
		return listResults;
	}

	private static double[] runSkipTests(int numTests) {
		long startTime = 0;
		long endTime = 0;
		double result = 0;
		String item = "";
		double[] skipResults = new double[numTests * 3];
		DSkipList<String> skip = new DSkipList<String>();
		
		startTime = System.nanoTime();
		for (int i = 0; i < 4; i++) {
			skip.insert("Douglas");
			skip.insert("Kelly");
			skip.insert("John");
			skip.insert("Meredith");
		}
		skip.insert("Final");
		endTime = System.nanoTime();
		result = ((double)(endTime - startTime) / 1000000);
		skipResults[0] = result;
		System.out.println("Skip Insert: " + result);
		
		startTime = System.nanoTime();
		item = skip.find("Final");
		endTime = System.nanoTime();
		result = ((double)(endTime - startTime) / 1000000);
		skipResults[1] = result;
		System.out.println("Skip get last: " + ((double)(endTime - startTime) / 1000000));
		System.out.println(item);

		startTime = System.nanoTime();
		item = skip.find("Meredith");
		endTime = System.nanoTime();
		result = ((double)(endTime - startTime) / 1000000);
		skipResults[2] = result;
		System.out.println("Skip get middle: " + ((double)(endTime - startTime) / 1000000));
		System.out.println(item);
		return skipResults;
	}

}
