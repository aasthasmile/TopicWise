package spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Byteman has a collection of N squares with side 1. How many different rectangles can he form using these squares?
 * <p>
 * Two rectangles are considered different if none of them can be rotated and moved to obtain the second one. During rectangle construction, Byteman can neither deform the squares nor put any squares upon any other ones.
 * <p>
 * Input
 * The first and only line of the standard input contains one integer N (1 <= N <= 10000).
 * <p>
 * Output
 * The first and only line of the standard output should contain a single integer equal to the number of different rectangles that Byteman can form using his squares.
 * <p>
 * Example
 * For the input data:
 * <p>
 * 6
 * the correct result is:
 * <p>
 * 8
 */
public class Rectangles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lastdidgit();
        /*int num = Integer.parseInt(sc.nextLine());

        int n = 0;
        if (num % 2 == 0) {
            n = numberOfRectangles(num);
        } else {
            n = numberOfRectangles(num - 1) + 1;
        }
        System.out.println(n);*/

    }

    private static int numberOfRectangles(int num) {
        int range = num / 2;
        return num + range - 1;
    }

    private static void lastdidgit() {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        List<Integer> point = new ArrayList<>();
        while (test-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a==0||b==0) {
                if (b == 0) point.add(1);
                if (a == 0) point.add(0);
            }else {
                Double number = Math.pow(a, b);
                int rem = (number.intValue()) % 10;
                point.add(rem);
            }
        }

        point.forEach(i -> System.out.println(i));

    }
}
