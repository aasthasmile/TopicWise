package arrays;

/**
 * Given n non-negative integers in array representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //int[] brr=new int[]{3,0,0,2,0,4};
        System.out.println("The amount of water Trapped:" + amountOfTrappedWater(arr, arr.length));
    }

    /**
     * Logic is find max_at_ith_position .(i=0)
     * and max_at_ith_position .(j=n-1)
     * i and j collide where there is maximum for them.
     * Hence Trapped Water(ith position)=max_at_ith_position -arr[i]
     * Trapped Water(jth position)=max_at_ith_position -arr[j]
     *
     * @param arr
     * @param n
     * @return
     */
    private static int amountOfTrappedWater(int[] arr, int n) {

        int totalMax = -1;
        int max_index = -1;


        for (int i = 0; i < arr.length; i++) {
            if (totalMax < arr[i]) {
                totalMax = Math.max(totalMax, arr[i]);
                max_index = i;
            }
        }

        int leftWall = 0, rightWall = n - 1, left_max_Height = Integer.MIN_VALUE, right_max_Height = Integer.MIN_VALUE;
        int count = 0;
        //0 0 1 0 1 2 1 0 0 1 0 0
        while (leftWall <= max_index) {

            left_max_Height = Math.max(left_max_Height, arr[leftWall]);
            count = count + (left_max_Height - arr[leftWall]);
            leftWall++;
        }
        while (rightWall > max_index) {
            right_max_Height = Math.max(right_max_Height, arr[rightWall]);
            count = count + (right_max_Height - arr[rightWall]);
            rightWall--;
        }


        return count;
    }


}
