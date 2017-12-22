package arrays;

/**
 * Given an array of n positive integers.
 * Write a program to find the sum of maximum sum subsequence of the given array such that the integers
 * in the subsequence are sorted in increasing order.
 */
public class MaximumSumIncreasingSequence {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};

        System.out.println("The max sum is:" + findmaxSum(arr, arr.length));
    }

    /**
     * Very similar to longest increasing subsequence problem.
     * with O(n^2) approach for finding largest sum.
     *
     * @param arr
     * @param n
     * @return
     */
    private static int findmaxSum(int[] arr, int n) {

        int sum=Integer.MIN_VALUE;
        int max_sum[] = new int[n];
        int k=0;
        for (int i:arr) {
            max_sum[k++]=i;
        }
        max_sum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                  if(arr[i]>arr[j] && arr[i]+max_sum[j]>max_sum[i])
                      max_sum[i]=max_sum[j]+arr[i];
            }
            sum=Math.max(sum,max_sum[i]);
        }

        return sum;

    }
}
