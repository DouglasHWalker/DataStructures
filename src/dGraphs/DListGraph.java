package dGraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DListGraph extends Graph {

	private LinkedList<DEdge>[] edges;

	public DListGraph(int numV, boolean directed) {
		super(numV, directed);
		edges = new LinkedList[numV];
		for (int i = 0; i < numV; i++) {
			edges[i] = new LinkedList<DEdge>();
		}
	}

	public DEdge getEdge(int source, int dest) {
		DEdge target = new DEdge(source, dest, Double.POSITIVE_INFINITY);
		for (DEdge edge : edges[source]) {
			if (edge.equals(target)) {
				return edge;
			}
		}
		return null;
	}

	public Iterator<DEdge> edgeIterator(int source) {
		return edges[source].iterator();
	}

	public boolean isEdge(int source, int dest) {
		return edges[source].contains(new DEdge(source, dest));
	}

	public void insert(DEdge edge) {
		edges[edge.getSource()].add(edge);
		if (isDirected()) {
			// add the edge going opposite direction
			edges[edge.getDest()].add(new DEdge(edge.getDest(), edge.getSource(), edge.getWeight()));
		}
	}
	
	public int[] breadthFirstSearch(int start) {

		Queue<Integer> theQueue = new LinkedList<Integer>();
		// Declare array parent and initialize its elements to -1
		int[] parent = new int[this.getNumV()];
		for (int i = 0; i < this.getNumV(); i++) {
			parent[i] = -1;
		}

		// Declare array identified and specify its elements to false
		boolean[] identified = new boolean[this.getNumV()];
		// make the start vertex as identified and insert it into the queue
		identified[start] = true;
		theQueue.offer(start);

		// perform breadth-first search until done
		while(!theQueue.isEmpty()) {
			// take a vertex, current, out of the queue (begin visiting current)
			int current = theQueue.poll();
			// examine each vertex, neighbor, adjacent to current
			Iterator<DEdge> iter = this.edgeIterator(current);
			while(iter.hasNext()) {
				DEdge edge = iter.next();
				int neighbor = edge.getDest();
				// if the neighbor has not been identified
				if(!identified[neighbor]) {
					// mark as identified
					identified[neighbor] = true;
					// place into queue
					theQueue.offer(neighbor);
					// insert the edge (current, neighbor) into the tree
					parent[neighbor] = current;
				}
			} // finished visiting current
		}
		return parent;
	}
}
