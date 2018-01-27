package spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Starting from point (0,0) on a plane, we have written all non-negative integers 0, 1, 2,... as shown in the figure.
 * For example, 1, 2, and 3 has been written at points (1,1), (2,0), and (3, 1) respectively and this pattern has continued.
 */
public class NumberSteps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());

        List<String> point = new ArrayList<>();
        for (int ii = 0; ii < test; ii++) {
            String[] coordinates = sc.nextLine().split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);

            if (x >=y+2) {
                if (x % 2 == 0 && y % 2 == 0)
                    point.add(String.valueOf(x + y));
                else
                    point.add(String.valueOf(x + y - 1));
            }
            else
                point.add("No Number");
        }

        point.forEach(i -> {
            System.out.println(i);
        });
    }
}
