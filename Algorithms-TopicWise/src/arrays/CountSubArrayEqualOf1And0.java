package arrays;

public class CountSubArrayEqualOf1And0 {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 0, 0, 1, 0, 1, 1};

        System.out.println("Count SubArray Equal Of 1 And 0:" + countSubArray(arr, arr.length));
    }

    public static int countSubArray(int[] arr, int n) {

        int subArray = 0;
        int counterzero = 0, countones = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                counterzero = 1;
                countones = 0;
            }
            if (arr[i] == 1) {
                countones = 1;
                counterzero = 0;
            }
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == 1) countones++;
                if (arr[j] == 0) counterzero++;
                if (countones == counterzero) {
                    subArray++;
                    System.out.println("The first sub array is " + i + "," + j);
                }
            }
        }

        return subArray;
    }

}
