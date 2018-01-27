package spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trailingzerosfactorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());

        List<Long> elements = new ArrayList();
        for (int ii = 0; ii < test; ii++) {
            int num = Integer.parseInt(sc.nextLine());
            int fives = 5;

            long trailingZeros = 0;
            while (fives <= num) {
                trailingZeros += Math.floor((num / fives));
                fives *= 5;
            }
            elements.add(trailingZeros);
        }
        elements.forEach(i -> {
            System.out.println(i);
        });
    }
}
