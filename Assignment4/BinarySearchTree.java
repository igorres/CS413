package Assignment4;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryNode<T> {

	public BinarySearchTree() {
		super();
	} 

	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<T>(rootEntry));
	} 

	public T getEntry(T newEntry) {
		return findEntry(getRootNode(), newEntry);
	}

	private T findEntry(BinaryNode<T> rootNode, T newEntry) {
		T result = null;

		if (rootNode != null) {
			T rootEntry = rootNode.getData();

			if (newEntry.equals(rootEntry))
				result = rootEntry;
			else if (newEntry.compareTo(rootEntry) < 0)
				result = findEntry(rootNode.getLeftChild(), newEntry);
			else
				result = findEntry(rootNode.getRightChild(), newEntry);
		}
		return result;
	} 

	public T add(T newEntry) {
		T result = null;

		if (isEmpty()){
			setRootNode(new BinaryNode<>(newEntry));
		}
		else{
			result = addEntry(getRootNode(), newEntry);
		}
		return result;
	} 

	private T addEntry(BinaryNode<T> rootNode, T newEntry) {
		T result = null;
		int comparison = newEntry.compareTo(rootNode.getData());

		if (comparison == 0) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		} else if (comparison < 0) {
			if (rootNode.hasLeftChild())
				result = addEntry(rootNode.getLeftChild(), newEntry);
			else
				rootNode.setLeftChild(new BinaryNode<>(newEntry));
		} else {
			if (rootNode.hasRightChild())
				result = addEntry(rootNode.getRightChild(), newEntry);
			else
				rootNode.setRightChild(new BinaryNode<>(newEntry));
		} 
		return result;
	} 

	public boolean remove(T newEntry) {
		BinaryNode<T> newRoot = removeEntry(getRootNode(), newEntry);
		setRootNode(newRoot);

		return newRoot != null;
	} 

	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T newEntry) {
		if (rootNode != null) {
			T rootData = rootNode.getData();
			int comparison = newEntry.compareTo(rootData);

			if (comparison == 0) {
				rootNode = removeFromRoot(rootNode);
			} else if (comparison < 0) {
				BinaryNode<T> leftChild = rootNode.getLeftChild();
				BinaryNode<T> subtreeRoot = removeEntry(leftChild, newEntry);
				rootNode.setLeftChild(subtreeRoot);
			} else {
				BinaryNode<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild, newEntry));
			}
		}
		return rootNode;
	} 

	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
		if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
			BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
			BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);

			rootNode.setData(largestNode.getData());
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		}
		else if (rootNode.hasRightChild()){
			rootNode = rootNode.getRightChild();
		}
		else{
			rootNode = rootNode.getLeftChild();
		}
		return rootNode;
	} 

	private BinaryNode<T> findLargest(BinaryNode<T> rootNode) {
		if (rootNode.hasRightChild()){
			rootNode = findLargest(rootNode.getRightChild());
		}
		return rootNode;
	} 

	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
		if (rootNode.hasRightChild()) {
			BinaryNode<T> rightChild = rootNode.getRightChild();
			rightChild = removeLargest(rightChild);
			rootNode.setRightChild(rightChild);
		} else
			rootNode = rootNode.getLeftChild();

		return rootNode;
	} 

	public void inorderTraverse() {
		recursiveInorderTraverse(getRootNode());
		System.out.println();
	} 

	private void recursiveInorderTraverse(BinaryNode<T> node) {
		if (node != null) {
			recursiveInorderTraverse(node.getLeftChild());
			System.out.print(node.getData() + " ");
			recursiveInorderTraverse(node.getRightChild());
		}
	}

	public void postorderTraverse() {
		recursivePostorderTraverse(getRootNode());
		System.out.println();
	} 

	private void recursivePostorderTraverse(BinaryNode<T> node) {
		if (node != null) {
			recursivePostorderTraverse(node.getLeftChild());
			recursivePostorderTraverse(node.getRightChild());
			System.out.print(node.getData() + " ");
		} 
	}

	public void preorderTraverse() {
		recursivePreorderTraverse(getRootNode());
		System.out.println();
	} 

	private void recursivePreorderTraverse(BinaryNode<T> node) {
		if (node != null) {
			System.out.print(node.getData()+ " ");
			recursivePreorderTraverse(node.getLeftChild());
			recursivePreorderTraverse(node.getRightChild());
		} 
	} 
} 
