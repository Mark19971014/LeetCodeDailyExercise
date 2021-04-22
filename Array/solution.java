package Array;

import java.util.Arrays;

public class solution {
	public static int remove(int[] nums) {
		Arrays.sort(nums);
		int ArrayLength = 1;
		for (int i = 0; i<nums.length-1; i++) {
			if(nums[i] != nums[i+1]) {
				nums[ArrayLength] = nums[i+1];
					ArrayLength++;
				
			}
			
		}
		
		return ArrayLength;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {0,3,3,1,1,2,9,8,111,9};
		int ArrayLength = remove(nums);
		System.out.println(remove(nums));
		for(int i = 0; i < ArrayLength; i++) {
			System.out.print(nums[i]+ " ");
		}

	}

}
//[0, 1, 2, 3, 8, 9, 111, 9, 111]
