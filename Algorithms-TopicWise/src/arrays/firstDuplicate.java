package arrays;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an array a that contains only numbers in the range from 1 to a.length, find the first duplicate number for which the second occurrence has the minimal index. In other words, if there are more than 1 duplicated numbers, return the number for which the second occurrence
 * has a smaller index than the second occurrence of the other number does. If there are no such elements, return -1.
 */
public class firstDuplicate {

    public static void main(String[] args) {

        System.out.println("The duplicates:" + firstDuplicate(new int[]{2, 3, 3, 1, 5, 2}));

        System.out.println("First non repeating charcater:" + firstNotRepeatingCharacter("abcdabba"));

        System.out.println("rotate Image" + rotateImage(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    static char firstNotRepeatingCharacter(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        char firstNotRepeat = '\0';
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 1);
            else
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                firstNotRepeat = entry.getKey();
                break;
            }
        }

        return firstNotRepeat != '\0' ? firstNotRepeat : '_';
    }

    static int firstDuplicate(int[] a) {

        int minIndex = Integer.MAX_VALUE;
        int[] arr = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            arr[a[i]]++;
            if (arr[a[i]] == 2) {
                minIndex = Math.min(minIndex, i);
            }
        }
        return minIndex != Integer.MAX_VALUE ? a[minIndex] : -1;
    }

    static int[][] rotateImage(int[][] a) {

        int[][] modA = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                modA[i][j] = a[(a.length-1)-j][i];
            }
        }

        return modA;
    }


}
