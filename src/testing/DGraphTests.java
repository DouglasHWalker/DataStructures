package testing;

import dGraphs.DEdge;
import dGraphs.DListGraph;
import dGraphs.DepthFirstSearch;

public class DGraphTests {

	public DGraphTests() {
		DListGraph graph = new DListGraph(10, false);

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

		DListGraph depthGraph = new DListGraph(7, false);
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
		DListGraph dijktrasGraph = new DListGraph(5, true);
		// 0 - 1 3 4
		dijktrasGraph.insert(new DEdge(0, 1, 10.0));
		dijktrasGraph.insert(new DEdge(0, 3, 30.0));
		dijktrasGraph.insert(new DEdge(0, 4,  100.0));
		// 1 - 2
		dijktrasGraph.insert(new DEdge(1, 2,  50.0));
		// 2 - 4
		dijktrasGraph.insert(new DEdge(2, 4, 10.0));
		// 3 - 2 4
		dijktrasGraph.insert(new DEdge(3, 2,  20.0));
		dijktrasGraph.insert(new DEdge(3, 4,  60.0));
		
		int[] predecessor = new int[5];
		double[] distance = new double[5];
		dijktrasGraph.dijkstasAlgorithm(0, distance, predecessor);
		
		// Prim's Algorithm
		DListGraph primsGraph = new DListGraph(6, false);
		// 0 - 1 2 3
		primsGraph.insert(new DEdge(0, 1, 6.0));
		primsGraph.insert(new DEdge(0, 2, 1.0));
		primsGraph.insert(new DEdge(0, 3,  5.0));
		// 1 - 2 4
		primsGraph.insert(new DEdge(1, 2,  5.0));
		primsGraph.insert(new DEdge(1, 4,  3.0));
		// 2 - 3 4 5
		primsGraph.insert(new DEdge(2, 3, 5.0));
		primsGraph.insert(new DEdge(2, 4, 6.0));
		primsGraph.insert(new DEdge(2, 5, 4.0));
		// 3 - 5
		primsGraph.insert(new DEdge(3, 5,  2.0));
		// 4 - 5
		primsGraph.insert(new DEdge(4, 5,  5.0));
		
		primsGraph.primsAlgorithm(0);

	}
}
