
/**
 * CISC 380
 * Algorithms Assignment 3 EXTRA CREDIT
 * 
 * 
 * Implements an iterative dynamic programming solution to find the subarray of maximum sum, of a given array of numbers.
 *
 * @author Alex Palumbo and Emma Sinn
 * Due Date: 03/16/20
 * 
 */


public class MaxSum{

    /**
     * Returns the sum of the subarray with the maximum sum from the given array of integers.
     * 
     * 
     * @param a an array of integers
     * @return the sum of the subarray with the maximum sum.
     */
    public static int maxSumSubarray(int[] a){
		
        //YOUR CODE HERE
        int maxSum = a[0];
        int[] table = new int[a.length];
        table[0] = a[0];
        for(int i = 1; i<a.length; i++){
            table[i] = Math.max(a[i], a[i] + table[i-1]);
            maxSum = Math.max(maxSum, table[i]);
        }
        return maxSum;

    }//maxSubArray

}//class