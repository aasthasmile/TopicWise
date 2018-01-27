package spoj;

import java.util.Scanner;

/**
 * our task is to add two reversed numbers and output their reversed sum. Of course, the result is not unique
 * because any particular number is a reversed form of several numbers (e.g. 21 could be 12, 120 or 1200 before reversing).
 * Thus we must assume that no zeros were lost by reversing (e.g. assume that the original number was 12).
 */
public class AddingReversedNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            int num1 = Integer.parseInt(sc.next());
            int num2 = Integer.parseInt(sc.next());

            System.out.println(findReverse(findReverse(num1)+findReverse(num2)));

        }
    }

    private static int findReverse(int num1) {
        String sb = new String();
        while (num1 != 0) {
            /*while (num1 % 10 == 0 && num1 != 0)
                num1 = num1 / 10;*/
            int rem = num1 % 10;
            num1 = num1 / 10;
            sb += String.valueOf(rem);
        }
        return Integer.parseInt(sb);
    }
}
