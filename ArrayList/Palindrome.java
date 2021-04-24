package ArrayList;

public class Palindrome {
	class ListNode {
		ListNode next;
		int val;

		public ListNode(int value) {
			this.val = value;
		}
	}

	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && slow != null) {
			fast = fast.next;
			if (fast.next == null) {
				reverse(fast);
				slow = slow.next;
				if (slow.val == fast.val) {
					return true;
				}
			}
		}

		return false;
	}
	public ListNode reverse(ListNode fast) {
		ListNode pointer = fast;
		pointer = reverse(fast.next);
		fast.next.next = fast;
		fast.next = null;
		return pointer;
	}
}
