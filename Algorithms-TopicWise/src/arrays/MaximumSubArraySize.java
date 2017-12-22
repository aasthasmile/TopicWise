package arrays;

import java.util.*;

/**
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 */
public class MaximumSubArraySize {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        List<Integer> maxSub = maxSubArraySubList(arr, arr.length, k);
        maxSub.forEach(i -> System.out.print(i + " "));
    }

    //3 3 4 5 5 5 6
    /*
    *O(n^2) approach for performing max element in sub array of size k
     */
    private static List<Integer> maxSubArray(int[] arr, int n, int k) {

        List<Integer> maxSub = new ArrayList<>();

        if (arr.length == 1) {
            maxSub.add(arr[0]);
            return maxSub;
        }

        for (int i = 0; i + k - 1 < arr.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < i + k && j < arr.length; j++) {
                set.add(arr[j]);
            }
            maxSub.add(Collections.max(set));
        }
        return maxSub;
    }

    /**
     * O(n) approach for getting the max element from each subarray of size k
     *
     * @param arr
     * @param n
     * @param k
     * @return
     */
    private static List<Integer> maxSubArraySubList(int[] arr, int n, int k) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(arr).forEach(e -> list.add(e));
        List<Integer> maxSub = new ArrayList<>();
        if (arr.length == 1) {
            maxSub.add(arr[0]);
            return maxSub;
        }

        for (int i = 0; i + k - 1 < arr.length; i++) {
            maxSub.add(Collections.max(list.subList(i, i + k)));
        }
        return maxSub;
    }
}
