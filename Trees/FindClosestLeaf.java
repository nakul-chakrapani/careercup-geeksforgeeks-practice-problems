package Trees;

import java.util.HashMap;

public class FindClosestLeaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node node10 = new Node(10, null, null);
		Node node9 = new Node(9, null, null);
		Node node8 = new Node(8, null, null);
		Node node7 = new Node(7, node10, null);
		Node node6 = new Node(6, node8, node9);
		Node node5 = new Node(5, null, node7);
		Node node4 = new Node(4, node6, null);
		Node node3 = new Node(3, node4, node5);
		Node node2 = new Node(2, null, null);
		Node node1 = new Node(1, node2, node3);
		
		findClosestLeafClass obj = new findClosestLeafClass(node1);
		Node key = obj.findKey(node1, 2);
		int min = obj.findClosestDownLeaf(key, 0);
		System.out.println(obj.findClosestUpLeaf(key, min));
	}

}

class findClosestLeafClass {
	
	HashMap<Node, Node> parentMap = new HashMap<Node, Node>();
	Node root;
	
	public findClosestLeafClass(Node root) {
		this.root = root;
		parentMap.put(root, null);
	}
	
	public Node findKey(Node root, int key) {
		
		if (root == null) {
			return null;
		}
		
		if (root.value == key) {
			return root;
		}
		
		if (root == null || (root.left == null && root.right == null)) {
			return null;
		}
		
		if (root.left != null) {
			parentMap.put(root.left, root);
		}
		

		if (root.right != null) {
			parentMap.put(root.right, root);
		}
		
		Node nodeFound = findKey(root.left, key);
		if (nodeFound != null) {
			return nodeFound;
		} else {
			return findKey(root.right, key);
		}
	}
	
	public int findClosestDownLeaf(Node root, int dist) {
		
		if (root == null) {
			return 10000;
		}
		if (root.left == null && root.right == null) {
			return dist;
		}
		
		return Math.min(findClosestDownLeaf(root.left, dist+1), findClosestDownLeaf(root.right, dist+1));
	}
	
	public int findClosestUpLeaf(Node root, int min) {
		int dist = 1;
		int v = 0;
		
		root = parentMap.get(root);
		while (root != null) {
			v = findClosestDownLeaf(root, 0);
			v = v + dist;
			if (v < min) {
				min = v;
			}
			dist++;
			root = parentMap.get(root);
		}
		
		return min;
	}
}


