package dGraphs;

public class DMatrixGraph extends Graph {

	private DEdge[][] edges;

	public DMatrixGraph(int numV, boolean directed) {
		super(numV, directed);
		// TODO Auto-generated constructor stub
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
}
