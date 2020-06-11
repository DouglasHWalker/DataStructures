package dSorting;

public abstract class SortAlgorithm {
	
	public int[] data;
	
	public SortAlgorithm(int[] array) {
		this.data = array;
	}

	abstract void sortData();

	/**
	 * @return the data
	 */
	public int[] getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int[] data) {
		this.data = data;
	}

	public int[] sortArray() {
		sortData();
		return data;
	}
	
	
}
