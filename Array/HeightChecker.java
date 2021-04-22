package Array;

import java.util.Arrays;

public class HeightChecker {
// sort the original array

	public static int chcker(int[] arr) {
		int count = 0;
		// copy and sort the new array
		int[] newarry = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for(int p = i + 1; p < arr.length; p++) {
				if (arr[i] > arr[p]) {
					int temp = 0;
					temp = arr[i];
					arr[i] = arr[p];
					arr[p] = temp;
				}
			}
		}
		// compare two array;
		for (int k = 0; k < arr.length; k++ ) {
			if(newarry[k] != arr[k]) {
				count++;
		}
	}
		return count;
}
	public static void main(String[] args) {
		int[] nums = {1,1,4,2,1,3};
		System.out.println((chcker(nums)));

	}
}