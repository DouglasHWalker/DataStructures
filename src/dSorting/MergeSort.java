package dSorting;

public class MergeSort extends SortAlgorithm {

	public MergeSort(int[] array) {
		super(array);
	}

	@Override
	void sortData() {
		data = mergeSort(data);

	}

	public int[] mergeSort(int[] array) {
		if (array.length > 1) {
			int halfSize = array.length / 2;
			int[] leftArray = new int[halfSize];
			int[] rightArray = new int[array.length - halfSize];

			for (int i = 0; i < halfSize; i++) {
				leftArray[i] = array[i];
			}

			for (int i = halfSize; i < array.length; i++) {
				rightArray[i - halfSize] = array[i];
			}

			leftArray = mergeSort(leftArray);
			rightArray = mergeSort(rightArray);
			
			array = merge(leftArray, rightArray);

		}
		return array;
	}

	public int[] merge(int[] arrayA, int[] arrayB) {

		int aIndex = 0, bIndex = 0;
		int a = arrayA[aIndex], b = arrayB[bIndex];
		int[] outputArray = new int[arrayA.length + arrayB.length];
		int outputIndex = 0;

		while (aIndex < arrayA.length && bIndex < arrayB.length) {
			a = arrayA[aIndex];
			b = arrayB[bIndex];
			if (a < b) {
				outputArray[outputIndex] = a;
				aIndex++;
			} else {
				outputArray[outputIndex] = b;
				bIndex++;
			}
			outputIndex++;
		}

		for (int i = aIndex; i < arrayA.length; i++) {
			outputArray[outputIndex] = arrayA[i];
			outputIndex++;
		}

		for (int i = bIndex; i < arrayB.length; i++) {
			outputArray[outputIndex] = arrayB[i];
			outputIndex++;
		}

		return outputArray;
	}
}
