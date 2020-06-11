package dSorting;

public class InsertionSort extends SortAlgorithm {

	private int nextPos;
	private int nextVal;

	public InsertionSort(int[] array) {
		super(array);
	}

	@Override
	void sortData() {
		// for each position in the array from position 2 (index 1)
		for (nextPos = 1; nextPos < data.length; nextPos++) {
			// save next value to insert
			nextVal = data[nextPos];
			// next to track traverse backwards
			int next = nextPos;
			// while the predecessors index is greater than zero and the data stored at
			// index is greater than the nextVal
			while (next > 0 && data[next - 1] > nextVal) {
				// save the index data at index - 1
				data[next] = data[next - 1];
				// decrement next
				next--;
			}
			// save the nextVal at the resulting index position.
			data[next] = nextVal;
		}

	}

}
