package Array;

import java.util.Scanner;

public class Consecutive1s {
	public static int findMaxConsecutiveOnes(int[] numbers) {
		int count = 0;
		int max = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				count = 0;
			}else {
				count ++;
				max = Math.max(max, count);
			}
			
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] numbers = new int[size];
		for (int currentIndex = 0; currentIndex < size; currentIndex++) {
			numbers[currentIndex] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(findMaxConsecutiveOnes(numbers));
	}

}
