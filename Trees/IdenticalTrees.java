package Trees;

public class IdenticalTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node7 = new Node(7, null, null);
		Node node6 = new Node(6, null, null);
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, null);
		Node node3 = new Node(3, node6, node7);
		Node node2 = new Node(2, node4, node5);
		Node node1 = new Node(1, node2, node3);
		
		Node node71 = new Node(7, null, null);
		Node node61 = new Node(6, null, null);
		Node node51 = new Node(6, null, null);
		Node node41 = new Node(4, null, null);
		Node node31 = new Node(3, node61, node71);
		Node node21 = new Node(2, node41, node51);
		Node node11 = new Node(1, node21, node31);
		
		IdenticalTreesClass obj = new IdenticalTreesClass();
		System.out.println(obj.identicalTrees(node1, node11));
	}

}

class IdenticalTreesClass {
	
	public boolean identicalTrees(Node root1, Node root2) {
		boolean leftIdentical = true;
		boolean rightIdentical = true;
		
		if (root1.left != null && root2.left !=null) {
			leftIdentical = identicalTrees(root1.left, root2.left);
		}
		
		if (root1.right != null && root2.right !=null) {
			rightIdentical = identicalTrees(root1.right, root2.right);
		}
		
		if (root1.value == root2.value) {
			return leftIdentical && rightIdentical;
		} else {
			return false;
		}
	}
}