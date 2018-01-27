package spoj;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Transform the algebraic expression with brackets into RPN form (Reverse Polish Notation).
 * Two-argument operators: +, -, *, /, ^ (priority from the lowest to the highest), brackets ( ).
 * Operands: only letters: a,b,...,z. Assume that there is only one RPN form (no expressions like a*b*c).
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());

        List<String> postfixList = new ArrayList<>();
        for (int ii = 0; ii < test; ii++) {
            String infix = sc.nextLine();

            String postfix = "";
            Stack<String> st = new Stack<>();

            Map<String, Integer> map = new HashMap<>();
            map.put("^", 3);
            map.put("*", 2);
            map.put("/", 2);
            map.put("+", 1);
            map.put("-", 1);
            Pattern operands = Pattern.compile("[a-zA-Z]");
            Pattern operators = Pattern.compile("[*/+-^]");
            for (int i = 0; i < infix.length(); i++) {
                String index = String.valueOf(infix.charAt(i));
                if (operands.matcher(index).matches()) {
                    postfix += index;
                } else if (operators.matcher(index).matches()) {
                    while (!st.isEmpty() && !st.peek().equalsIgnoreCase("(") && map.get(st.peek()) >= map.get(index))
                        postfix += st.pop();

                    st.push(index);
                } else if (index.equalsIgnoreCase("("))
                    st.push(index);
                else if (index.equalsIgnoreCase(")")) {
                    while (!st.peek().equalsIgnoreCase("(")) {
                        String top = st.pop();
                        if (!top.equalsIgnoreCase("(")) postfix += top;
                    }
                    st.pop();
                }

            }
            while (!st.isEmpty()) {
                postfix += st.pop();
            }
            postfixList.add(postfix);
        }

        postfixList.forEach(i -> {
            System.out.println(i);
        });
    }
    /**
     * Method:
     * 1)whenever there is operand ,add it to final output as postfix expression
     * 2)if it is operator such as ^,*,/,+,- ,(,),then add them to the stack according to the precendence of operator.
     * ex:- Precedence1(^) ,Precedence2(*,/),Precedence 3(+,-) .
     * 3.If pushing an operand of less or equal precedence to top of the stack->  then pop out and add it to the final output.
     * 4.When all operands are done,pop all operator from stack until empty and add it to the final output.
     */

    /** Online method:
     * 1. Scan the infix expression from left to right.
     2. If the scanned character is an operand, output it.
     3. Else,
     …..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty), push it.
     …..3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal to the precedence of the operator residing on the top of the stack. Push the scanned operator to the stack.
     4. If the scanned character is an ‘(‘, push it to the stack.
     5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
     6. Repeat steps 2-6 until infix expression is scanned.
     7. Pop and output from the stack until it is not empty.
     */


}
