package dList;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	

	// TODO: recreate the add method so that using the list is simple (no Node
	// needed)
	// TODO: streamline the add method
	// TODO: simplfy the list for use rather than implementation
	public DoubleLinkedList() {

	}

	public DoubleLinkedList(Node<E> head) {
		this.head = head;
		// if the given head has no next set the tail to this head
		if (head.next == null) {
			this.tail = head;
		} else {

		}

	}

	public DoubleLinkedList(DoubleLinkedList<E> list) {
		// TODO:
	}

	/**
	 * Adds the given node to the list
	 * 
	 * @param node
	 * @return true if addition successful, false otherwise
	 */
	public boolean add(E object) {
		DListIterator iter = new DListIterator(size);
		iter.add(object);
		return true;
	}

	/**
	 * Adds the given node to the list
	 * 
	 * @param node
	 * @return true if addition successful, false otherwise
	 */
	public boolean insert(Node<E> node, int position) {
		
		return true;
	}

	/**
	 * Removes the node at the given position from the list
	 * 
	 * @param node the node to remove
	 * @return true is removal successful, false otherwise
	 */
	public boolean remove(int position) {
		return true;
	}

	/**
	 * Deletes the given object from the list
	 * 
	 * @param node the node to remove
	 * @return true is removal successful, false otherwise
	 */
	public boolean delete(E obj) {
		
		return true;
	}
	
	/**
	 * Returns the node at the given position
	 * 
	 * @param position the index to retrieve the item from
	 * @return
	 */
	public Node<E> get(int position) {
		DListIterator iter = new DListIterator(size);
		Node<E> node = this.head;
		for(int i = 0; i < position -1; i++) {
			node = node.next;
		}
		return node;
	}

	/**
	 * Determines whether or not the list is empty
	 * 
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	// size
	public int getSize() {
		return this.size;
	}

	public class DListIterator {

		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int index;

		public DListIterator(int i) {
			// validate index
			checkIndexRange(i);

			lastItemReturned = null;
			// if the index is the last item in list
			if (i == size) {
				this.index = size;
				nextItem = null;
			} else {
				nextItem = head;
				for (index = 0; index < i; index++) {
					nextItem = nextItem.getNext();
				}
			}
		}

		private void checkIndexRange(int i) {
			if (i < 0 || i > size) {
				throw new IndexOutOfBoundsException("Invalid index " + i);
			}
		}

		/**
		 * Add a new item between the item that will be returned by next and thr item
		 * that will be returned by previous. If previous is called after add, the
		 * element added is returned
		 * 
		 * @param obj The item to be inserted
		 */
		public void add(E obj) {
			if (head == null) { // if adding to empty list
				head = new Node<>(obj);
				tail = head;
			} else {
				// Create a new node
				Node<E> newNode = new Node<E>(obj);
				if (nextItem == head) { // if adding to start
					// link it to the nextItem
					newNode.setNext(nextItem);
					// Link nextItem to te new node
					nextItem.setPrev(newNode);
					// The new node is now the head
					head = newNode;
				} else if (nextItem == null) { // if adding to end
					// Link the tail to the new node
					tail.setNext(newNode);
					// link the new node to the tail
					newNode.setPrev(tail);
					// the new node is the new tail
					tail = newNode;
				} else { // adding to middle
					// Link it to nextItem.prev
					newNode.setPrev(nextItem.getPrev());
					newNode.getPrev().setNext(newNode);
					// Link it to the nextItem
					newNode.setNext(nextItem);
					nextItem.setPrev(newNode);
				}

			}
			size++;
			index++;
			lastItemReturned = null;
		}

		/**
		 * Indicate whether movement forward is possible
		 * 
		 * @return
		 */
		public boolean hasNext() {
			return nextItem != null;
		}

		/**
		 * Indicate whether movement backward is possible
		 * 
		 * @return true if call to previous will not throw an exception
		 */
		public boolean hasPrevious() {
			return (nextItem == null && size != 0) || nextItem.getPrev() != null;
		}

		/**
		 * Move the iterator forward and return the next item
		 * 
		 * @return
		 */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.getNext();
			index++;
			return lastItemReturned.getData();
		}

		public int nextIndex() {
			return 0;
		}

		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if (nextItem == null) {
				nextItem = tail;
			} else {
				nextItem = nextItem.getPrev();
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.getData();
		}

		public int previousIndex() {
			return 0;
		}

		public void remove() {

			// if head 
			// node.next = head.next
			// node.next.prev = node
			// set head
			
			// if tail
			// 
			
			// 
			
			// prev to next
			// next to prev
			// 
			
		}

		public void set(E obj) {
		}
	}

	public static class Node<E> {
		private Node<E> next;
		private Node<E> prev;
		private E data;

		public Node(E obj) {
			this.data = obj;
		}

		// Getters and Setter
		public Node<E> getNext() {
			return this.next;
		}

		public void setNext(Node<E> node) {
			this.next = node;
		}

		public Node<E> getPrev() {
			return this.prev;
		}

		public void setPrev(Node<E> node) {
			this.prev = node;
		}

		public E getData() {
			return this.data;
		}

		public void setData(E obj) {
			this.data = obj;
		}
	}
}
