package LinkedLists;

public class MaximumSumList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List1 
		ListNode node7_1 = new ListNode(511, null);
		ListNode node6_1 = new ListNode(240, node7_1);
		ListNode node5_1 = new ListNode(120, node6_1);
		ListNode node4_1 = new ListNode(90, node5_1);
		ListNode node3_1 = new ListNode(30, node4_1);
		ListNode node2_1 = new ListNode(3, node3_1);
		ListNode node1_1 = new ListNode(1, node2_1);
		
		//List2
		ListNode node8_2 = new ListNode(249, null);
		ListNode node7_2 = new ListNode(240, node8_2);
		ListNode node6_2 = new ListNode(125, node7_2);
		ListNode node5_2 = new ListNode(90, node6_2);
		ListNode node4_2 = new ListNode(32, node5_2);
		ListNode node3_2 = new ListNode(12, node4_2);
		ListNode node2_2 = new ListNode(3, node3_2);
		ListNode node1_2 = new ListNode(0, node2_2);
		
		MaximumSumListClass obj = new MaximumSumListClass();
		obj.printList(node1_1);
		obj.printList(node1_2);
		ListNode n = obj.maximumSumList(node1_1, node1_2);
		obj.printList(n);
	}

}


class MaximumSumListClass {
	
	public ListNode maximumSumList(ListNode start1, ListNode start2) {
		int sum1 = 0, sum2 = 0;
		ListNode curr1 = start1, curr2 = start2;
		ListNode nodeToReturn = null;
		ListNode commonNode1 = start1, commonNode2 = start2;
		ListNode lastNode = null;
		
		while (curr1 != null && curr2 != null) {
			if (curr1.value < curr2.value) {
				sum1 = sum1 + curr1.value;
				curr1 = curr1.next;
			} else if (curr1.value > curr2.value) {
				sum2 = sum2 + curr2.value;
				curr2 = curr2.next;
			} else {
				if (sum1 > sum2) {
					if (nodeToReturn == null) {
						nodeToReturn = start1;
					} else {
						lastNode.next = commonNode1.next;
					}
					lastNode = commonNode1;
				} else {
					if (nodeToReturn == null) {
						nodeToReturn = start2;
					} else {
						lastNode.next = commonNode2.next;
					}
					lastNode = commonNode2;
				}
				
				sum1 = sum2 = 0;
				commonNode1 = curr1;
				commonNode2 = curr2;
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
		}
		
		return nodeToReturn;
	}
	
	public void printList(ListNode start) {
		while (start != null) {
			System.out.print(start.value + "-->");
			start = start.next;
		}
		System.out.println("null");
	}
}