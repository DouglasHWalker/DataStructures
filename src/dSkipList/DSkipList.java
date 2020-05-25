package dSkipList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DSkipList<E extends Comparable<E>> {

	
	private int maxLevel = 2;
	private int maxCap = computeMaxCap(maxLevel);
	private Random rand = new Random();
	private int size = 0;
	private DSkipNode<E> head = new DSkipNode<E>(maxLevel, null);
	private static final double LOG2 = Math.log(2.0);

	private DSkipNode<E>[] search(E target) {
		DSkipNode<E>[] pred = (DSkipNode<E>[]) new DSkipNode[maxLevel];
		DSkipNode<E> current = head;
		for (int i = current.links.length - 1; i >= 0; i--) {
			while (current.links[i] != null && current.links[i].data.compareTo(target) < 0) {
				current = current.links[i];
			}
			pred[i] = current;
		}
		return pred;
	}

	public E find(E target) {
		DSkipNode<E>[] targetPred = search(target);
		if (targetPred[0].links[0] != null && targetPred[0].links[0].data.compareTo(target) == 0) {
			return targetPred[0].links[0].data;
		} else {
			return null;
		}
	}

	public boolean insert(E value) {
		DSkipNode<E> node = new DSkipNode<E>(logRandom(), value);
		DSkipNode<E>[] pred = this.search(value);
		for (int i = 0; i < node.links.length; i++) {
			node.links[i] = pred[i].links[i];
			pred[i].links[i] = node;
		}
		size++;
		
		if(size > maxCap) {
			maxLevel++;
			maxCap = computeMaxCap(maxLevel);
			head.links = Arrays.copyOf(head.links, maxLevel);
			pred = Arrays.copyOf(pred, maxLevel);
		}
		return true;
	}

	public boolean contains(E target) {
		return find(target) != null;
	}

	public void clear() {
		for (int i = 0; i < maxLevel; i++) {
			head.links[i] = null;
		}
		size = 0;
	}

	public List<E> toList() {
		List<E> list = new ArrayList<>();
		DSkipNode<E> current = head.links[0];
		while (current != null) {
			list.add(current.data);
			current = current.links[0];
		}
		return list;
	}

	// Helper methods
	private static int computeMaxCap(int maxLevel) {
		return (int) Math.pow(2, maxLevel + 1) - 1;
	}

	private int logRandom() {
		int r = rand.nextInt(maxCap);
		int k = (int) (Math.log(r + 1) / LOG2);
		if (k > maxLevel - 1) {
			k = maxLevel - 1;
		}
		return maxLevel - k;
	}

	// Search
	// let me be the highest level node
	// while m > 0
	// following the level m links find the node with the largest value that is less
	// than or equal to the target
	// if it is equal to the target the target has been found exit loop
	// set m to m -1
	// if m = , the target is not in the list

}
