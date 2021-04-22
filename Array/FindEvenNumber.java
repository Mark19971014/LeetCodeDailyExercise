package Array;

import java.util.Scanner;

public class FindEvenNumber {
//	public static int findEvenNumber(int[] numbers) {
//		int count = 0;
//		int result = 0;
//		for (int number : numbers) {
//			while (number != 0) {
//				number /= 10;
//				count++;
//			}
//			if (count % 2 == 0)
//				result++;
//		}
//		return result;
//	}

	
	public static int findNumbers(int[] nums) {
        int c=0;
        for(Integer i:nums){
            String r=Integer.toString(i);
            if(r.length()%2==0)
                c++;
        }
        return c;
        
    }
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] numbers = new int[size];
		for (int currentIndex = 0; currentIndex < size; currentIndex++) {
			numbers[currentIndex] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(findNumbers(numbers));
	}

}
