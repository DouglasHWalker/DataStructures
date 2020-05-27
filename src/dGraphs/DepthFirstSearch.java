package dGraphs;

import java.util.Iterator;

public class DepthFirstSearch {

	// reference to graph being searched: using this
	private DListGraph graph;
	// array of parents in the depth first search tree
	private int[] parent;
	// flag to indicate whether this vertex has been visited
	private boolean[] visited;
	// Array that contains each vertex in discovery order
	private int[] discoveryOrder;
	// Array that contains each vertex in finish order
	private int[] finishOrder;
	// index that indicates the discovery order
	private int discoverIndex = 0;
	// index that indicates the finish order
	private int finishIndex = 0;

	public DepthFirstSearch(DListGraph graph) {
		this.graph = graph;
		int n = graph.getNumV();
		parent = new int[n];
		visited = new boolean[n];
		discoveryOrder = new int[n];
		finishOrder = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = -1;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				depthFirstSearch(i);
			}
		}
	}

	public DepthFirstSearch(DListGraph graph, int i) {
		this.graph = graph;
		int n = graph.getNumV();
		parent = new int[n];
		visited = new boolean[n];
		discoveryOrder = new int[n];
		finishOrder = new int[n];

		for (int j = i; j < n; j++) {
			depthFirstSearch(j);
		}
	}
	
	public void depthFirstSearch(int current) {
		// mark the current vertex visited
		visited[current] = true;
		discoveryOrder[discoverIndex] = current;
		// examine each vertex adjacent to the current vertex
		Iterator<DEdge> iter = graph.edgeIterator(current);
		while (iter.hasNext()) {
			int neighbor = iter.next().getDest();
			// process neighbor that has not been visited
			if (!visited[neighbor]) {
				// insert (current, neighbor) into parent search tree result
				parent[neighbor] = current;
				// recursively apply algorithm to neighbor
				depthFirstSearch(neighbor);
			}
		}
		// mark current finished
		finishOrder[finishIndex++] = current;
	}

	/**
	 * @return the parent
	 */
	public int[] getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(int[] parent) {
		this.parent = parent;
	}

	/**
	 * @return the discoveryOrder
	 */
	public int[] getDiscoveryOrder() {
		return discoveryOrder;
	}

	/**
	 * @param discoveryOrder the discoveryOrder to set
	 */
	public void setDiscoveryOrder(int[] discoveryOrder) {
		this.discoveryOrder = discoveryOrder;
	}

	/**
	 * @return the finishOrder
	 */
	public int[] getFinishOrder() {
		return finishOrder;
	}

	/**
	 * @param finishOrder the finishOrder to set
	 */
	public void setFinishOrder(int[] finishOrder) {
		this.finishOrder = finishOrder;
	}

}
