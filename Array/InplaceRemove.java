package Array;

public class InplaceRemove {
public static int removeElement(int[] nums, int val) {
        int length = 0;
        int index = 0;
        for (int i = 0; i<nums.length; i++) {
        	if(nums[i] != val) {
        		nums[index++] = nums[i];
        		length++;
        	}
        }
  
        return length;
    }

public static void main(String[] args) {
	int[] nums = {3,2,2,3};
	System.out.println(removeElement(nums, 3));
}

}
