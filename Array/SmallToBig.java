package Array;

import java.util.Arrays;

public class SmallToBig {
	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = 0;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
	}
	return arr;
	
	}
	public static void main(String[] args) {
		int[] nums = {5,1,2,3,4};
		
		System.out.println(Arrays.toString(sort(nums)));
	}

}
