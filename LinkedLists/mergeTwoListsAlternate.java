package LinkedLists;

public class mergeTwoListsAlternate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode node5 = new ListNode(11, null);
//		ListNode node4 = new ListNode(13, node5);
		ListNode node3 = new ListNode(3, null);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		
		ListNode node5_1 = new ListNode(8, null);
		ListNode node4_1 = new ListNode(7, node5_1);
		ListNode node3_1 = new ListNode(6, node4_1);
		ListNode node2_1 = new ListNode(5, node3_1);
		ListNode node1_1 = new ListNode(4, node2_1);
		
		mergeTwoListsAlternateClass obj = new mergeTwoListsAlternateClass();
		obj.mergeAlternate(node1, node1_1);
	}

}

class mergeTwoListsAlternateClass {
	
	public void mergeAlternate(ListNode start1, ListNode start2) {
		ListNode curr1 = start1;
		ListNode p;
		
		while (curr1 != null && start2 != null) {
			p = curr1.next;
			curr1.next = start2;
			start2 = start2.next;
			curr1.next.next = p;
			curr1 = p;
		}
		
		System.out.println("First List");
		printList(start1);
		System.out.println("Second List");
		printList(start2);
		
	}
	
	public void printList(ListNode start) {
		while (start != null) {
			System.out.print(start.value + " --> ");
			start = start.next;
		}
		System.out.println("null");
	}
}
