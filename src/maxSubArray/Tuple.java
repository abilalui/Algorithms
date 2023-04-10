
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;

public class Tuple {
    private int[] array;
    private int sum;
    private int low;
    private int mid;
    private int high;

    public Tuple(int[] array, int low, int mid, int high, int sum) {
        this.array = array;
        this.mid = mid;
        this.low = low;
        this.high = high;
        this.sum = sum;
    }

    public Tuple(int sum, int low, int high) {
        this.sum = sum;
        this.low = low;
        this.high = high;
    }

    public void setArray(int[] arr) {
        this.array = arr;
    }

    public int[] getArray() {
        return this.array;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setSum() {
        this.calculateSum(this.array);
    }

    public int getSum() {
        return this.sum;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getLow() {
        return this.low;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setMid() {
        this.calculateMid(this.low, this.high);
    }

    public int getMid() {
        return this.mid;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getHigh() {
        return this.high;
    }

    public int calculateMid(int lowIndex, int highIndex) {
        int midSize = 0;
        midSize = (lowIndex + highIndex) / 2;
        return midSize;
    }

    public int calculateSum(int[] anArray) {
        int sum = 0;

        for(int i = 0; i < anArray.length; ++i) {
            sum += anArray[i];
        }

        return sum;
    }

    public String toString() {
        String var10000 = Arrays.toString(this.array);
        return "The output Array is: " + var10000 + "\n The low index is: " + this.low + "\n The high index is: " + this.high + "\n The sum is: " + this.sum;
    }
}
