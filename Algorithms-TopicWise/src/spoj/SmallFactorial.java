package spoj;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SmallFactorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());

        Set<Long> fact = new LinkedHashSet<>();
        for (int ii = 0; ii < test; ii++) {
            int num = sc.nextInt();

            long factorial = 1;
            while (num != 1) {
                factorial = factorial * num;
                num--;
            }
            fact.add(factorial);
        }

        for (Long l:fact) {
            System.out.println(l);
        }

    }

}
