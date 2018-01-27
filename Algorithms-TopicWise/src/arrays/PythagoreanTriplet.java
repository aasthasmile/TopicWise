package arrays;

import java.util.Arrays;

/**
 *
 */
public class PythagoreanTriplet {

    public static void main(String[] args) {
        int arr[] = new int[]{3, 4, 5, 8, 6, 10};

        System.out.println("Array is Pythogorean Triplet:" + triplet(arr, arr.length));
    }

    /**
     * if a*a +b*b =c*c -> return "YES" either-wise return "No"
     *
     * @param arr
     * @param n
     * @return
     */
    private static String triplet(int[] arr, int n) {

        boolean var = false;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int k = i+1;
            int j=n-1;
            while (k < j) {
                if (arr[i] * arr[i] + arr[k] * arr[k] - arr[j] * arr[j] == 0) {
                    System.out.println("i=" + arr[i] + "\t j=" + arr[j] + "\t k=" + arr[k]);
                    var = true;
                    break;
                } else if (arr[i] * arr[i] + arr[k] * arr[k] < arr[j] * arr[j]) {
                    j--;
                } else {
                    k++;
                }
            }
        }


        return var == true ? "YES" : "NO";
    }
}
