package Tree;

import java.util.List;

import javax.swing.tree.TreeNode;

public class Preorder {
	 
	 public List<Integer> preorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList());
    }
   
    private List<Integer> dfs(TreeNode root, List<Integer> List){
        if(root == null){
             return List;
        }
         List.add(root.val);
          dfs(root.left,List);
       return dfs(root.right,List);
            
    }
}
