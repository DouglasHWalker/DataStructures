package testing;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import dSorting.InsertionSort;
import dSorting.MergeSort;
import dSorting.SelectionSort;

public class SortingTests {

	public SortingTests() {

		long startTime = 0;
		long endTime = 0;
		
		// SELECTION SORT
		System.out.println("SELECTION SORT");
		int[] array = new int[] { 20, 65, 30, 60, 35 };

		printArray(array);
		array = new SelectionSort(array).sortArray();
		printArray(array);

		array = createArray(100);
		array = jumbleArray(array);
		printArray(array);
		array = new SelectionSort(array).sortArray();
		printArray(array);

//		array = createArray(100000);
		array = jumbleArray(array);
//		printArray(array);
		startTime = System.currentTimeMillis();
		array = new SelectionSort(array).sortArray();
		endTime = System.currentTimeMillis();
//		printArray(array);
		System.out.println("SELECTION SORT: " + (endTime - startTime )/ 1000.0 );

		// INSERTION SORT
		System.out.println("INSERTION SORT");
		array = new int[] { 30, 25, 15, 20, 28 };

		printArray(array);
		array = new InsertionSort(array).sortArray();
		printArray(array);

		array = createArray(100);
		array = jumbleArray(array);
		printArray(array);
		array = new InsertionSort(array).sortArray();
		printArray(array);

//		array = createArray(100000);
		array = jumbleArray(array);
//		printArray(array);
		startTime = System.currentTimeMillis();
		array = new InsertionSort(array).sortArray();
		endTime = System.currentTimeMillis();
//		printArray(array);
		System.out.println("INSERTION SORT: " + (endTime - startTime )/ 1000.0 );

		// SHELL SORT

		// MERGE SORT
		new MergeSort(array).merge(new int[] { 1, 3, 5, 7, 9 }, new int[] { 2, 4, 6, 8, 10 });

		System.out.println("MERGE SORT");
		array = new int[] { 50, 60, 45, 30, 90, 20, 80, 15 };

		printArray(array);
		array = new MergeSort(array).sortArray();
		printArray(array);

		array = createArray(100);
		array = jumbleArray(array);
		printArray(array);
		array = new MergeSort(array).sortArray();
		printArray(array);

		array = createArray(100000);
		array = jumbleArray(array);
//		printArray(array);
		startTime = System.currentTimeMillis();
		array = new MergeSort(array).sortArray();
		endTime = System.currentTimeMillis();
//		printArray(array);
		System.out.println("merge SORT: " + (endTime - startTime )/ 1000.0 );

	}

	private int[] jumbleArray(int[] array) {
		Random rnd = ThreadLocalRandom.current();
		for (int i = array.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = array[index];
			array[index] = array[i];
			array[i] = a;
		}
		return array;
	}

	private int[] createArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = i;
		}
		return array;
	}

	private void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
