package Array;

public class BInaryAndLInearSearch {
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (target == nums[middle]) {
				return middle;
			} else if (target < nums[middle]) {
				right = middle - 1;
			} else if (target > nums[middle]) {
				left = middle + 1;
			}
		}
		return left;
	}

	public int linearSearch(int[] nums, int target) {
		int i = 0, index = 0;
		while (nums[i] < target && i < nums.length) {
			index =i + 1;
			i++;
		}
		return index;
	}
}
