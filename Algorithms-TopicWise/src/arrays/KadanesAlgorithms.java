package arrays;

/**
 * Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
 */
public class KadanesAlgorithms {

    public static void main(String[] args) {
        int arr[] = new int[]{1, -2, -5, 6, -3};

        System.out.println("Maximum sum is:" + kadane(arr, arr.length));

        System.out.println("Maximum sum is:" + kadane_optimized(arr, arr.length));
    }


    /**
     * O(n^2) approach. It makes all the subsets of the array and determine the max subsum array
     * O(n^3) approach is i(0 to n) && j(i to n) && sum=0 then k(i to j)
     *
     * @param arr
     * @param n
     */
    private static int kadane(int[] arr, int n) {

        int max_sum = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    /**
     * O(N) -
     * Dynamic Programming approach based on splitting up the set of possible solutions into mutually exclusive (disjoint) sets.
     * We exploit the fact that any solution (i.e., any member of the set of solutions) will always have a last element
     * i").
     *
     * @param arr
     * @param n
     * @return
     */
    private static int kadane_optimized(int[] arr, int n) {

        int max = arr[0];
        int sum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(arr[i], arr[i] + sum);  //Max of individual element a[i] or from a[o] to a[i(i=1 to N)]
            max = Math.max(max, sum); //it tells max sum ending at position i
        }

        return max;
    }


}
