package ArrayList;

import java.util.HashSet;
import java.util.Set;

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}

}


public class HasCycle {
	public boolean cycleChecker(ListNode head) {
		Set<ListNode> checker = new HashSet<ListNode>();
		while (head != null) {
			if (checker.contains(head)) {
				return true;
			}
			checker.add(head);
			head = head.next;
		}
		return false;
	
	}
	public boolean hascycle(ListNode head) {
		if (head == null){
			return false;
		}
		ListNode slower = head;
		ListNode faster = head.next;
		while (head != null || slower != faster) {
			if (faster == null || faster.next == null) {
				return false;
			}

			slower = head.next;
			faster = head.next.next;
		}
		return true;
	}
}
