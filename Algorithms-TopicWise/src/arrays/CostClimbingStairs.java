package arrays;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost
 * to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1
 */
public class CostClimbingStairs {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("The min cost for Climbing "+minCostClimbingStairs(arr));
    }

    public static int minCostClimbingStairs(int[] cost) {

        int mincost = Integer.MAX_VALUE;

        int finalCost = 0;

        int finalCost_1 = 0;
        int finalCost_2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            finalCost = cost[i] + Math.min(finalCost_1, finalCost_2);
            finalCost_2 = finalCost_1;
            finalCost_1 = finalCost;
        }

        return Math.min(finalCost_1, finalCost_2);
    }


}
