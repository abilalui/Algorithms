import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {

    /**
     * This method returns the index of the right child of a given node
     * @param node - indicating the node which we need to find its right child index.
     * @return returns the index of the right child of the node.
     */
    public int getRight( int node ) {
        return (2 * node) + 2;
    }

    /**
     * This method returns the index of the left child of the node.
     * @param node - indicating the node which we need to find its right child index.
     * @return returns the index of the left child of the node.
     */
    public int getLeft( int node ) {
        return (2 * node) + 1;
    }

    /**
     * This method swaps two values of a given array;
     * @param first - index of first value
     * @param second - index of second value
     * @param array - array where our values are located
     * @return an array that contains swapped positions of the two values.
     */
    public int[] swap( int first, int second, int[] array ) {

        if (array.length > 2) {
            int temp = 0;
            temp = array[first];
            array[first] = array[second];
            array[second] = temp;
            return array;
        }
        return array;
    }

    /**
     * This method takes a tree and sort the indicated node such that
     * to obey the max-heap order (max-heap: when parent node has a value larger or equal to
     * its child nodes). It assumes that child nodes are already in max-heap order. The method
     * takes the parent value down the tree, and keep swaping with its child node until
     * it satisfies the max-heap order.
     * @param array takes an unsorted array of numbers.
     * @param node takes an index of the node where to apply maxHeapify
     * @return int[]
     */
    public int[] maxHeapify( int[] array, int node ) {

        int rightChild = this.getRight( node );
        int leftChild = this.getLeft( node );

        int largest = -1;

        if ( leftChild <= array.length && rightChild <= array.length ) {
            if ( array[leftChild] > array[node] ) {
                largest = leftChild;
            } else {
                largest = node;
            }
            // if rightChild is greater than node.
            if (array[rightChild] > array[largest] ) {
                largest = rightChild;
            }
        }

        if ( largest == -1 ) {
            return array;
        }
        this.swap( node, largest, array );

        return maxHeapify( array, largest );
    }


    public static void main( String[] args ) {

        Scanner sc = new Scanner( System.in );
        System.out.println("Enter the size of the array to be sorted: ");
        int size = sc.nextInt();

        // Declare/initialize the array
        int[] array = new int[ size ];

        System.out.println( "Enter the elements of array once at a time: " );

        int i = 0;
        while ( i < size ) {
            array[i] = sc.nextInt();
            i++;
        }
        HeapSort hs = new HeapSort();

        System.out.print( "The output array is: " );
        System.out.println( Arrays.toString( hs.maxHeapify( array, 0)));
    }
}
