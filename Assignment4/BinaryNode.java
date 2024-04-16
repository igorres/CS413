package Assignment4;

public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> leftChild; 
    private BinaryNode<T> rightChild; 
    private BinaryNode<T> root;

    public BinaryNode() {
        this(null); 
    } 

    public BinaryNode(T dataPortion) {
        this(dataPortion, null, null);
    } 

    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild) {
        data = dataPortion;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    } 

    public void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	} 

	public BinaryNode<T> getRootNode() {
		return root;
	} 
    
    public T getData() {
        return data;
    } 

    public void setData(T newData) {
        data = newData;
    }

    public BinaryNode<T> getLeftChild() {
        return leftChild;
    } 

    public void setLeftChild(BinaryNode<T> newLeftChild) {
        leftChild = newLeftChild;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public BinaryNode<T> getRightChild() {
        return rightChild;
    } 

    public void setRightChild(BinaryNode<T> newRightChild) {
        rightChild = newRightChild;
    } 

    public boolean hasRightChild() {
        return rightChild != null;
    } 

    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    } 

    public boolean isEmpty() {
		return root == null;
	} 

    public int getNumberOfNodes() {
        int leftNumber = 0;
        int rightNumber = 0;
        if (leftChild != null)
            leftNumber = leftChild.getNumberOfNodes();
        if (rightChild != null)
            rightNumber = rightChild.getNumberOfNodes();
        return 1 + leftNumber + rightNumber;
    }

    /* 
    public int getHeight() {
        return getHeight(this);
    } 
    */
    public BinaryNode<T> copy() {
        BinaryNode<T> newRoot = new BinaryNode<>(data);
        if (leftChild != null)
            newRoot.setLeftChild(leftChild.copy());

        if (rightChild != null)
            newRoot.setRightChild(rightChild.copy());

        return newRoot;
    }
    /*
    private int getHeight(BinaryNode<T> node) {
        int height = 0;
        if (node != null)
            height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
        return height;
    } 
    */
} 
