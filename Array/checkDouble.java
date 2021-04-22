package Array;

import java.util.HashSet;
import java.util.Set;

public class checkDouble {
	public boolean checkIfExist(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i : arr) {
			if (set.contains(i*2)) {
				return true;
			}else if (i % 2 == 0 &&set.contains(i/2)) {
				return true;
			}
			set.add(i);
		}
		return false;
	}
}
