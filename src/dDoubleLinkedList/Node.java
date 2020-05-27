package dDoubleLinkedList;

public class Node<E> {

	private Node<E> next = null;
	private Node<E> prev = null;
	private E data;
	
	public Node(E obj) {
		this.data = obj;
	}
	
	public void setNext(Node node) {
		this.next = node;
	}
	
	public void setPrev(Node node) {
		this.prev = node;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Node getPrev() {
		return this.prev;
	}
	
	public E getData() {
		return this.data;
	}
	
	public void setData(E data) {
		this.data = data;
	}
}
