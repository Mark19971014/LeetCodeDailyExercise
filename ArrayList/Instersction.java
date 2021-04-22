package ArrayList;

import java.util.HashSet;
import java.util.Set;

public class Instersction {
	class ListNode{
		ListNode next;
		int value;
		public ListNode(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	
	
	 public ListNode getIntersectionNodeHashSet(ListNode headA, ListNode headB) {
	     Set<ListNode> set = new HashSet<>();
	     
		 while(headA != null  ) {
			 set.add(headA);
			 headA = headA.next;
		 }while(headB != null) {
			 
			if (set.contains(headB)) {
		    	 return headB;
		     }	
			 headB = headB.next;
		 
		 }
		 
		 return null;
	        
	    }

	 public ListNode getIntersectionNodeTwoPointer(ListNode headA, ListNode headB) {
	        if (headA == null || headB == null){
	            return null;
	        }
	                ListNode pointerA = headA;
	                ListNode pointerB = headB;
		        while(pointerA != pointerB){
	                if (pointerA == null){
	                    pointerA = headB;
	                }else{
	                    pointerA = pointerA.next;
	                }
	            if (pointerB == null){
	                    pointerB = headA;
	                }else{
	                    pointerB = pointerB.next;
	                }
	            }
	        return pointerA;
	    }

}
