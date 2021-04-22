package Array;

import java.util.Arrays;


public class RemoveDplicate {
	public static int[] remove(int[] nums) {
		Arrays.sort(nums);
		int index = 1;
		for (int i = 0; i<nums.length-1; i++) {
			if(nums[i] != nums[i+1]) {
				nums[index++] = nums[i+1];
				
			}
		}
		return nums;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {0,1,1,2};
		System.out.println(Arrays.toString(remove(nums)));

	}


}


// [0,0,1,1,1,2,2,3,3,4]
// 双向思维，考虑细节