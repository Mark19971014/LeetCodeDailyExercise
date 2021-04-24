package ArrayList;

public class Reverse {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }

	public ListNode reverseList(ListNode head) {
        ListNode temp = new ListNode();
        while(head != null && head.next != null ) {
        	temp = head;
        	head = head.next;
        	head.next = temp;
        	
        }
        return head;
	}
}
