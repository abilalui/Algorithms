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

    /**
     * inOrderTraverse - Traverse tree in inOrder
     */
    public void inOrderTraverse( Node root ) {
        if ( root != null ) {
            inOrderTraverse( root.getLeft() );
            System.out.println( root );
            inOrderTraverse( root.getRight() );
        }
    }


    /**
     * insert - insert a new data inside the given tree
     * @param data - new data to be inserted
     * @param root - root of the tree in which the data will be inserted
     */
    public void insert( int data, Node root ) {
        Node newNode = root;
        Node childNode = null;

        if ( newNode == null ) {
            root.setData( data );
        }

        while ( childNode != null ) {

            newNode = childNode;

            if ( data < newNode.getLeft().getData() ) {
                childNode = childNode.getLeft();
            } else {
                childNode = childNode.getRight();
            }
        }

        if ( newNode.getLeft().getData() < data ) {
            newNode.setLeft( new Node( data) );
        } else {
            newNode.setRight( new Node(data) );
        }

    }


    public static void main( String[] args ) {

        Node node = new Node(0, new Node(1), new Node(2));
        BinarySearchTree BSTree = new BinarySearchTree( node );
        //BSTree.insert( 1, node );


        BSTree.inOrderTraverse( node );

    }
}
