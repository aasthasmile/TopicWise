package spoj;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandyIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = Integer.parseInt(sc.nextLine());

        List<String> point = new ArrayList<>();
        long[] a = new long[testcase];
        for (int ii = 0; ii < testcase; ii++) {
            long num = sc.nextInt();

            long arr[] = new long[(int) num];
            BigInteger sum = BigInteger.ZERO;
            for (int k = 0; k < arr.length; k++) {
                arr[k] = sc.nextLong();
                sum = sum.add(BigInteger.valueOf(arr[k]));
            }

            if (sum.mod(BigInteger.valueOf(num)).equals(BigInteger.ZERO))
                point.add("YES");
            else
                point.add("NO");
        }

        point.forEach(i -> {
            System.out.println(i);
        });

    }
}
