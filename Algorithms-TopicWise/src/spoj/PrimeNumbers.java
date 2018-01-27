package spoj;

import java.util.Scanner;

/**
 * Peter wants to generate some prime numbers for his cryptosystem.
 * Help him! Your task is to generate all prime numbers between two given numbers!
 */
public class PrimeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int ii = 0; ii < test; ii++) {
            int start = Integer.parseInt(sc.next());
            int end = Integer.parseInt(sc.next());
            for (int j = Math.max(2, start); j <= end; j++) {
                boolean flag = false;
                for (int i = 2; i <= Math.sqrt(j); i++) {
                    if (j % i == 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    System.out.print(j + " ");
            }
        }
    }


}
