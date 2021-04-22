package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindMIssingNumber {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		int range = nums.length;
		List<Integer> list = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}

		for (int j = 1; j <= range; j++) {
			if (!set.contains(j)) {
				list.add(j);
			}

		}
		return list;
	}

}
