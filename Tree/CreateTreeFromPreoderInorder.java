package Tree;

import java.util.HashMap;
import java.util.Map;

import Tree.SymmetricTree.TreeNode;

public class CreateTreeFromPreoderInorder {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	 
	    
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
	}

	public TreeNode helper(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft,
			int inRight) {
		if (preLeft > preRight || inLeft > inRight)
			return null;
		int rootval = preorder[preLeft];
		TreeNode root = new TreeNode(rootval);
		int rootIndex = map.get(rootval);

		root.left = helper(preorder, preLeft + 1, rootIndex + preLeft - inLeft, map, inLeft, rootIndex - 1);
		root.right = helper(preorder, rootIndex + preLeft - inLeft + 1, preRight, map, rootIndex + 1, inRight);
		return root;

	}
}
