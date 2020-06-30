package dSelfBalancingTrees;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E> {

	protected boolean addReturn;
	protected E deleteReturn;

	@Override
	public boolean add(E item) {
		root = add(root, item);
		return addReturn;
	}

	private BinaryTree<E>.Node<E> add(Node<E> localRoot, E item) {
		// base case
		if (localRoot == null) {
			addReturn = true;
			return new Node<>(item);
		}
		// make comparison
		int compResult = item.compareTo(localRoot.data);
		if (compResult == 0) {
			addReturn = false;
			return localRoot;
		} else if (compResult < 0) {
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		} else {
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
	}

	@Override
	public boolean contains(E target) {
		return contains(root, target);
	}

	private boolean contains(Node<E> localRoot, E target) {
		// localRoot is null, return false
		if (localRoot == null) {
			return false;
		}
		// compare the target with the data field at the root
		int compResult = target.compareTo(localRoot.data);
		if (compResult == 0) {
			return true;
		} else if (compResult < 0) {
			return contains(localRoot.left, target);
		} else {
			return contains(localRoot.right, target);
		}
	}

	@Override
	public E find(E target) {
		return find(root, target);
	}

	private E find(BinaryTree<E>.Node<E> localRoot, E target) {
		// localRoot is null, return null
		if (localRoot == null) {
			return null;
		}
		// compare the target with the data field at the root
		int compResult = target.compareTo(localRoot.data);
		if (compResult == 0) {
			return localRoot.data;
		} else if (compResult < 0) {
			return find(localRoot.left, target);
		} else {
			return find(localRoot.right, target);
		}
	}

	@Override
	public E delete(E target) {
		root = delete(root, target);
		return deleteReturn;
	}

	private Node<E> delete(Node<E> localRoot, E target) {
		// localRoot is null, return null
		if (localRoot == null) {
			deleteReturn = null;
			return localRoot;
		}
		// compare the target with the data field at the root
		int compResult = target.compareTo(localRoot.data);
		if (compResult < 0) {
			localRoot.left = delete(localRoot.left, target);
			return localRoot;
		} else if (compResult > 0) {
			localRoot.right = delete(localRoot.right, target);
			return localRoot;
		} else {
			deleteReturn = localRoot.data;
			if (localRoot.left == null) {
				// return right child
				return localRoot.right;
			} else if (localRoot.right == null) {
				// return left child
				return localRoot.left;
			} else {
				// node being deleted has 2 children, find the inOrder predecessor
				if (localRoot.left.right == null) {
					// The left child has no right child
					// replace data in left child with data in right child
					localRoot.data = localRoot.left.data;
					// replace the left child with its left child
					localRoot.left = localRoot.left.left;
					return localRoot;
				} else {
					// search for the inorderPredecessor and replace deleted node's data with it
					localRoot.data = findLargestChild(localRoot.left);
					return localRoot;
				}
			}
		}
	}

	private E findLargestChild(Node<E> parent) {
		if (parent.right.right == null) {
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		} else {
			return findLargestChild(parent.right);
		}
	}

	@Override
	public boolean remove(E target) {
		// TODO Auto-generated method stub
		return false;
	}

}
