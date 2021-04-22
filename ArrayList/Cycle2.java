package ArrayList;

import java.util.HashSet;
import java.util.Set;

public class Cycle2 {
	class Node{
		Node next;
		int data;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        	while(head != null) {
        		if(set.contains(head)) {
        			return head;
        		}
        		set.add(head);
        		head = head.next;
        	}
    
        	return null;
	
	}
}
