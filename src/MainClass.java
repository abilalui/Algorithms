import com.sun.tools.javac.Main;

import java.util.Arrays;

public class MainClass {

    /**
     * This method calculates a subArray that passes through the midpoint of the array and
     * has the largest sum. It takes a Tuple object, which contains an Array, low index of the array,
     * mid-point index of array, and high index of the array. It returns the subArray that crosses the
     * midpoint of the given array, so that for Array A[i,...,j], and sub array A[low,...,high]
     * low <= i <= mid < j <= high
     * @param tuple - takes a tuple object as input
     * @return return a tuple containing the subArray, with its lowest and highest indicies.
     */
    public Tuple maxCrossingArray( Tuple tuple ) {

        int low = 0;
        double leftSum = Double.NEGATIVE_INFINITY;
        int sum = 0;

        // Search in left half of the array
        for ( int i = tuple.getMid(); i >= tuple.getLow(); i-- ) {

            int elem = tuple.getArray()[i];
            sum = sum + elem;
            if ( sum > leftSum ) {
                leftSum = sum;
                low = i;
            }
        }


        int sum2 = 0;
        int high = 0;
        double rightSum = Double.NEGATIVE_INFINITY;

        // Search in right half of the array
        for ( int i = tuple.getMid() + 1; i <= tuple.getHigh(); i++ ) {
            int elem = tuple.getArray()[i];
            sum2 = sum2 + elem;
            if ( sum2 > rightSum ) {
                rightSum = sum2;
                high = i + 1;
            }
        }

        //int[] output = Arrays.copyOfRange( tuple.getArray(), low, high );
        int totalSum = (int)rightSum + (int)leftSum;
        int[] maxValueSubArray = Arrays.copyOfRange( tuple.getArray(), low, high );
        Tuple outputTuple = new Tuple( maxValueSubArray , low, tuple.getMid(), high, totalSum );

        return outputTuple;
    }

    /**
     * This method returns the largeSumSubArray of the given array it recursively searches
     * left, right and middle of array to find the largest sum array.
     * @param tuple a tuple that contains an input array with its low, mid and high indices
     * @return returns a tuple that contains a largeSumSubArray with its first and last indices.
     */
    public Tuple maxSumArray( Tuple tuple ) {


        //  search in left half of the array
        if ( tuple.getLow() == tuple.getHigh() ) {
            return new Tuple( tuple.getArray(), tuple.getLow(), tuple.getMid()
                              , tuple.getHigh(), tuple.getArray()[tuple.getLow()] );
        } else {
            int mid = ( tuple.getLow() + tuple.getHigh() ) / 2;
            int[] leftHalfArray = Arrays.copyOfRange( tuple.getArray(),
                                  tuple.getLow(), mid + 1);
            int[] rightHalfArray = Arrays.copyOfRange( tuple.getArray(),
                                  mid + 1, tuple.getHigh() + 1);

            // Save calculations from search in leftHalfArray, rightHalfArray, and crossArray
            // in a different tuple
            Tuple t1 = maxSumArray( new Tuple ( leftHalfArray , tuple.getLow(),
                                     tuple.getMid(), mid, tuple.getSum()));
            Tuple t2 = maxSumArray( new Tuple( rightHalfArray, mid + 1, tuple.getMid(),
                                     tuple.getHigh(), tuple.getSum()) );
            Tuple t3 = maxCrossingArray( new Tuple (tuple.getArray(), tuple.getLow()
                                        , mid, tuple.getHigh(), tuple.getSum() ) );

            if ( (t1.getSum() >= t2.getSum() ) && (t1.getSum() >= t3.getSum() ) ) {
                return t1;
            } else if ( ( t2.getSum() >= t1.getSum() ) && ( t2.getSum() >= t3.getSum() ) ) {
                return t2;
            } else {
                return t3;
            }
        }
    }


    public static void main( String[] args ) {

        MainClass m = new MainClass();

        int[] array1 = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
        int [] array2 = {3,-1};
        int low = 0;
        int high = array2.length - 1;
        int mid = (low + high) / 2;

        //Tuple t = m.maxCrossingArray( new Tuple( array2, low, mid, high, 0 ));
        Tuple t1 = m.maxSumArray( new Tuple( array2, low, mid, high, 0));

        //System.out.println( t.toString() );

        System.out.println( t1.toString() );

    }

}
