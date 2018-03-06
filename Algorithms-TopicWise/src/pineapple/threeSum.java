package pineapple;

import java.util.Arrays;

public class threeSum {

    public static void main(String[] args) {

        int[] x = new int[]{-1, 0, 1, 2, -1, -4};
        targetSumforTriplet(x, 0);
    }

    private static void targetSumforTriplet(int[] x, int target) {

        Arrays.sort(x);
        int i = 0, j = i + 1, k = x.length - 1;

        System.out.println(">>>>>>>>>>>>>>>>>>n^3 approach");
        for (i = 0; i < x.length; i++) {
            for (j = i + 1; j < x.length; j++) {
                for (k = i + 2; k < x.length; k++) {
                    if (x[i] + x[j] + x[k] == target && j < k) {
                        System.out.println("x[i]+x[j]+x[k]=" + x[i] + "+" + x[j] + "+" + x[k] + " = " + target);
                        break;
                    }
                }
            }
        }

        System.out.println(">>>>>>>>>>>>>>>>>>Optimized");
        for (i = 0; i < x.length; i++) {
            for (j = i + 1; j < x.length; j++) {
                k = x.length - 1;

                while (j < k) {
                    if (x[i] + x[j] + x[k] == target) {
                        System.out.println("x[i]+x[j]+x[k]=" + x[i] + "+" + x[j] + "+" + x[k] + " = " + target);
                        break;
                    } else if (x[i] + x[j] + x[k] > target) {
                        k--;
                    } else {
                        j++;
                    }

                    while(x[i]==x[i+1] && i!=x.length){
                        i++;
                    }
                }
            }
        }
    }
}
