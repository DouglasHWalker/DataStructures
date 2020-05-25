package dSkipList;

import dMapsSets.DMap;
import dMapsSets.Entry;

public class DSkipNode<E extends Comparable<E>> {
	
	protected DSkipNode<E>[] links;
	protected E data;
	
	public DSkipNode(int m, E data) {
		links = (DSkipNode<E>[]) new DSkipNode[m];
		this.data = data;
	}
}
