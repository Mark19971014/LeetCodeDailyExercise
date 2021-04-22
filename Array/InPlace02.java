package Array;

import java.util.Arrays;

public class InPlace02 {
	public int removeDuplicate(int[] arr) {
		int length = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[length] != arr[i]) {
				length++;
			}
		}
		return length;	
	}
	
	
	public int removeDuplicte(int[] arr1) {
		int index = 1;
		for(int i = 0; i<arr1.length - 1; i++) {
			if(arr1[i] != arr1[i+1]) {
				arr1[index++] = arr1[i+1];
			}
		}
		return index;
	}
	public static void main(String[] args) {
		int[] set = {1,2,2,3,4,5,5,5,5,6,7};
		var num = new InPlace02();
		System.out.println((num.removeDuplicate(set)));
	}

}
