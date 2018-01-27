package spoj;

import java.util.Scanner;

/**
 * n Byteland they have a very strange monetary system.
 * <p>
 * Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins:
 * n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).
 * <p>
 * You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.
 * <p>
 * You have one gold coin. What is the maximum amount of American dollars you can get for it?
 * <p>
 * Input
 * The input will contain several test cases (not more than 10). Each testcase is a single line with a number n,
 * 0 <= n <= 1 000 000 000. It is the number written on your coin.
 * <p>
 * Output
 * For each test case output a single line, containing the maximum amount of American dollars you can make.
 * <p>
 * Example
 * Input:
 * 12
 * 2
 * <p>
 * Output:
 * 13
 * 2
 * You can change 12 into 6, 4 and 3, and then change these into $6+$4+$3 = $13.
 * If you try changing the coin 2 into 3 smaller coins, you will get 1, 0 and 0, and later you can get no more than $1 out of them.
 * It is better just to change the 2 coin directly into $2.
 */
public class Coin {

    static long[] Arr = new long[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long arr[] = new long[11];
        int i = 0;
        while (sc.hasNextLong()) {
            long num = sc.nextLong();
            arr[i] = num;
            i++;
        }

        for (int k = 0; k <= 10; k++) {
            Arr[(int) k] = k;
        }

        long sum = 0;
        for (long k = 11; k <= 1000000; k++) {
            sum = Arr[(int) (k / 2)] + Arr[(int) (k / 3)] + Arr[(int) (k / 4)];
            Arr[(int) k] = Math.max(sum, k);
        }

        for (int k = 0; k < 10; k++) {
            if (arr[k] == 0) break;
            long num = solve(arr[k]);
            System.out.println(num);
        }

    }

    private static long solve(long l) {
        long sum = 0;
        if (l == 0) return 0;
        else if (l < 1000000 || Arr[(int) l] != 0) return Arr[(int) l];
        else {
            sum = solve((int) l / 2) + solve(l / 3) + solve(l / 4);
            Arr[(int) l] = Math.max(l, sum);
            return Arr[(int) l];
        }
    }
}
