package sdeskills;

/**
 * Given a number ,print collatz sequence f(n)=if n is even,return n/2 else return 3n+1.
 * Collatz sequence ends when this process leads to 1 at the end.
 */
public class ColatzSequence {

    public static void main(String[] args) {
        int number = 654;

        findCollatzSequence(number);
    }

    private static void findCollatzSequence(int number) {
        System.out.print(number+" ");

        if (number == 1)
            return;

        if (number % 2 == 0)
            number = number / 2;
        else
            number = 3 * number + 1;
        findCollatzSequence(number);

    }
}
