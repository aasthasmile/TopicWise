package spoj;

import java.util.Scanner;

public class lifeUninverseEverything {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc!=null) {
            int num = Integer.parseInt(sc.nextLine());
            if (num == 42)
                break;
            System.out.println(num);
        }

    }

}
