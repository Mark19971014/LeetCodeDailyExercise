package Tree;

import java.util.List;

public class MinBST {
	 public static BST minHeightBst(List<Integer> array) {
		    // Write your code here.
		    return minHeightBst(array, null, 0, array.size() - 1);
		  }
		public static BST minHeightBst(List<Integer> array , BST bst, int start, int end){
			if (end < start) return null;
			int mid = (start + end ) / 2;
			int val = array.get(mid);
			if (bst == null){
			 bst = new BST(val);
			}else{
				bst.insert(val);
			}
			minHeightBst(array, bst , start, mid - 1);
			minHeightBst(array, bst, mid + 1, end);
			return bst;
		}
			
		  static class BST {
		    public int value;
		    public BST left;
		    public BST right;

		    public BST(int value) {
		      this.value = value;
		      left = null;
		      right = null;
		    }

		    public void insert(int value) {
		      if (value < this.value) {
		        if (left == null) {
		          left = new BST(value);
		        } else {
		          left.insert(value);
		        }
		      } else {
		        if (right == null) {
		          right = new BST(value);
		        } else {
		          right.insert(value);
		        }
		      }
		    }
		  }
}
