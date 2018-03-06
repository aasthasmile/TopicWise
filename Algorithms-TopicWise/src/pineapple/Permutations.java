package pineapple;

import java.util.Scanner;

/***
 * All Permutations of a string =n!(n factorial)
 * AB = AB BA 2!=2
 * ABC = ABC ACB BAC BCA CAB CBA 3!=6
 */
public class Permutations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        permutateString("abc");
    }

    /**
     * Recursive solution to get all Permutations of a string
     *
     * @param
     */
    public static void permutateString(String s) {
        permutate("", s);
    }

    private static void permutate(String prefix, String s) {
        if (s.length() == 0) System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+prefix);
        else {
            for (int i = 0; i < s.length(); i++) {

               /* System.out.println("Prefix =" + prefix);
                System.out.println("ith char=" + s.charAt(i));
                System.out.println("s.substring(o,i)=" + s.substring(0, i) + "\n s.substring(i+1,s.length())=" + s.substring(i + 1, s.length()));*/
                permutate(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()));
            }

        }
    }

}
