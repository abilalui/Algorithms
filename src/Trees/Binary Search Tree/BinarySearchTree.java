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
     * findMinimum - method to find minimum value node
     * @param node - take node as root of the tree and find minimum value of the tree.
     * @return minimum value of the tree
     */
    public Node findMinimum( Node node ) {
        if ( node == null || node.getLeft() == null ) {
            return node;
        }
        return findMinimum( node.getLeft() );
    }

    /**
     * findMaximum - method to find the maximum value of node
     * @param node - take node as root of the tree
     * @return minimum value of the tree
     */
    public Node findMaximum( Node node ) {
        if ( node == null || node.getRight() == null ) {
            return node;
        }
        return findMaximum( node.getRight() );
    }

    /**
     * findSuccessor - method for finding successor of the tree
     */
    public Node findSuccessor( Node node ) {

        if ( node.getRight() != null ) {
            return findMinimum( node.getRight() );
        }
        Node parentNode = node.getParent();

        while ( parentNode != null && node == parentNode.getRight() ) { // check eqality
            node = parentNode;
            parentNode = parentNode.getParent();
        }
        return parentNode;
    }

    /**
     * findPredecessor - method that find the predecessor of given node in the tree
     * @param node
     * @return predecessor of node in the tree
     */
    public Node findPredecessor( Node node ) {

        if ( node.getLeft() != null ) {
            return findMaximum( node.getLeft() );
        }
        Node parentNode = node.getParent();

        while( parentNode != null && node == parentNode.getLeft() ) {
            node = parentNode;
            parentNode = parentNode.getParent();
        }
        return parentNode;
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
                newNode.setLeft(new Node(data, newNode));
            } else {
                newNode.setRight(new Node(data, newNode));
            }
        } else {
            root = new Node( data, null );
        }

    }


    /**
     * This method is a helper for delete node. It replaces one subtree as
     * a child of its parent with another subtree.
     * @param n - node n to be replaced by node m
     * @param m - node m to be replaced by node n
     */
    public void transplant( Node n, Node m ) {

        if ( n.getParent() == null ) {
            setRoot( m );
        } else if ( n.getParent().getLeft() == n ) {
            n.getParent().setLeft( m );
        } else {
            n.getParent().setRight( m );
        }

        if ( m != null ) {
            m.setParent( n.getParent() );
        }
    }

    /**
     * delete - this method deletes a given node from the tree
     * @param node - node to be deleted from the tree
     */
    public void delete( Node node ) {

        if ( node.getLeft() == null ) {
            this.transplant( node, node.getRight() );
        } else if ( node.getRight() == null ) {
            this.transplant( node, node.getLeft() );
        } else {
            Node nodeSuccessor = findSuccessor( node );

            if ( nodeSuccessor.getParent() != node ) {

                this.transplant( nodeSuccessor, nodeSuccessor.getRight());
                nodeSuccessor.setRight( node.getRight() );
                nodeSuccessor.getRight().setParent( nodeSuccessor );

            }

            this.transplant( node, nodeSuccessor );
            nodeSuccessor.setLeft( node.getLeft() );
            nodeSuccessor.getLeft().setParent( nodeSuccessor );
        }
    }


    public static void main( String[] args ) {

        //Node node = new Node(1);

        BinarySearchTree BSTree = new BinarySearchTree( null );
        BSTree.root = new Node(5, null);
        BSTree.root.setLeft( new Node(3, BSTree.root ) );
        BSTree.root.setRight( new Node(10, BSTree.root ));
        BSTree.root.getLeft().setLeft( new Node(2, BSTree.root.getLeft() ) );
        BSTree.root.getLeft().setRight( new Node ( 4, BSTree.root.getLeft()));

        //BSTree.insert( 8 );

        System.out.println( "The predecessor of 5 is : "
                            + BSTree.findPredecessor( BSTree.root ).getData() );

        BSTree.inOrderTraverse( BSTree.root );
        System.out.println("================================================");


    }
}
