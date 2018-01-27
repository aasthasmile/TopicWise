package spoj;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Julka surprised her teacher at preschool by solving the following riddle:
 * <p>
 * Klaudia and Natalia have 10 apples together, but Klaudia has two apples more than Natalia. How many apples does each of he girls have?
 * <p>
 * Julka said without thinking: Klaudia has 6 apples and Natalia 4 apples. The teacher tried to check if Julka's answer wasn't accidental and repeated the riddle every time increasing the numbers. Every time Julka answered correctly. The surprised teacher wanted to continue questioning Julka, but with big numbers she could't solve the riddle fast enough herself. Help the teacher and write a program which will give her the right answers.
 * <p>
 * Task
 * Write a program which
 * <p>
 * reads from standard input the number of apples the girls have together and how many more apples Klaudia has,
 * counts the number of apples belonging to Klaudia and the number of apples belonging to Natalia,
 * writes the outcome to standard output
 * Input
 * Ten test cases (given one under another, you have to process all!). Every test case consists of two lines. The first line says how many apples both girls have together. The second line says how many more apples Klaudia has. Both numbers are positive integers. It is known that both girls have no more than 10100 (1 and 100 zeros) apples together. As you can see apples can be very small.
 * <p>
 * Output
 * For every test case your program should output two lines. The first line should contain the number of apples belonging to Klaudia. The second line should contain the number of apples belonging to Natalia.
 * <p>
 * Example
 * Input:
 * 10
 * 2
 * [and 9 test cases more]
 * <p>
 * Output:
 * 6
 * 4
 * [and 9 test cases more]
 */
public class Julka {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = Integer.parseInt(sc.nextLine());

        List<BigInteger> point = new ArrayList<>();
        for (int ii=0;ii<testcase;ii++){
            BigInteger total = BigInteger.valueOf(sc.nextLong());
            BigInteger extras = BigInteger.valueOf(sc.nextLong());

            //2*y+extas=total;
            BigInteger n = BigInteger.ZERO;
            n = (total.subtract(extras)).divide(BigInteger.valueOf(2));
            BigInteger k = n.add(extras);

            point.add(k);
            point.add(n);
        }

        point.forEach(i -> {
            System.out.println(i);
        });
    }
}
