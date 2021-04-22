package Array;

import java.util.Arrays;

public class MergeSortedArray {
	
	public static void main(String[] args) {
		int[] numb = {1 ,2 ,3 ,4 ,5};
		int temp;
		temp = numb[1];
		numb[1] = numb[4];
		numb[4] = temp;
		System.out.println(Arrays.toString(numb));
		
		
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		m--; n--;
		int index = nums1.length - 1;
		while(index >= 0) {
			if (m < 0) {
				nums1[index] = nums2[n--];
			}else if (n < 0) {
				nums1[index] = nums1[m--];
			}else {
				if (nums1[m] > nums2[n]) {
					nums1[index] = nums1[m--];
				}else {
					nums1[index] = nums2[n--];
				}
			}
			index--;
		}
	}
}
/*
 * 
 * public void merge(int[] nums1, int m, int[] nums2, int n) { int nums1Lidx =
 * m-1; int nums2Lidx = n-1; int mergedIdx = m+n-1;
 * 
 * while(nums2Lidx >= 0) { if(nums1Lidx >= 0 && nums1[nums1Lidx] >
 * nums2[nums2Lidx]){ nums1[mergedIdx] = nums1[nums1Lidx]; nums1Lidx--; } else{
 * nums1[mergedIdx] = nums2[nums2Lidx]; nums2Lidx--; } mergedIdx--; }
 * 
 * } }
 * 
 * 
 */

