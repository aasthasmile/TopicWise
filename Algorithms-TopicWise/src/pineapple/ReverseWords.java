package pineapple;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Given a String of length N reverse the words in it. Words are separated by dots.
 * <p>
 * 2
 * i.like.this.program.very.much
 * pqr.mno
 */
public class ReverseWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());

        while (testCase-- > 0) {
            //String sentence=sc.nextLine();
            String[] words = sc.nextLine().split("\\.");

            List<String> sbr = new LinkedList<>();
            for (int i = 0; i < words.length; i++) {
                char[] charArray = words[i].toCharArray();
                sbr.add(reversedStringInPlace(charArray, 0, charArray.length - 1));
            }

            System.out.println(sbr.stream().collect(Collectors.joining(".")));

        }

    }

    private static String reversedStringInPlace(char[] ch, int i, int j) {

        if (j - i <= 0)
            return ch.toString();


        while (i <= j - 1) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }

        StringBuilder reversedStr = new StringBuilder();
        for (int k = 0; k < ch.length; k++) {
            reversedStr.append(ch[k]);
        }

        return reversedStr.toString();
    }


}
