package SortLeetCode;

public class Sort {
	public int[] bubbleSort(int[] array) {
		for (int j = 0; j < array.length; j++) {
			for (int i = 1; i < array.length; i++) {

				if (array[i] < array[i - 1]) {
					var temp = array[i];
					array[i] = array[i - 1];
					array[i - 1] = temp;
				}
			}
		}

		return array;
	}

	public int[] selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					swap(array, minIndex, j);
				}

			}
		}
		return array;
	}

	private void swap(int[] array, int minIndex, int j) {
		var temp = array[minIndex];
		array[minIndex] = array[j];
		array[j] = temp;

	}

	public int[] insertionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int curr = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > curr) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = curr;
		}
		return array;
	}

	public void mergeSort(int[] array) {
		// divide the array
		// find the smallest item
		// merge it
		if (array.length < 2) {
			return;
		}
		int mid = array.length / 2;
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		for (int j = mid; j < array.length; j++) {
			right[j - mid] = array[j];
		}
		mergeSort(left);
		mergeSort(right);

		merge(left, right, array);

	}

	private void merge(int[] left, int[] right, int[] array) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j])
				array[k++] = left[i++];
			else
				array[k++] = right[j++];
		}

		while (i < left.length)
			array[k++] = left[i++];

		while (j < right.length)
			array[k++] = right[j++];

	}

}
