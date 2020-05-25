package dGraphs;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DMapGraph extends Graph {

	private Map<Integer, DEdge>[] outgoingEdges;
	
	public DMapGraph(int numV, boolean directed) {
		super(numV, directed);
		outgoingEdges = new Map[numV];
		for(int i = 0; i < numV; i++) {
			outgoingEdges[i] = new LinkedHashMap<>();
		}
	}
	
	public void insert(DEdge edge) {
		int source = edge.getSource();
		int dest = edge.getDest();
		double weight = edge.getWeight();
		outgoingEdges[source].put(dest, edge);
		if(isDirected()) {
			DEdge reverseEdge = new DEdge(dest, source, weight);
			outgoingEdges[dest].put(source, reverseEdge);
		}
	}
	
	public boolean isEdge(int source, int dest) {
		return outgoingEdges[source].containsKey(dest);
	}
	
	public DEdge getEdge(int source, int dest) {
		return outgoingEdges[source].get(dest);
	}
	
	public Iterator<DEdge> edgeIterator(int source){
		return outgoingEdges[source].values().iterator();
	}

}
