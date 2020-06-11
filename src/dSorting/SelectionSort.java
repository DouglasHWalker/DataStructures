package dSorting;

public class SelectionSort extends SortAlgorithm {
	
	private int n;
	private int fill;
	private int posMin;
	private int next;
	
	public SelectionSort(int[] array) {
		super(array);
		n = this.data.length;
	}
	
	public void sortData() {
		// for fill = 0 to n-2
		for(fill = 0; fill < n-2; fill++) {
			// initialize posMin to fill
			posMin = fill;
			// for next = fill + 1 to n 
			for(next = fill + 1; next < n; next++) {
				// if the item at next is less than the item at posMin
				if(data[next] < data[posMin]) {
					// set posMin to next
					posMin = next;
				}
			}
			// swap the data at posMin with the data at fill
			int temp = data[posMin];
			data[posMin] = data[fill];
			data[fill] = temp;
		}
	}
	
}
