package Tree;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.MaxDepth.TreeNode;

public class LevelOrderII {
	 
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
	
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        
	        List<List<Integer>>  allResult = new LinkedList<>();
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        if(root == null) return allResult;
	        while (!queue.isEmpty()){
	        	List<Integer> levelResult = new LinkedList<>();
	            int size = queue.size();
	            for (int i = 0; i < size; i++){
	                TreeNode cur = queue.poll();
	                if(cur.left != null) {
	                    queue.add(cur.left);
	                    
	                }
	                if (cur.right != null){
	                    queue.add(cur.right);
	                }
	                levelResult.add(cur.val);
	            }
	            
	           
	           allResult.add(0, levelResult);
	        }
	        
	        return allResult;
	    }
}
