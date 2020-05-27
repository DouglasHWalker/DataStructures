package testing;

import dGraphs.DEdge;
import dGraphs.DListGraph;
import dGraphs.DepthFirstSearch;

public class DGraphTests {

	public DGraphTests() {
		DListGraph graph = new DListGraph(10, true);

		// 0 - 3 1
		graph.insert(new DEdge(0, 1, Double.POSITIVE_INFINITY));
		graph.insert(new DEdge(0, 3, Double.POSITIVE_INFINITY));
		// 1 - 2 4 7
		graph.insert(new DEdge(1, 2, Double.POSITIVE_INFINITY));
		graph.insert(new DEdge(1, 4, Double.POSITIVE_INFINITY));
		graph.insert(new DEdge(1, 6, Double.POSITIVE_INFINITY));
		graph.insert(new DEdge(1, 7, Double.POSITIVE_INFINITY));
		// 2 - 3 8 9
		graph.insert(new DEdge(2, 3, Double.POSITIVE_INFINITY));
		graph.insert(new DEdge(2, 8, Double.POSITIVE_INFINITY));
		graph.insert(new DEdge(2, 9, Double.POSITIVE_INFINITY));
		// 4 - 5 6 7
		graph.insert(new DEdge(4, 5, Double.POSITIVE_INFINITY));
		graph.insert(new DEdge(4, 6, Double.POSITIVE_INFINITY));
		graph.insert(new DEdge(4, 7, Double.POSITIVE_INFINITY));
		// 6 - 7
		graph.insert(new DEdge(6, 7, Double.POSITIVE_INFINITY));

		// Breadth first search
		int[] breadthResult = graph.breadthFirstSearch(0);

		DListGraph depthGraph = new DListGraph(7, true);
		// 0 - 1 2 3 4
		depthGraph.insert(new DEdge(0, 1, Double.POSITIVE_INFINITY));
		depthGraph.insert(new DEdge(0, 2, Double.POSITIVE_INFINITY));
		depthGraph.insert(new DEdge(0, 3, Double.POSITIVE_INFINITY));
		depthGraph.insert(new DEdge(0, 4, Double.POSITIVE_INFINITY));
		// 1 - 0 3 4
		depthGraph.insert(new DEdge(1, 3, Double.POSITIVE_INFINITY));
		depthGraph.insert(new DEdge(1, 4, Double.POSITIVE_INFINITY));
		// 2 - 0 5 6
		depthGraph.insert(new DEdge(2, 5, Double.POSITIVE_INFINITY));
		depthGraph.insert(new DEdge(2, 6, Double.POSITIVE_INFINITY));
		// 3 - 0 1 4
		depthGraph.insert(new DEdge(3, 4, Double.POSITIVE_INFINITY));
		// 5 - 2 6
		depthGraph.insert(new DEdge(5, 6, Double.POSITIVE_INFINITY));

		// Depth first search
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch(depthGraph);
//		depthFirstSearch.depthFirstSearch(0);
		int[] depthResult = depthFirstSearch.getParent();
		int[] depthFinishOrder = depthFirstSearch.getFinishOrder();

		// Dijkstra's Algorithm

		// Prim's Algorithm

	}
}
