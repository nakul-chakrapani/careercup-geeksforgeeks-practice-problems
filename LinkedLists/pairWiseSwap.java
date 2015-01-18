package LinkedLists;

public class pairWiseSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node7 = new ListNode(7, null);
		ListNode node6 = new ListNode(6, node7);
		ListNode node5 = new ListNode(5, node6);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		
		pairWiseSwapClass obj = new pairWiseSwapClass(node1);
		ListNode p = obj.pairWiseSwap(obj.curr1, obj.curr2);
		obj.printList(p);
	}

}

class pairWiseSwapClass {
	
	public ListNode start;
	public ListNode curr1, curr2;
	
	public pairWiseSwapClass(ListNode start) {
		this.start = start;
		this.curr1 = start;
		if (start != null) {
			this.curr2 = start.next;
		}
	}
	
	public ListNode pairWiseSwap(ListNode curr1, ListNode curr2) {
		if (curr1 == null && curr2 == null) {
			return null;
		}
		
		if (curr2 == null) {
			return curr1;
		}
		
		ListNode swappedList, new_curr1=null, new_curr2=null;
		if (curr2 != null) {
			new_curr1 = curr2.next;
			if (curr2.next != null) {
				new_curr2 = curr2.next.next;
			}
		}
		
		swappedList = pairWiseSwap(new_curr1, new_curr2);
		curr1.next = swappedList;
		curr2.next = curr1;
		return curr2;
	}
	
	public void printList(ListNode start) {
		while (start!= null) {
			System.out.print(start.value + "-->");
			start = start.next;
		}
		
		System.out.println("null");
	}
}
