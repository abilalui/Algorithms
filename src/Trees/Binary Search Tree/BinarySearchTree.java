import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import javax.xml.crypto.Data;
import java.util.Objects;

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
     * preOrderTraverse - method that traverse the tree in preOrder
     */
    public void preOrderTraverse( Node root ) {

        if ( root != null ) {
            System.out.println( root.getData() );
            preOrderTraverse( root.getLeft() );
            preOrderTraverse( root.getRight() );
        }
    }

    /**
     * postOrderTraverse - method that traverse the tree in postOrder
     */
    public void postOrderTraverse( Node root ) {

        if ( root != null ) {
            postOrderTraverse( root.getLeft() );
            postOrderTraverse( root.getRight() );
            System.out.println( root.getData() );
        }
    }


    /**
     * insert - insert a new data inside the given tree
     * @param data - new data to be inserted
     */
    public void insert( int data ) {

        Node newNode = null;
        Node childNode = root;

        while ( childNode != null ) {

            newNode = childNode;

            if ( data < newNode.getData() ) {
                childNode = childNode.getLeft();
            } else {
                childNode = childNode.getRight();
            }
        }

        if ( root != null ) {
            if (data < newNode.getData()) {
                newNode.setLeft(new Node(data));
            } else {
                newNode.setRight(new Node(data));
            }
        } else {
            root = new Node( data );
        }

    }




    public static void main( String[] args ) {

        //Node node = new Node(1);

        BinarySearchTree BSTree = new BinarySearchTree( null );
        BSTree.root = new Node(1);
        BSTree.root.setLeft( new Node(2) );
        BSTree.root.setRight( new Node(3));
        BSTree.root.getLeft().setLeft( new Node(4) );
        BSTree.root.getLeft().setRight( new Node ( 5));

        BSTree.inOrderTraverse( BSTree.root );
        System.out.println("================================================");

        BSTree.preOrderTraverse( BSTree.root );
        System.out.println("================================================");

        BSTree.postOrderTraverse( BSTree.root );
        System.out.println("================================================");

    }
}
