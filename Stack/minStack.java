package Stack;

public class minStack {

	private node head;

	public void push(int x) {
		if (head == null) {
			head = new node(x, x);
		} else {
			head = new node(x, Math.min(x, head.min), head);
		}
	}

	public void pop() {
		head = head.next;
	}

	public int top() {
		return head.val;
	}

	public int getMin() {
		return head.min;
	}

	class node {
		int val;
		int min;
		node next;

		public node(int val, int min) {
			this(val,min,null);

		}

		private node(int val, int min, node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}
}
