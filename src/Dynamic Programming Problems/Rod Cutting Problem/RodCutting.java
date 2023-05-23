import java.util.Scanner;

public class RodCutting {


    public static int maxRodCuttingRevenueHelper( int price[], int revenues[], int size ) {

        int revenue = 0;

        if ( revenues[size] > 0 ) {
            return revenues[size];
        }

        if ( size == 0 ) {
            revenue = 0;
        } else {
            revenue = Integer.MIN_VALUE;

            for ( int i = 0; i < size; i++ ) {
                revenue = Math.max( revenue,
                                    maxRodCuttingRevenueHelper( price, revenues, size - 1));
            }
        }
        price[size] = revenue;

        return revenue;

    }


    public static int maxRodCuttingRevenue ( int price[], int size ) {

        int[] revenues = new int[ size ];

        // initialize array values to Integer.MIN_VALUE
        for ( int i = 0; i < size; i++ ) {
            revenues[i] = Integer.MIN_VALUE;
        }

        return maxRodCuttingRevenueHelper( price, revenues, size );
    }




    public static void main( String args[] ) {

        System.out.println( "Give an array of prices with a given size of rode to " +
                "the maxRodCuttingRevenue method to calculate max revenue." );

    }

}
