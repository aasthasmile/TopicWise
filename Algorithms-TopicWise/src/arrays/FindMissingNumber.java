package arrays;

/**
 * Given an array of size n-1 and given that there are numbers from 1 to n with
 * one missing, the missing number is to be found.
 * 
 * @author aastha.b.jain
 *
 */
public class FindMissingNumber {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 4, 5 };
		int n = 5;
		System.out.println("The missing number is:"+missingNumberInArray(arr, arr.length, n));
	}

	private static int missingNumberInArray(int[] arr, int length, int n) {

		int xor = 0;
		for (int i = 1; i <= n; i++) {
			xor = xor ^ i;
		}

		for (int i = 0; i < arr.length; i++) {
			xor=xor^arr[i];
		}
		
		return xor;
	}

}
