package Tree;

import java.util.List;

import javax.swing.tree.TreeNode;

public class Preorder {
	 
	
	public List<Integer> preorderTraversal(TreeNode root) {
	        return preOrderTraversal(root); 
	    }
	    
	    private void preOrderTraversal(TreeNode root){
	        if (root == null){
	            return;
	        }System.out.println(root.val);
	        preOrderTraversal(root.left);
	        preOrderTraversal(root.right);
	    }
}
