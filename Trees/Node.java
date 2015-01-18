package Trees;

public class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public void printTree() {
		int leftValue, rightValue;
		if (left!= null) {
			leftValue = left.value;
		} else {
			leftValue = -1;
		}
		if (right != null) {
			rightValue = right.value;
		} else {
			rightValue = -1;
		}
		
		System.out.println("Node " + value + ": left --> " + leftValue + " , right --> " + rightValue);
		if (left!= null) {
			left.printTree();
		} 
		if (right != null) {
			right.printTree();
		}
	}
}
