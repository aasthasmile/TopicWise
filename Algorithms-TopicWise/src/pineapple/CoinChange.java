package pineapple;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 8};
        int target = 11;
        coinChange(nums, target);
    }

    public static int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;
        for (int k = 0; k < dp[0].length; k++)
            dp[0][k] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i-1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i-1]]);
            }
        }

        return dp[dp.length][dp[0].length];
    }
}
