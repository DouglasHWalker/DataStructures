package dDoubleLinkedList;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements idDoubleLinkedList<E> {

	private Node head;
	private Node tail;
	private int size;

	/**
	 * Creates a empty double linked list
	 */
	public DoubleLinkedList() {
		this.size = 0;
	}

	/**
	 * Creates a DoubleLinkedList using given head to start the chain
	 * 
	 * @param head
	 */
	public DoubleLinkedList(Node head) {
		this.head = head;
		// TODO: implement the deep copy
	}

	public DoubleLinkedList(DoubleLinkedList<E> list) {
		// TODO: LinkedList implementation
	}

	@Override
	public void add(int index, E obj) {
		// check if the given object is null
		if (obj == null) {
			System.out.println("");
		} else if (index == 0) {  // if not check if the index is aimed at head
			this.addFirst(obj);
		} else if (index == this.size) {
			this.addLast(obj);
		} else {
			
		}

		// link new node to predecessors
		// link old predecessor object to new predecessor obj.prev.next
		// link to new predecessor

	}

	@Override
	public void addFirst(E obj) {
		Node<E> node = new Node<E>(obj);

		node.setNext(this.head);
		this.head.setPrev(node);
		this.head = node;

		if (this.size == 0) {
			this.tail = node;
		}

		this.size++;
	}

	@Override
	public void addLast(E obj) {
		Node<E> node = new Node<E>(obj);

		node.setNext(null);
		node.setPrev(this.tail.getPrev());
		this.tail.setNext(node);

		this.tail = node;

		if (this.size == 0) {
			this.head = node;
		}

		this.size++;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(E obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public class ListIterator<E> {
		
		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int index;
		
		public ListIterator(int i){
			// validate i parameter
			if(i < 0 || i > size) {
				throw new IndexOutOfBoundsException();
			}
			
			lastItemReturned = null; // no item returned yet.
			// special case of last item
			if(i == size) {
				index = size;
				nextItem = null;
			} else {
				nextItem = head;
				for(index = 0; index < i; index++) {
					nextItem = nextItem.getNext();
				}
			}
		}
		
		public boolean hasNext() {
			return nextItem != null;
		}
		
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.getNext();
			index++;
			return lastItemReturned.getData();
		}
	}

}
