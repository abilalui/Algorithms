import java.util.ArrayList;
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

        if (array.length > 1) {
            int temp = array[first];
            array[first] = array[second];
            array[second] = temp;
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

        // calculate right and left child of the node
        int rightChild = this.getRight( node );
        int leftChild = this.getLeft( node );
        int largest = node;

        // if node have left child and is greater than node
        if (( leftChild < array.length ) && ( array[leftChild] > array[node] )) {
                largest = leftChild;
        }

        // if node have the right child and its value is greater than largest
        if (( rightChild < array.length ) && array[rightChild] > array[largest] ) {
                //if (array[rightChild] > array[largest] ) {
                largest = rightChild;
        }
        // if no right and left child are found; don't swap anything and return
        // original array
        if ( largest == node ) {
            return array;
        }
        // swapping happens here
        this.swap( node, largest, array );

        return maxHeapify( array, largest );
    }


    /**
     * This method creates a maxHeap using the given array.
     * @param array - takes array as argument
     * @return an array representing a maxHeap
     */
    public int[] buildMaxHeap( int[] array ) {

        for ( int i = (array.length/2) - 1; i >= 0; i-- ) {
            this.maxHeapify( array, i );
            //System.out.println( array[i] );
        }
        return array;
    }

    /**
     * This method sort our given integer array in non-decreasing order, using heap.
     * @param array - takes array of integer as argument
     * @return a sorted list of integer in a non-decreasing order
     */
    public ArrayList<Integer> heapSort( int[] array ) {

        // create array list - orderedList - to add sorted values of our heap/array
        ArrayList<Integer> orderedList = new ArrayList<>();

        // build a max heap from given array
        this.buildMaxHeap( array );

        int length = array.length;
        int i = 0;

        while ( i < length ) {

            // add first element of array to ordered list
            orderedList.add( 0,array[0] );

            // swap last and first element of the array
            this.swap(0, array.length - 1, array);

            // remove the first element of array and resize the array
            array = Arrays.copyOfRange( array, 0, array.length - 1 );

            // heapify the array using first element of array which
            // is the root of current heap
            this.maxHeapify( array, 0 );

            i++;
        }
        return orderedList;
    }


    public static void main( String[] args ) {

        Scanner sc = new Scanner( System.in );
        System.out.println("Enter the size of the array to be sorted: ");
        int size = sc.nextInt();

        // Declare/initialize the array
        int[] array = new int[ size ];

        System.out.println( "Enter the elements of the array one at a time: " );

        int i = 0;
        while ( i < size ) {
            array[i] = sc.nextInt();
            i++;
        }
        HeapSort hs = new HeapSort();

        System.out.println("The sorted array is: ");
        System.out.println( hs.heapSort( array ));
    }
}
