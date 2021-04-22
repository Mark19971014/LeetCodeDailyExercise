package Array;

import java.util.Arrays;

public class DuplicateZeroTest {
	public static void main(String[] args) {
		int[] numbers = { 2, 0, 10, -22, 0, 0 };
		var duplicater = new DuplicateZeroTest();
		duplicater.duplicateZeros(numbers);
		System.out.println(Arrays.toString(numbers));
	}
	
	public void duplicateZeros(int[] arr) {
	int[] newarray = new int[arr.length];
	int index = 0;
	
	for (int i = 0; i < arr.length; i++) {
		newarray[index++] = arr[i];
		
		if (arr[i] == 0) {
			if (index < arr.length) {
				newarray[index] = arr[i];
				index++;
			}
		}
		
		if (index >= arr.length) {
			break;
		}
	}
	for (int i = 0; i < arr.length; i++) {
		arr[i] = newarray[i];
	}
	}
}
