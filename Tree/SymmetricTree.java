package Tree;

import Tree.SameTree.TreeNode;

public class SymmetricTree {

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

	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null)
			return true;
		if (leftNode == null || rightNode == null)
			return false;
		return (leftNode.val == rightNode.val) && isSymmetric(leftNode.right, rightNode.left)
				&& isSymmetric(leftNode.left, rightNode.right);
	}
}
