package arrays;

/**
 * Given an unsorted array of non-negative integers, find a continuous sub-array
 * which adds to a given number.
 *
 * @author aastha.b.jain
 */
public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int target = 15;
        int[] position = new int[2];
        position = findposition(arr, target);
    }

    private static int[] findposition(int[] arr, int target) {

        int sum = 0;
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            end=i;
            if (sum > target) {
                sum = sum - arr[start];
                start++;
            } else if (sum == target) {
                break;
            }
        }

        return new int[]{start + 1, end + 1};
    }

}
