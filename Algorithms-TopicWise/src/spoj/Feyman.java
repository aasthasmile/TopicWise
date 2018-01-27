package spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Feyman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> point = new ArrayList<>();
        while (sc != null) {
            int number = Integer.parseInt(sc.nextLine());
            if (number > 0) point.add((number * (number + 1) * (2 * number + 1)) / 6);
            else break;
        }
        point.forEach(i -> {
            System.out.println(i);
        });
    }
}
