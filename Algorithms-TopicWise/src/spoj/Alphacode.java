package spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ACODE - Alphacode
 * #dynamic-programming
 * Alice and Bob need to send secret messages to each other and are discussing ways to encode their messages:
 * <p>
 * Alice: “Let’s just use a very simple code: We’ll assign ‘A’ the code word 1, ‘B’ will be 2, and so on down to ‘Z’ being assigned 26.”
 * <p>
 * Bob: “That’s a stupid code, Alice. Suppose I send you the word ‘BEAN’ encoded as 25114. You could decode that in many different ways!”
 * Alice: “Sure you could, but what words would you get? Other than ‘BEAN’, you’d get ‘BEAAD’, ‘YAAD’, ‘YAN’, ‘YKD’ and ‘BEKD’. I think you would be able to figure out the correct decoding. And why would you send me the word ‘BEAN’ anyway?”
 * Bob: “OK, maybe that’s a bad example, but I bet you that if you got a string of length 5000 there would be tons of different decodings and with that many you would find at least two different ones that would make sense.”
 * Alice: “How many different decodings?”
 * Bob: “Jillions!”
 * <p>
 * For some reason, Alice is still unconvinced by Bob’s argument, so she requires a program that will determine how many decodings there can be for a given string using her code.
 * <p>
 * Input
 * Input will consist of multiple input sets. Each set will consist of a single line of at most 5000 digits representing a valid encryption (for example, no line will begin with a 0). There will be no spaces between the digits. An input line of ‘0’ will terminate the input and should not be processed.
 * <p>
 * Output
 * For each input set, output the number of possible decodings for the input string. All answers will be within the range of a 64 bit signed integer.
 * <p>
 * Example
 * Input:
 * <p>
 * 25114
 * 1111111111
 * 3333333333
 * 0
 * <p>
 * Output:
 * <p>
 * 6
 * 89
 * 1
 */
public class Alphacode {

    //iterative solution
    public static int alpha_deco(int[] num, int start, int end) {
        int dp[] = new int[end + 1];
        Arrays.fill(dp, 1);

        for (int i = 1; i <= end; i++) {
            if (num[i] == 0) {
                dp[i] = dp[i - 1];
            } else if (num[i - 1] * 10 + num[i] >= 1 && num[i - 1] * 10 + num[i] <= 26) {
                if (i > 1)
                    dp[i] = dp[i - 1] + dp[i - 2];
                else
                    dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> point=new ArrayList<>();
        while (true) {
            String num = sc.nextLine();
            if (num.equals("0")) break;
            int[] arr = new int[5000];
            int i = 0;
            for (i = 0; i < num.length(); i++) {
                arr[i] = Character.getNumericValue(num.charAt(i));
                if (arr[i] == 0) break;
            }
            int end = i - 1;

            point.add(alpha_deco(arr, 0, end));
        }

        point.forEach(e->{
            System.out.println(e);
        });
    }

    //recursive solution
    public static int alpha_decode(int[] num, int start, int end) {
        if (end - start == 0) return 1;
        else if (end - start == 1) {
            if ((num[start] * 10 + num[start + 1]) >= 1 && (num[start] * 10 + num[start + 1]) <= 26) return 2;
            else return 1;
        } else if (end - start >= 2) {
            if ((num[start] * 10 + num[start + 1]) >= 1 && (num[start] * 10 + num[start + 1]) <= 26) {
                return alpha_decode(num, start + 2, end) + alpha_decode(num, start + 1, end);
            } else {
                return alpha_decode(num, start + 1, end);
            }
        }
        return 0;
    }
}
