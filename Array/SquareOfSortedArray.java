package Array;

import java.util.Arrays;
import java.util.Scanner;

public class SquareOfSortedArray {
	public void sort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			var current = array[i];
			var j = i - 1;
			while(j >= 0 && Math.abs(array[j]) > Math.abs(current)) {
				array[j + 1] = array[j];
				j--; 
			}
			array[j + 1] = current;
		}
	}
public void square(int[] array) {
	sort(array);
	for ( int i = 0; i < array.length; i++) {
		array[i] = (int ) Math.pow(array[i],2);
	}
}


public static void main(String[] args) {
	int[] numbers = {2,3,10, -22, -4, 8};
	var sorter = new SquareOfSortedArray();
	sorter.square(numbers);
	System.out.println(Arrays.toString(numbers));
}

}



//public int[] sortedSquares(int[] nums) {
//    int[] a = new int[nums.length];
//    for (int i = 0; i < nums.length; i++)
//        a[i] = nums[i] * nums[i];
//    Arrays.sort(a);
//    return a;
//}
//	


//                binary search
//public int[] sortedSquares(int[] nums) {
//    int len = nums.length;
//    int[] ans = new int[len];
//      
//    int left = 0;
//    int right = len - 1;
//    int index = len - 1;
//    
//    while (index >= 0) {
//      if (Math.abs(nums[left]) < Math.abs(nums[right])) {
//        ans[index--] = nums[right] * nums[right];
//        right--;
//      } else {
//        ans[index--] = nums[left] * nums[left];
//        left++;
//      }
//    }
//    
//    return ans;
//  }