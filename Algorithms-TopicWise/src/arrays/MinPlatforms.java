package arrays;

import java.util.Arrays;

/**
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that no train waits.
 */
public class MinPlatforms {
    public static void main(String[] args) {
        int[] arrival = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] departure = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("The stations required is:" + minNumberStations(arrival, departure));
    }

    private static int minNumberStations(int[] arrivals, int[] departures) {

        if (arrivals.length != departures.length)
            return -1;
        if (arrivals.length == 1 && departures.length == 1)
            return 1;

        int min = 0;

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int ar = 1, dep = 0, stattionCount = 1;

        while (ar < arrivals.length && dep < departures.length) {

            if (arrivals[ar] > departures[dep]) {
                dep++;
                stattionCount--;;
            } else if (arrivals[ar] < departures[dep]) {
                stattionCount++;
                min=Math.max(stattionCount,min);
                ar++;
            }
        }

        return stattionCount;
    }
}
