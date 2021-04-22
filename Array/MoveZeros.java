package Array;

import java.util.Arrays;

public class MoveZeros {
	// swap zero with the first non-zero value in the rest of the array
	public static int[] move(int[] arr) {
		int temp;
		int pointer = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[pointer] == 0 && arr[pointer + 1] != 0) {
				temp = arr[pointer];
				arr[pointer] = arr[pointer + 1];
				arr[pointer + 1] = temp;
				pointer++;
			}
			for (int j = pointer; j < arr.length; j++) {
				if (arr[j] != 0) {
					temp = arr[pointer];
					arr[pointer] = arr[j];
					arr[j] = temp;

				}
			}

		}

		return arr;
	}

	public static int[] move2(int[] arr) {
		int reader = 1;
		int writer = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[writer] == 0) {
				arr[i] = arr[writer];
				
			}else if (arr[reader] != 0){
				int temp;
				temp = arr[writer];
				arr[writer] =  arr[reader];
				arr[reader] = temp;
				
			}
		}
		
		
		
		
		return arr;
	}
	public static int[] move03(int[] nums) {
		int index = 0;
		int count = 0;
	
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[index++] = nums[i];
				count++;
			}
		}
		while(count < nums.length) {
			nums[count++] = 0;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] num = { 0, 1, 3, 0, 12 ,0,9};
		System.out.println(Arrays.toString(move03(num)));
	}

}
