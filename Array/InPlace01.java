package Array;

import java.util.Arrays;

public class InPlace01 {
	public int[] replaceElement(int[] arr) {
		int initialMax = -1;
		for(int i = arr.length - 1; i >= 0; i--) {
			
			
			
			int newMax = Math.max(initialMax, arr[i]);
			arr[i] = newMax;
			initialMax = newMax;
		}
		
		return arr;
	}
	
	public int[] replaceElements(int[] arr) {
		int Index = 0;
		int MaxIndex = 1;
		
		for (int i = 1; i < arr.length; i++) {
			// search the max value in the rest of the array
			// assign the arr[index] = max
			if (arr[MaxIndex] <= arr[i]) {
				arr[MaxIndex] = arr[i];
				arr[Index++] = arr[MaxIndex++];
				
				
			}else {
				arr[Index] = arr[i];
			}
			// if index = length, arr[index] = -1
			if (Index == arr.length) {
				arr[Index] = -1;
			}

		}

		return arr;
	}

	public int[] replaceRightElement(int[] arr) {
			
		for(int i = 0; i<arr.length; i++) {
			int max = 0;
			for(int j = i + 1; j<arr.length;j++) {
				if(max<arr[j]) {
					max = arr[j];
				}
			}
				arr[i] = max;
			
		}
			arr[arr.length-1] = -1;
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = { 20, 19, 5, 4, 6, 1 };
		var montain = new InPlace01();
		System.out.println(Arrays.toString(montain.replaceRightElement(arr)));

	}
}

/*[18, 18, 5, 4, 6, 1]
 * [18, 5, 4, 6, 1, 1]
 *
 * Input: arr = [17,18,5,4,6,1] Output: [18,6,6,6,1,-1]
 */