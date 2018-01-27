package spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Jennifer is afraid that each child will want to have the biggest packet of candies and this
 * will lead to quarrels or even fights among children. She wants to avoid this. Therefore, she has
 * decided to open all the packets, count the candies in each packet and move some candies from '
 * bigger packets to smaller ones so that each packet will contain the same number of candies. T
 * he question is how many candies she has to move.
 */

public class candy1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> point = new ArrayList<>();
        while (sc != null) {
            int numbers = Integer.parseInt(sc.nextLine());
            if (numbers == -1) break;

            int sum = 0;
            int[] num = new int[numbers];

            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(sc.nextLine());
                sum = sum + num[i];
            }

            int candies = (sum / num.length);

            if (sum % num.length != 0)
                point.add(-1);
            else {
                int count=0;
                for (int i = 0; i < num.length; i++) {
                    if (num[i]<candies) {
                        count=count+(candies-num[i]);
                    }
                }
                point.add(count);
            }
        }

        point.forEach(i -> {
            System.out.println(i);
        });
    }
}
