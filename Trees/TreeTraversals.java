package Trees;

import java.util.LinkedList;

public class TreeTraversals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node7 = new Node(7, null, null);
		Node node6 = new Node(6, null, null);
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, null);
		Node node3 = new Node(3, node6, node7);
		Node node2 = new Node(2, node4, node5);
		Node node1 = new Node(1, node2, node3);
		
		System.out.println("Inorder");
		inorder(node1);
		System.out.println();
		System.out.println("preorder");
		preorder(node1);
		System.out.println();
		System.out.println("postorder");
		postorder(node1);
		System.out.println();
		System.out.println("Level order or breadth first order");
		breadthFirstSearchTraversal(node1);
		
	}
	
	public static void inorder(Node root) {
		if (root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}
	
	public static void preorder(Node root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.value + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void postorder(Node root) {
		if (root == null) {
			return;
		}
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.value + " ");
	}
	
	public static void breadthFirstSearchTraversal(Node root) {
		LinkedList<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node obj = queue.getFirst();
			if (obj.left != null) {
				queue.add(obj.left);
			}
			if (obj.right != null) {
				queue.add(obj.right);
			}
			System.out.print(obj.value + " ");
			queue.remove(0);
		}
		System.out.println();
	}

}
