package pineapple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("code", "leet"))));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        if (s.length() == 0 || wordDict.size() == 0)
            return false;

        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }


        return dp[s.length()];
    }
}
