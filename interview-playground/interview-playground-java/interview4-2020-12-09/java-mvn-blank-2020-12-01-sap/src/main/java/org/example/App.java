package org.example;

/**
 * ordered int[] collection
 * sum all even numbers
 * recursive
 *
 * int[] = new int[]{1, -1, 3, 2, 10, 7, 3, 4};
 */
public class App {
    public static void main(String[] args) {
        int[] input1 = new int[]{1, -1, 3, 2, 10, 7, 3, 4};

        System.out.println(sumEvenNums(input1, 0, 0));
    }


    public static int sumEvenNums(final int[] arr, int ptr, int totSum) {
        int totalEvenSum = totSum;

        if(ptr == arr.length) { // I had an extra -1, and the program is working correctly now in a tail recursive manner: if(ptr == arr.length-1) {
            return totalEvenSum;
        }

        int pointer = ptr;


        if(arr[pointer] % 2 == 0) {
            totalEvenSum += arr[pointer];
        }

        pointer++;

        return sumEvenNums(arr, pointer, totalEvenSum);
    }
}
