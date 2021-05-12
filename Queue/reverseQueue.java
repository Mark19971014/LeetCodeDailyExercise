package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class reverseQueue {
	public static void reverse(Queue<Integer> queue ) {
		Stack<Integer> stack = new Stack<Integer>();
		while(!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		reverse(queue);
		System.out.println(queue);

		
	}

}
