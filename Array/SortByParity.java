package Array;

import java.util.Arrays;

public class SortByParity {
	public static int[] sortArrayByParity(int[] A) {
		int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;

	}
	
	
	
	 public int[] inPlace(int[] A) {
	        int i = 0, j = A.length - 1;
	        while (i < j) {
	            if (A[i] % 2 > A[j] % 2) {
	                int tmp = A[i];
	                A[i] = A[j];
	                A[j] = tmp;
	            }

	            if (A[i] % 2 == 0) i++;
	            if (A[j] % 2 == 1) j--;
	        }

	        return A;
	    }
	public static void main(String[] args) {
		int[] num = { 0, 1, 3, 0, 12 ,0,9};
		System.out.println(Arrays.toString(sortArrayByParity(num)));
	}
}
