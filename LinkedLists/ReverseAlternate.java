package LinkedLists;

public class ReverseAlternate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ListNode node7 = new ListNode(511, null);
		ListNode node6 = new ListNode(20, null);
		ListNode node5 = new ListNode(18, node6);
		ListNode node4 = new ListNode(16, node5);
		ListNode node3 = new ListNode(14, node4);
		ListNode node2 = new ListNode(12, node3);
		//ListNode node1 = new ListNode(1, node2);
		
		reverseAlternateClass obj = new reverseAlternateClass();
		ListNode list = obj.reverseAlternate(node2);
		obj.printList(list);
	}

}

class reverseAlternateClass {
	
	public ListNode reverseAlternate(ListNode start) {
		ListNode odd = start;
		ListNode even = start.next;
		ListNode curr1 = odd, curr2 = even;
		
		while (curr1 != null && curr2 != null) {
			curr1.next = curr2.next;
			curr1 = curr1.next;
			if (curr1 != null) {
				curr2.next = curr1.next;
				curr2 = curr2.next;
			}
		}
		printList(odd);
		printList(even);
		
		ListNode reversedEvenList = reverse(even);
		ListNode temp = odd;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = reversedEvenList;
		return odd;
	}
	
	public void printList(ListNode start) {
		while (start != null) {
			System.out.print(start.value + " --> ");
			start = start.next;
		}
		System.out.println("null");
	}
	
	public ListNode reverse(ListNode start) {
		ListNode prev = null;
		ListNode current = start;
		ListNode nextNode = null;
		
		while (current != null) {
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		
		return prev;
	}
}