package testing;

import dSelfBalancingTrees.BinarySearchTree;

public class TreeTest {
	public TreeTest() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(9);
		bst.add(5);
		bst.add(7);
		bst.add(0);
		bst.add(2);
		bst.add(6);
		bst.add(4);
		bst.add(3);
		bst.add(1);
		bst.add(8);
		
		System.out.println(bst.contains(7));
		System.out.println(bst.contains(3));
		System.out.println(bst.contains(10));
		
		bst.delete(7);
		bst.delete(3);
		bst.delete(0);
		bst.delete(9);
		bst.delete(10);
	}
}
