package LinkedLists;

public class ListNode {
	int value;
	ListNode next;
	
	public ListNode(int value, ListNode next) {
		this.value = value;
		this.next = next;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public ListNode getNext() {
		return this.next;
	}
}
