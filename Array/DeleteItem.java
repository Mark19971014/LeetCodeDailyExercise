package Array;

public class DeleteItem {
	public int removeElement(int[] nums, int val) {
		if (nums.length == 0)
			return 0;
		int valid_size = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[valid_size] = nums[i];
				valid_size++;
			}
		}
		return valid_size;

	}
	public int removeElements(int[] nums, int val) {
	    int i = 0;
	    int n = nums.length;
	    while (i < n) {
	        if (nums[i] == val) {
	            nums[i] = nums[n - 1];
	            // reduce array size by one
	            n--;
	        } else {
	            i++;
	        }
	    }
	    return n;
	}
}
/*
 * public int[] delete(int[] array, int val) { int[] valarray = new
 * int[array.length-1]; int index = 0; for (int i = 0; i < array.length; i++) {
 * if (array[i] == val) { if(index < array.length -1) valarray[index++] =
 * array[i]; array[i] = array[i + 1]; } } return array; }
 * 
 * public static void main(String[] args) { int[] numbers = { 2, 3, 10, -22, -4,
 * 8, 3 }; var java = new DeleteItem(); java.delete(numbers, 3);
 * System.out.println(java.delete(numbers, 3));
 * 
 * }
 */