package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class leftPointToRight {

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public Node connect(Node root) {
	        if (root == null) return null;
	        if (root.left == null && root.right == null) return root;
	        Queue<Node> queue = new LinkedList<>();
	        queue.add(root);
	        queue.add(null);
	        while(!queue.isEmpty()){
	        Node curr = queue.poll();
	            if(curr != null){
	                curr.next = queue.peek();
	            if (curr.left != null) {
	                queue.add(curr.left);
	            }if (curr.right != null){
	                queue.add(curr.right);
	            }
	        } else{
	                if(queue.isEmpty()){
	                    break;
	                }
	                queue.add(null);
	            }
	        }
	        return root;
	    }
}
