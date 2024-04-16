package Assignment4;

public class Driver {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree<>(10);

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(9);
        tree.add(15);
        tree.add(20);
        tree.add(11);

        tree.preorderTraverse();
        tree.postorderTraverse();
        tree.inorderTraverse();

        tree.remove(10);

        tree.preorderTraverse();

        System.out.println(tree.getEntry(20));

        tree.remove(9);

        tree.preorderTraverse();

        System.out.println(tree.getRootNode().getData());

    }
}
