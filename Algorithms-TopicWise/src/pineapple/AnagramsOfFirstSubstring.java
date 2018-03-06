package pineapple;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.careercup.com/question?id=5389078581215232
 * Given two strings tells if anagram of first is substring of another.
 * if a = xyz and b = afdgzyxksldfm
 */
public class AnagramsOfFirstSubstring {

    public static void main(String[] args) throws Exception {

        BufferedReader brf = new BufferedReader(new StringReader(""));

        String str1 = "IAMAALIEN";
        String str2 = "HELLOALIENAAMI";

        System.out.println("Second Substring is anagram of first :" + checkWhetherAnagramOfFirstIsInSecond(str1, str2));
    }

    /**
     * Make two maps for both the string.
     * Map size of str2 should be always equal to window size=st1.length.
     * Step 1: Add one char ,increase char count.
     * Step 2: Delete one char,decrement char count.
     * Step 3: check two maps are equal or not.
     * @param str1
     * @param str2
     * @return
     */
    private static boolean checkWhetherAnagramOfFirstIsInSecond(String str1, String str2) {

        if (str1 == null)
            return false;

        Map<Character, Integer> wordCount = new HashMap<>();
        Map<Character, Integer> originalText = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            wordCount.put(str1.charAt(i), !wordCount.containsKey(str1.charAt(i)) ? 1 : wordCount.get(str1.charAt(i)) + 1);
            originalText.put(str2.charAt(i), !originalText.containsKey(str2.charAt(i)) ? 1 : originalText.get(str2.charAt(i)) + 1);
        }

        int size = str1.length();
        for (int i = size; i < str2.length(); i++) {
            if (wordCount.equals(originalText)) {
                return true;
            }
            //add the next item in the window    - Only one
            originalText.put(str2.charAt(i), !originalText.containsKey(str2.charAt(i)) ? 1 : originalText.get(str2.charAt(i)) + 1);

            //remove one element from the window -(i-size)
            originalText.put(str2.charAt(i - size),!originalText.containsKey(str2.charAt(i - size)) ? 0 : originalText.get(str2.charAt(i - size)) - 1);
            if(originalText.get(str2.charAt(i - size))==0){
                originalText.remove(str2.charAt(i-size));
            }

        }

        if (wordCount.equals(originalText)) {
            return true;
        }

        return false;
    }

}
