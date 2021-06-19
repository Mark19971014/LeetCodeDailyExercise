package Tree;

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
			if (val <= current.val) {
				if (current.leftChild == null) {
					current.leftChild = node;
					break;
				}
			} else {
				if (current.rightChild == null) {
					current.rightChild = node;
					break;
				}
			}
		}
	}
	
	public boolean find(int value) {
		var current = root;
		while(current != null) {
			if (current.val > value) {
				current = current.leftChild;
			}else if(current.val < value) {
				current = current.rightChild;
			}else
				return true;
			}
			return false;
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(10);
		tree.insert(8);
		tree.insert(34);
		tree.insert(46);
		System.out.println(tree.find(1));
	}
}

