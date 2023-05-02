import javax.imageio.plugins.tiff.BaselineTIFFTagSet;

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
            System.out.println( root.getData() );
            inOrderTraverse( root.getRight() );
        }
    }


    /**
     * insert - insert a new data inside the given tree
     * @param data - new data to be inserted
     */
    public void insert( int data) {
        Node newNode = null;
        Node childNode = root;

        if ( childNode == null ) {
            root.setData( data );
        }

        while ( childNode != null ) {

            newNode = childNode;

            if ( data < newNode.getData() ) {
                childNode = childNode.getLeft();
            } else {
                childNode = childNode.getRight();
            }
        }

        if ( data < newNode.getData() ) {
            newNode.setLeft( new Node(data) );
        } else {
            newNode.setRight( new Node(data) );
        }

    }


    public static void main( String[] args ) {

        Node node = new Node(0, new Node(1), new Node(2));
        BinarySearchTree BSTree = new BinarySearchTree( node );
        BSTree.insert(3);
        BSTree.insert(4);
        //System.out.println( node );
        BSTree.inOrderTraverse( node );

    }
}
