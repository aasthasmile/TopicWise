package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to print all the LEADERS in the array.
 * An element is leader if it is greater than all the elements to its right side. The rightmost element is always a leader.
 */
public class Leaders {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};

        System.out.println("The max sum is:" + leader(arr, arr.length));
        System.out.println("The max sum is:" + leader_optimal(arr, arr.length));
    }

    /**
     * o(n^2) approach using two loops. Checks whether there is any element to the right that is greater than
     * current element ,then break the loop .Otherwise,add the element to the final list.
     *
     * @param arr
     * @param n
     * @return
     */
    private static List<Integer> leader(int[] arr, int n) {
        if (arr.length == 1)
            return new ArrayList<>(arr[0]);

        List<Integer> leaders = new ArrayList<>();
        leaders.add(arr[n - 1]);
        for (int i = n - 2; i > 0; i--) {
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j])
                    flag = true;
            }
            if (!flag) leaders.add(arr[i]);
        }

        leaders.forEach(i -> System.out.println(i));

        return leaders;
    }

    /**
     * O(n)
     * Traversing from right to left ,whenever we find a next maximum element in each subsequent step it becomes
     * the next greater element.
     */
    private static List<Integer> leader_optimal(int[] arr, int n) {  //16 17 4 3 5 2
        if (arr.length == 1)
            return new ArrayList<>(arr[0]);

        int max = arr[n - 1];
        List<Integer> leaders = new ArrayList<>();
        leaders.add(arr[n - 1]);
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] > max) {
                max = Math.max(max, arr[i]);
                leaders.add(max);
            }
        }
        leaders.forEach(i -> System.out.println(i));
        return leaders;
    }


}
