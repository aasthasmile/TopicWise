package pineapple;

import java.util.*;

public class taskscheduler {

    public static void main(String[] args) {

       /* String[] str = new String[]{"A", "A", "A", "A", "B", "B", "B", "E", "E", "F", "F", "G", "G"};
        int k = 3;
        minimumInterval(str, k);*/


        int cost[] = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        minclimbSteps(cost);
    }

    //either step 1 or step 2. Start at t[0] or t[1]
    private static void minclimbSteps(int[] cost) {

        int totalCost = 0;
        int position = 0;
        boolean flag = false;
        for (int j = position; position < cost.length; j++) {
            if (!flag) {
                totalCost = cost[j] < cost[j + 1] ? totalCost + cost[j] : totalCost + cost[j + 1];
                position = cost[j] < cost[j + 1] ? j : j + 1;
                System.out.println("Position: " + position);
                flag = true;
            }

            totalCost = cost[position + 1] < cost[position + 2] ? totalCost + cost[position + 1] : totalCost + cost[position + 2];
            position = cost[position + 1] < cost[position + 2] ? position + 1 : position + 2;
            System.out.println("Position: " + position);
        }

        System.out.println(totalCost);

    }


    private static void minimumInterval(String[] str, int k) {

        SortedMap<Integer, String> map = new TreeMap<>();
        Arrays.sort(str);

        int count = 0;
        for (int i = 0; i < str.length - 1; i++) {
            while (str[i].equals(str[i + 1])) {
                count++;
            }
            map.put(count, str[i - 1]);
            count = 0;
        }

        List<String> finalResp = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            entry.getKey();
        }


    }


}

