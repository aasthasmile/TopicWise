package spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * A fashion show rates participants according to their level of hotness. Two different fashion shows were organized, one for men and the other for women. A date for the third is yet to be decided ;) .
 * <p>
 * Now the results of both fashion shows are out. The participants of both the fashion shows have decided to date each other, but as usual they have difficuly in choosing their partners. The Maximum Match dating serive (MMDS) comes to their rescue and matches them in such a way that that maximizes the hotness bonds for all couples.
 * <p>
 * If a man has been rated at hotness level x and a women at hotness level y, the value of their hotness bond is x*y.
 * <p>
 * Both fashion shows contain N participants each. MMDS has done its job and your job is to find the sum of hotness bonds for all the couples that MMDS has proposed.
 * <p>
 * Input
 * The first line of the input contains an integer t, the number of test cases. t test cases follow.
 * <p>
 * Each test case consists of 3 lines:
 * <p>
 * The first line contains a single integer N (1 <= N <= 1000).
 * The second line contains N integers separated by single spaces denoting the hotness levels of the men.
 * The third line contains N integers separated by single spaces denoting the hotness levels of the women.
 * All hotness ratings are on a scale of 0 to 10.
 * <p>
 * Output
 * For each test case output a single line containing a single integer denoting the sum of the hotness bonds for all pairs that MMDS has proposed.
 * <p>
 * Example
 * Input:
 * 2
 * 2
 * 1 1
 * 3 2
 * 3
 * 2 3 2
 * 1 3 2
 * <p>
 * Output:
 * 5
 * 15
 */
public class FashionShows {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        List<Integer> point = new ArrayList<>();
        while (test != 0) {
            int n = sc.nextInt();

            int[] men = new int[n];
            int[] women = new int[n];

            for (int i = 0; i < n; i++) men[i] = sc.nextInt();
            for (int i = 0; i < n; i++) women[i] = sc.nextInt();

            Arrays.sort(men);
            Arrays.sort(women);

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + men[i] * women[i];
            }
           point.add(sum);
            test--;
        }
        point.forEach(i -> {
            System.out.println(i);
        });

    }
}
