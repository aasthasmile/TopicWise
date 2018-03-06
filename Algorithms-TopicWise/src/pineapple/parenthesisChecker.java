package pineapple;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Given an expression string exp, examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
 * <p>
 * Print 'balanced' without quotes if pair of parenthesis are balanced else print 'not balanced' in a separate line.
 */
public class parenthesisChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = Integer.parseInt(sc.nextLine());

        while (testCase-- > 0) {
            String s = sc.nextLine();
            System.out.println(checkForParenthesis(s) ? "balanced" : "not balanced");
        }

    }

    /**
     * Sample Test case:
     *
     * 1
     * [()]{}{[()()]()}
     * [(])
     *
     * Result:
     * Balanced
     * not balanced
     *
     * @param str
     * @return
     */
    private static boolean checkForParenthesis(String str) {

        Stack<Character> st = new Stack<>();

        Map<Character, Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put('(', ')');
        parenthesisMap.put('{', '}');
        parenthesisMap.put('[', ']');

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
                st.push(str.charAt(i));
            else if (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {
                if (!st.isEmpty()) {
                    if (str.charAt(i) == parenthesisMap.get(st.peek()))
                        st.pop();
                    else
                        return false;
                } else
                    return false;

            }
        }
        return true;

    }
}
