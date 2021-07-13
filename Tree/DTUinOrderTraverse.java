package DTU;

import java.util.ArrayList;
import java.util.List;

public class DTUinOrderTraverse {
	class TreeNode {
		private TreeNode leftChild;
		private TreeNode rightChild;
		private int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public List<Integer> inorderTraverse(TreeNode root) {
		List<Integer> tree = new ArrayList<>();
		inorder(root, tree);
		return tree;
	}

	private void inorder(TreeNode root, List<Integer> tree) {
		if (root == null) {
			return;
		} else {
			if (root.leftChild != null) {
				inorder(root.leftChild, tree);
			}
		}
		tree.add(root.val);
		if (root.rightChild != null) {
			inorder(root.rightChild, tree);
		}
	}
}
