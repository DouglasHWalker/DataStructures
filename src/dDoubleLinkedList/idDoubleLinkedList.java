package dDoubleLinkedList;

public interface idDoubleLinkedList<E> {
	
	/**
	 * inserts the given object into position index
	 * @param index the position to insert object
	 * @param obj the object to insert
	 */
	public void add(int index, E obj);
	/**
	 * insert object at first position in the list
	 * @param obj the object to insert
	 */
	public void addFirst(E obj);
	/**
	 * insert the object at last position in the list
	 * @param obj
	 */
	public void addLast(E obj);
	/**
	 * returns the item at index 
	 * @param index the position from which to return the item
	 * @return
	 */
	public E get(int index);
	/**
	 * returns the first item in the index
	 * @return the first item in the list
	 */
	public E getFirst();
	/**
	 * Returns the last item in the index
	 * @return the lat item in the list
	 */
	public E getLast();
	/**
	 * Remove the given object from the list
	 * @param obj the object to remove from the list
	 * @return
	 */
	public boolean remove(E obj);
	/**
	 * returns the size of the list
	 * @return the size of the list
	 */
	public int size();
}
