package arrays;

import java.util.stream.IntStream;

/**
 *
 */
public class TwiceOfOthers {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Twice of others:" + largest(arr, arr.length));
    }

    private static int largest(int[] arr, int length) {

        int twiceOrNot = -1, max_index = -1;
        int max = IntStream.of(arr).max().getAsInt();

        for (int i = 0; i < length; i++) {
            if (2 * arr[i] > max && arr[i] != max)
                break;
            if (arr[i] == max)
                max_index = i;
        }

        return twiceOrNot == -1 ? -1 : max_index;
    }
}
