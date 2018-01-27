package spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WhatsNext {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> elements = new ArrayList();
        int x = -1, y = -1, z = -1;
        while (!(x == 0 && y == 0 && z == 0)) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();

            if (z - y == y - x)
                elements.add("AP " + (z + (z - y)));
            else if ((z / y) == (y / x))
                elements.add("GP " + (int) (z * (double) (z / y)));

            sc.nextLine();
        }

        for (int i = 0; i < elements.size() - 1; i++) {
            System.out.println(elements.get(i));
        }

    }
}
