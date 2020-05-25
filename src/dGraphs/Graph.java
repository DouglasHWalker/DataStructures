package dGraphs;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Graph {

	private boolean directed;
	private int numV;

	public Graph(int numV, boolean directed) {
		this.numV = numV;
		this.directed = directed;
	}

	/**
	 * @return the directed
	 */
	public boolean isDirected() {
		return directed;
	}

	/**
	 * @param directed the directed to set
	 */
	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	/**
	 * @return the numV
	 */
	public int getNumV() {
		return numV;
	}

	/**
	 * @param numV the numV to set
	 */
	public void setNumV(int numV) {
		this.numV = numV;
	}
}
