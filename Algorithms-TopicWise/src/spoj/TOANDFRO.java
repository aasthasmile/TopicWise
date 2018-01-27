package spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Mo and Larry have devised a way of encrypting messages. They first decide secretly on the number of columns and write the message (letters only) down the columns, padding with extra random letters so as to make a rectangular array of letters. For example, if the message is “There’s no place like home on a snowy night” and there are five columns, Mo would write down
 * <p>
 * t o i o y
 * h p k n n
 * e l e a i
 * r a h s g
 * e c o n h
 * s e m o t
 * n l e w x
 * Note that Mo includes only letters and writes them all in lower case. In this example, Mo used the character ‘x’ to pad the message out to make a rectangle, although he could have used any letter. Mo then sends the message to Larry by writing the letters in each row, alternating left-to-right and right-to-left. So, the above would be encrypted as
 * <p>
 * toioynnkpheleaigshareconhtomesnlewx
 * Your job is to recover for Larry the original message (along with any extra padding letters) from the encrypted one.
 * <p>
 * Input
 * There will be multiple input sets. Input for each set will consist of two lines. The first line will contain an integer in the range 2...20 indicating the number of columns used. The next line is a string of up to 200 lower case letters. The last input set is followed by a line containing a single 0, indicating end of input.
 * <p>
 * Output
 * Each input set should generate one line of output, giving the original plaintext message, with no spaces.
 * <p>
 * Example
 * Input:
 * <p>
 * 5
 * toioynnkpheleaigshareconhtomesnlewx
 * 3
 * ttyohhieneesiaabss
 * 0
 * <p>
 * Output:
 * <p>
 * theresnoplacelikehomeonasnowynightx
 * thisistheeasyoneab
 */
public class TOANDFRO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> point = new ArrayList<>();
        while (sc != null) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) break;
            String encrypted = sc.nextLine();

            String[] pairs = new String[encrypted.length() / n];
            int j = 0;

            for (int i = 0; i < pairs.length; i++, j = j + n) {
                if (i % 2 != 0)
                    pairs[i] = reverseString(encrypted.substring(j, j + n));
                else
                    pairs[i] = encrypted.substring(j, j + n);
                System.out.println(pairs[i]);
            }

            String decrypted = "";
            for (int i = 0; i < n; i++) {
                int k = 0;
                while (k < pairs.length) {
                    decrypted += (pairs[k].charAt(i) + "");
                    k++;
                }
            }

            point.add(decrypted);
        }

        for (String s : point) {
            System.out.println(s);
        }
    }

    private static String reverseString(String substring) {
        Stack<String> str = new Stack<>();
        int len = substring.length();

        String reversed = "";

        for (int i = 0; i < substring.length(); i++)
            str.push(substring.charAt(i) + "");

        while (!str.isEmpty())
            reversed += str.pop();

        return reversed;
    }
}
