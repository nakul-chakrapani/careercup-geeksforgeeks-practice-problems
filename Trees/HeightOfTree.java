package Trees;

public class HeightOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node8 = new Node(8, null, null);
		Node node7 = new Node(7, node8, null);
		Node node6 = new Node(6, null, null);
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, null);
		Node node3 = new Node(3, node6, node7);
		Node node2 = new Node(2, node4, node5);
		Node node1 = new Node(1, node2, node3);
		
		HeightOfTreeClass obj = new HeightOfTreeClass();
		System.out.println(obj.height(node1));
	}

}

class HeightOfTreeClass {
	
	public int height(Node root) {
		if (root == null) {
			return 0;
		} else {
			int leftHieght = 0;
			int rightHeight = 0;
			if (root.left != null) {
				leftHieght = height(root.left);
			}
			if (root.right != null) {
				rightHeight = height(root.right);
			}
			
			return Math.max(leftHieght, rightHeight) + 1;
		}
	}
}