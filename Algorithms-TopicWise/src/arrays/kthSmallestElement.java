package arrays;

import java.util.*;

/**
 * Given an array and a number k where k is smaller than size of array, the task is to
 * find the k’th smallest element in the given array. It is given that all array elements are distinct.
 */
public class kthSmallestElement {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 4;
        System.out.println("The Kth smallest element is:" + kthSmallest(arr, k));
    }

    private static int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        Set<Integer> set=new HashSet<>();
        Arrays.stream(arr).forEach(i->set.add(i));
        for (int i :
                set) {
            heap.add(i);
        }

        int min = Integer.MIN_VALUE;
        while (k >0) {
            min = heap.poll();
            k--;
        }

        return min != Integer.MIN_VALUE ? min : -1;
    }
}

