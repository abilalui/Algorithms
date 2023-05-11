public class Node {

    private int data;
    private Node left;
    private Node right;

    private Node parent;

    /**
     * Constructor for Node Class: initialize the data for Node class.
     * @param data
     * @param left
     * @param right
     * @param parent
     */
    Node ( int data, Node left, Node right, Node parent )  {
        this.data = data;
        this.left = right;
        this.right = left;
        this.parent = parent;
    }

    /**
     * Constructor for Node Class with left and Right child initialized to null
     * @param data
     */
    Node ( int data, Node parent ) {
        this.data = data;
        this.parent = parent;
        left = null;
        right = null;
    }

    /**
     * getData - method to get the data of the node;
     * @return data
     */
    public int getData() {
        return data;
    }

    /**
     * setData - method to set data of the node;
     * @param data - data of the node.
     */
    public void setData( int data ) {
        this.data = data;
    }

    /**
     * setLeft - method that sets left child of the node
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * getLeft - method that gets left child of the node
     * @return leftChild of the node
     */
    public Node getLeft() {
        return left;
    }

    /**
     * setRight - method that sets right child of the node
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * getRight - method that gets right child of the node
     * @return rightChild of the node
     */
    public Node getRight() {
        return right;
    }

    /**
     * setParent - set parent of the Node
     * @param - parent
     */
    public void setParent( Node parent ) {
        this.parent = parent;
    }

    /**
     * getParent - get the parent node of current node
     * @return parent
     */
    public Node getParent() {
        return parent;
    }



    /**
     * toString: represent Node as a string
     * @return a string representation of the given node
     */
    public String toString() {
        return "Node data: " + data;
//                + "Left child: " + left.getData()
//                + "\n" + "Right child: " + right.getData() + "\n";
    }
}
