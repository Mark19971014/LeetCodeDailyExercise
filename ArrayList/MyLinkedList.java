package ArrayList;

public class MyLinkedList {

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}
	private Node head;
    private Node tail;
    private int size;
	/** Initialize your data structure here. */
	    public MyLinkedList() {
	    	this.head = this.tail = null;
	        this.size = 0;
	    }

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (index >= size) {
			return -1;
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.value;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node adding = new Node(val);
		if (head == null) {
			adding = head = tail;
		} else {
			adding.next = head;
			head = adding;
			size++;
		}

	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		Node adding = new Node(val);
		if (tail == null) {
			adding = head = tail;
		} else {
			tail.next = adding;
			tail = adding;
			size++;
		}

	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index > size) {
			return;
		}
		if (index == 0) {
			addAtHead(val);
		} else if (index == size) {
			addAtTail(val);
		} else {
			Node adding = new Node(val);
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			adding.next = current.next;
			current.next = adding;
			size++;
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index >= size) {
			return;
		}
		if (index == 0) {
			head = head.next;
		} else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			current.next = current.next.next;
		}
		size--;
	}
}
