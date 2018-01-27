package string.expert;

/**
 * Frequency of a substring in a string
 * 5
 * Given a input string and a substring. Find the frequency of occurrences of substring in given string.
 */
public class FrequencySubstring {

    public static void main(String[] args) {
        String str = "abcdababababcdabcd";
        String pattern = "aba";

        System.out.println("The frequency is " + frequenyOfPattern_optimized(str, pattern));
    }

    /**
     * O(n+m) where n= string.length and m=pattern.length
     * String Matching algorithm (Z-algorithm -> appending pattern in front of string and wherever arr[]
     * contains pattern.length,then frequency ++;
     *
     * @param str
     * @param pattern
     * @return
     */
    private static int frequenyOfPattern_optimized(String str, String pattern) {

        String conStr = pattern + "#" + str; //conStr means concatenated String
        int lps[] = new int[conStr.length()]; //lps means longest common prefix suffix

        lps[0] = 0;
        int j = 0, i = 1;
        int freq = 0;
        while (i < conStr.length() && j <= i) {
            int index = i;

            if (conStr.charAt(j) == conStr.charAt(i)) {
                while (conStr.charAt(j) == conStr.charAt(i)) {
                    i++;
                    j++;
                    lps[index] = lps[index] + 1;
                }
                i=index+1;
                j = 0;
                if (lps[index] == pattern.length())
                    freq++;
            } else {
                lps[index] = 0;
                if (j != 0)
                    j = lps[j - 1];
                i++;
            }
            System.out.print(lps[index] + " ");
        }

        return freq;
    }

    /**
     * o(n*m) complexity where n=string length and m=pattern length
     *
     * @param str
     * @param pattern
     * @return
     */
    private static int frequenyOfPattern(String str, String pattern) {
        int k = pattern.length();
        int freq = 0;
        for (int i = 0; i + k - 1 < str.length(); i++) {
            if (str.substring(i, i + k).equalsIgnoreCase(pattern)) {
                freq++;
            }
        }

        return freq;
    }


}
