package Array;

import java.util.Arrays;

public class DuplicateZero {
	public static void main(String[] args) {
		int[] numbers = { 2, 0, 10, -22, 0, 8 };
		var duplicater = new DuplicateZero();
		duplicater.duplicateZeros(numbers);
		System.out.println(Arrays.toString(numbers));
	}

	public void duplicateZeros(int[] arr) {
		int[] newarry = new int[arr.length];
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			newarry[index++] = arr[i];

			if (arr[i] == 0) {
				if (index < arr.length) {
					newarry[index] = arr[i];
					index++; 
				}
			}

			if (index >= arr.length) {
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = newarry[i];
		}
	}

}
