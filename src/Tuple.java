import java.lang.reflect.Array;
import java.util.Arrays;

public class Tuple {

    private int[] array;
    private int sum;
    private int low;
    private int mid;
    private int high;

    // public constructor for Tuple
    /**public Tuple( int[] array, int low, int mid, int high ) {
        this.array = array;
        this.low = low;
        this.mid = mid;
        this.high = high;
    }
**/
    // tuple constructor without setting value of mid
    public Tuple( int[] array, int low, int mid, int high, int sum ) {
        this.array = array;
        this.mid = mid;
        this.low = low;
        this.high = high;
        this.sum = sum;

    }

    // Constructor to have the sum option
    public Tuple( int sum, int low, int high ) {
        this.sum = sum;
        this.low = low;
        this.high = high;
    }

    public void setArray( int[] arr ) {
        array = arr;
    }

    public int[] getArray () {
        return array;
    }

    public void setSum ( int sum ) {
        this.sum = sum;
    }

    public void setSum () {
        this.calculateSum( array );
    }

    public int getSum() {
        return sum;
    }


    public void setLow( int low ) {
        this.low = low;
    }

    public int getLow() {
        return low;
    }

    public void setMid( int mid ) {
        this.mid = mid;
    }

    public void setMid() {
        this.calculateMid( low, high );
    }

    public int getMid() {
        return mid;
    }

    public void setHigh( int high ) {
        this.high = high;
    }

    public int getHigh( ) {
        return high;
    }

    public int calculateMid ( int lowIndex, int highIndex ) {
        int midSize = 0;
        midSize = ( lowIndex + highIndex ) / 2;
        return midSize;
    }
    public int calculateSum ( int[] anArray ) {
        int sum = 0;
        for ( int i = 0; i < anArray.length; i++ ) {
            sum += anArray[i];
        }
        return sum;
    }

    public String toString() {

        return  "The output Array is: " + Arrays.toString( array )
                + "\n The low index is: " + low
                //+ "\n The mid index is: " + mid
                + "\n The high index is: " + high
                + "\n The sum is: " + sum;
    }
}
