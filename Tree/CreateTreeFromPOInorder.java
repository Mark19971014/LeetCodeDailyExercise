package Tree;

import java.util.HashMap;
import java.util.Map;

public class CreateTreeFromPOInorder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
       return helper(postorder, 0 , postorder.length - 1 , map, 0, inorder.length - 1);
    }
    public TreeNode helper( int[] postorder, int poLeft, int poRight, Map<Integer, Integer> map, int inLeft, int inRight){
        if (poLeft > poRight || inLeft > inRight) return null;
         
        int rootVal = postorder[poRight];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex  = map.get(rootVal);
 root.left = helper(postorder, poLeft, poLeft + rootIndex -inLeft -1, map, inLeft, rootIndex -1);  
	        root.right =helper(postorder,  poLeft + rootIndex - inLeft, poRight - 1, map , rootIndex + 1 , inRight); 
        return root;
    };
}
