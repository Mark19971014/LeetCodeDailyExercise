package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class zigzag {
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
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> result = new LinkedList<>();

			if (root == null)
				return result;

			int round = 0;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> level = new LinkedList<>();

				for (int i = 0; i < size; i++) {
					TreeNode cur = queue.poll();

					if (round % 2 == 0) {
						level.add(cur.val);
					} else {
						level.add(0, cur.val);
					}
					if (cur.left != null) {
						queue.add(cur.left);
					}

					if (cur.right != null) {
						queue.add(cur.right);
					}
				}
				result.add(level);
				round += 1;

			}
			return result;
		}
	
		public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
	        //Final list to return
	        List<List<Integer>> toReturn = new ArrayList<>();
	        Queue<TreeNode> q = new LinkedList<>();
	        if (root == null)
	            return new ArrayList<>();
	        //Let's kick off the BFS by adding the root to the queue
	        q.add(root);
	        //Starting with the direction =1 (left to right)
	        boolean normal_direction = true;
	        //As long as our queue is not empty keep going
	        while (!q.isEmpty()){
	            int size = q.size();
	            List<Integer> level = new ArrayList<>();
	            //Loop through each level
	            for(int i =0; i<size; i++){
	                TreeNode pop = q.poll();
	                level.add(pop.val);
	                
	                if(pop.left != null)
	                    q.add(pop.left);
	                   if(pop.right!=null)
	                    q.add(pop.right);
	                        }
	            //After we have looped through the specific level, let's check if we are adding in normal or reverse direction
	                if(!normal_direction){
	                    //Reverse the level if we are going in opposite direction and add it to the final list
	                    Collections.reverse(level);
	                    toReturn.add(level);
	                }
	                else
	                    //Else just add the level in normal direction
	                    toReturn.add(level);
	            normal_direction = !normal_direction;
	            }
	        return toReturn;
	    }

}
