package Trees;

import java.util.Stack;

public class InorderWithoutRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node9 = new Node(9, null, null);
		Node node7 = new Node(7, null, null);
		Node node8 = new Node(8, node7, node9);
		Node node1 = new Node(1, null, null);
		Node node3 = new Node(3, null, null);
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, node3, node5);
		Node node2 = new Node(2, node1, node4);
		Node node6 = new Node(6, node2, node8);
		
		InorderWithoutRecursionClass obj = new InorderWithoutRecursionClass();
		obj.inorder(node6);
	}

}

class InorderWithoutRecursionClass {
	Stack<Node> stack;
	
	public InorderWithoutRecursionClass() {
		stack = new Stack<Node>();
	}
	
	public void inorder(Node root) {
		Node current = root.left;
		stack.push(root);
		
		while (!stack.isEmpty() || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				Node poppedItem = stack.pop();
				System.out.print(poppedItem.value + " ");
				if (poppedItem.right != null) {
					current = poppedItem.right;
				}
			}
		}
	}
}