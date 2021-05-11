package ArrayList;

public class AddTwoNumber {
	class ListNode{
		ListNode next;
		int val;
		public ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode dummy = new ListNode(0);
	        ListNode newhead = dummy;
	        
	        int carry = 0;
	        while (l1 != null || l2 != null) {
	        	int l1_val = (l1 != null) ? l1.val : 0;
	            int l2_val = (l2 != null) ? l2.val : 0;
	        	int current_sum = l1_val + l2_val + carry;
	            carry = current_sum / 10;
	            int last_digit = current_sum % 10;
	            ListNode NewNode = new ListNode(last_digit);
	            newhead.next = NewNode;
	        	
	            if(l1 != null) l1 = l1.next;
	            if(l2 != null) l2 = l2.next;
	        	newhead = newhead.next;	
	        }
	      
	        if(carry > 0){
	           ListNode node = new ListNode(carry);
	           newhead.next = node;
	           newhead = newhead.next;
	       }
	        return dummy.next;
	    }
	        
}
