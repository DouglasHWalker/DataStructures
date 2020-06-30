package dSorting;

public class HeapSort extends SortAlgorithm {
	
	public HeapSort(int[] array) {
		super(array);
		buildHeap(array);
	}
	
	private void buildHeap(int[] array) {
		
		int n = 0;
		
		while(n < array.length) {
			n++;
			int child = n-1;
			int parent = (child -1) / 2;
			while(parent >= 0 && array[parent] < array[child]) {
				swap(array, parent, child);
				child = parent;
				parent = (child - 1) / 2;
			}
		}
		
		data = array;
	}
	
	private void swap(int[] array, int parent, int child) {
		int temp = array[parent];
		array[parent] = array[child];
		array[child] = temp;
	}

	@Override
	void sortData() {
		int n = data.length;
		while(n > 0) {
			n--;
			swap(data, 0 , n);
			int parent = 0;
			while(true) {
				int leftChild = 2 * parent + 1;
				if(leftChild >= n) {
					break; // no more children
				}
				int rightChild = leftChild + 1;
				int maxChild = leftChild;
				if(rightChild < n && data[leftChild] < data[rightChild]) {
					maxChild = rightChild;
				}
				if(data[parent] < data[maxChild]) {
					swap(data, parent, maxChild);
					parent = maxChild;
				} else {
					break;
				}
			}
		}
	}
}
