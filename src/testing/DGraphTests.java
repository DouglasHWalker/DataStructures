package testing;

import java.util.LinkedList;

import dGraphs.DEdge;
import dGraphs.DListGraph;

public class DGraphTests {

	public DGraphTests() {
		DListGraph graph = new DListGraph(10, true);

		// 0 - 3 1
		graph.insert(new DEdge(0, 1, Double.POSITIVE_INFINITY));
		graph.insert(new DEdge(0, 3, Double.POSITIVE_INFINITY));
		// 1 - 2 4 7
		graph.insert(new DEdge(1, 2, Double.POSITIVE_INFINITY));
		graph.insert(new DEdge(1, 4, Double.POSITIVE_INFINITY));
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
		int[] searchResult = graph.breadthFirstSearch(0);

		Tree tree = new Tree();
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(new Node(0));
		list.add(new Node(1));
		list.add(new Node(2));
		list.add(new Node(3));
		list.add(new Node(4));
		list.add(new Node(5));
		list.add(new Node(6));
		list.add(new Node(7));
		list.add(new Node(8));
		list.add(new Node(9));

		for (Node node : list) {
			if (searchResult[node.data] != -1) {
				node.parent = list.get(searchResult[node.data]);
			}
		}
		tree.root = list.getLast();

		// Depth first search

		// Dijkstra's Algorithm

		// Prim's Algorithm

	}

	public class Tree {
		public Node root;

		public Tree() {
		}

	}

	public class Node<Integer> {

		public Node right;
		public Node left;
		public Node parent;
		public int data;

		public Node(int data) {
			this.data = data;
		}

	}

}
