package arrays;

/**
 * Given an array, reverse every sub-array formed by consecutive k elements.
 */
public class ReverseArrayGroupK {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 3;

        reverseGroup(arr, k);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    private static void reverseGroup(int[] arr, int k) {

        for (int i = 0; i < arr.length; i = i + k) {
            swapElements(arr, i, Math.min(arr.length-1, i + k - 1));
        }
    }

    private static void swapElements(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            start++;
            end--;
        }
    }
}
