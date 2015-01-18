package Trees;

public class SizeOfTreeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node7 = new Node(7, null, null);
		Node node6 = new Node(6, null, null);
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, null);
		Node node3 = new Node(3, node6, node7);
		Node node2 = new Node(2, node4, node5);
		Node node1 = new Node(1, node2, node3);
		
		sizeOfTreeClass obj = new sizeOfTreeClass(node1);
		System.out.println(obj.size(node1));
	}

}

class sizeOfTreeClass {	
	public sizeOfTreeClass(Node node) {
		
	}
	
	public int size(Node root) {
		int s = 0;
		int leftSize = 0;
		int rightSize = 0;
		
		if (root.left != null) {
			leftSize = size(root.left);
		}
		if (root.right != null) {
			rightSize = size(root.right);
		}
		
		s = leftSize + rightSize + 1;
		return s;
	}
}
