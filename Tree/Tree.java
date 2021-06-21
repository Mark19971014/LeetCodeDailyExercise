package Tree;

import java.util.ArrayList;

public class Tree {
	private class Node {
		private Node leftChild;
		private Node rightChild;
		private int val;

		public Node(int val) {
			this.val = val;
		}

		public String toString() {
			return "Node = " + val;
		}
	}

	private Node root;

	public void insert(int val) {
		Node node = new Node(val);
		if (root == null) {
			root = node;
			return;
		}
		var current = root;
		while (true) {
			if (val < current.val) {
				if (current.leftChild == null) {
					current.leftChild = node;
					break;
				}
				current = current.leftChild;
			} else {
				if (current.rightChild == null) {
					current.rightChild = node;
					break;
				}
				current = current.rightChild;
			}
		}
	}

	public boolean find(int value) {
		var current = root;
		while (current != null) {
			if (current.val > value) {
				current = current.leftChild;
			} else if (current.val < value) {
				current = current.rightChild;
			} else
				return true;
		}
		return false;
	}

	public void traversePreorder() {
		traversePreorder(root);
	}

// root left right
	private void traversePreorder(Node root) {
		if (root == null)
			return;
		System.out.println(root.val);
		traversePreorder(root.leftChild);
		traversePreorder(root.rightChild);

	}

	public void traverseInorder() {
		traversePreorder(root);
	}

// left root right
	private void traverseInorder(Node root) {
		if (root == null)
			return;
		traversePreorder(root.leftChild);
		System.out.println(root.val);
		traversePreorder(root.rightChild);

	}

	public void traversPostorder() {
		traversePreorder(root);
	}

// left right root
	private void traversePostorder(Node root) {
		if (root == null)
			return;
		traversePreorder(root.leftChild);
		traversePreorder(root.rightChild);
		System.out.println(root.val);

	}

	public int height() {
		return height(root);
	}

	private int height(Node root) {
		if(root == null)
			return -1;
		
		if (isLeaf(root)) {
			return 0;
		}

		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}

	public int min() {
		if (root == null) {
			throw new IllegalStateException();
		}
		var current = root;
		var last = current;
		while (current != null) {
			last = current;
			current = current.leftChild;
		}
		return last.val;
	}

	private boolean isLeaf(Node node) {
		return root.leftChild == null && root.rightChild == null;
	}

	private int min(Node root) {
		if (isLeaf(root)) {
			return root.val;
		}
		var left = min(root.leftChild);
		var right = min(root.rightChild);
		return Math.min(Math.min(left, right), root.val);
	}

	public boolean equals(Tree other) {
		if (other == null)
			return false;
		return equals(root, other.root);
	}

// preorder
	private boolean equals(Node first, Node second) {
		if (first == null && second == null) {
			return true;
		}
		if (first != null && second != null) {
			return first.val == second.val && equals(first.leftChild, second.leftChild)
					&& equals(first.rightChild, second.rightChild);

		}
		return false;
	}

	public boolean isBinarySearchTree() {
		if (root == null)
			return false;
		return isBinarySearchTree(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBinarySearchTree(Node root, int min, int max) {
		if (root == null)
			return true;
		if (root.val > max || root.val < min) {
			return false;
		}
		return 
			   isBinarySearchTree( root.leftChild, min, root.val -1)&&
			   isBinarySearchTree( root.rightChild,root.val + 1 , max);
	}
	
	public void swapRoor() {
		var temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;
	}

	public ArrayList<Integer> printNodeAtDistance(int distance) {
		var list = new ArrayList<Integer>();
		printNodeAtDistance(root, distance,list);
		return list;
	}
	
	private void printNodeAtDistance(Node root,int distance,ArrayList<Integer> list) {
		if (root == null)
			return;
		if (distance == 0) {
			list.add(root.val);
		return;
		}
		
		printNodeAtDistance(root.leftChild,distance - 1, list);
		printNodeAtDistance(root.rightChild,distance - 1, list);
	}

	public void levelOrderTraverse() {
		for (int i = 0;i <= height(); i ++) {
			for ( var value :  printNodeAtDistance(i)) {
				System.out.println(value);
			}
		}
		
	}

}
