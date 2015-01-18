package Trees;

import java.util.HashMap;

public class DiagonalSumTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node node11 = new Node(11, null, null);
		Node node10 = new Node(10, null, null);
		Node node12 = new Node(12, null, null);
		Node node7 = new Node(7, null, null);
		Node node9 = new Node(9, null, node10);
		Node node6 = new Node(6, node11, null);
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, node12, node7);
		Node node3 = new Node(3, node4, node5);
		Node node2 = new Node(2, node9, node6);
		Node node1 = new Node(1, node2, node3);
		
		DiagonalSumTreeClass obj = new DiagonalSumTreeClass(node1);
		obj.diagonalSum(node1, 1);
		System.out.println(obj.getHashMap());
	}

}

class DiagonalSumTreeClass {
	Node root;
	HashMap<Integer, Integer> diagMap;
	
	public DiagonalSumTreeClass(Node root) {
		this.root = root;
		diagMap = new HashMap<Integer, Integer>();
	}
	
	public void diagonalSum(Node root, int diag) {
		if (root == null) {
			return;
		}
		
		if (diagMap.containsKey(diag)) {
			diagMap.put(diag, diagMap.get(diag) + root.value);
		} else {
			diagMap.put(diag, root.value);
		}
		
		if (root.left != null) {
			diagonalSum(root.left, diag+1);
		}
		
		if (root.right != null) {
			diagonalSum(root.right, diag);
		}
	}
	
	public HashMap<Integer, Integer> getHashMap() {
		return diagMap;
	}
}
