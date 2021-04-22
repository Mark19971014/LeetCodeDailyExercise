package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ThirdMax {
	public static int thirdMax(int[] nums) {
        int [] arr = nums.clone();
        Arrays.sort(arr);
        int index = 1 ;
        for(int i = 0; i< arr.length-1; i++) {
        	if (arr[i] != arr[i+1]) {
        		arr[index] = arr[i+1];
        		index++;
        	}
        }
        
        //0 1 2 3 8 9 111 9 111
        int max;
        
        if(arr.length >= 3) {
        	max = arr[index - 3];
        }else {
        	max = arr[index - 1];
        }
        return max;
    }

	
	public static int thirdMaxhashset(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i : nums) {
			set.add(i);
		}
			if(set.size() >= 3) {
				set.remove(Collections.max(set));
				set.remove(Collections.max(set));
			}
		
		return Collections.max(set);
	}
	public static void main(String[] args) {
		int[] nums = {1,2};
		System.out.println((thirdMax(nums)));

	}

}
