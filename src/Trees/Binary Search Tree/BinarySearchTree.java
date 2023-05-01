public class BinarySearchTree {

    private Node root;

    /**
     * Constructor for binary search tree
     */
    BinarySearchTree( Node root ) {
        this.root = root;
    }

    /**
     * setRoot - set root of the tree
     * @param root root of tree
     */
    public void setRoot( Node root ) {
        this.root = root;
    }

    /**
     * getRoot ; get root of the tree
     * @return root of the tree
     */
    public Node getRoot() {
        return root;
    }


    public static void main( String[] args ) {

        Node node = new Node(0);
        System.out.println( node );
    }


}
