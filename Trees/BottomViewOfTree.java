package Trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

public class BottomViewOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeWithHD node5 = new NodeWithHD(5, null, null);
		NodeWithHD node10 = new NodeWithHD(10, null, null);
		NodeWithHD node14 = new NodeWithHD(14, null, null);
		NodeWithHD node25 = new NodeWithHD(25, null, null);
		NodeWithHD node4 = new NodeWithHD(4, null, null);
		NodeWithHD node3 = new NodeWithHD(3, node10, node14);
		NodeWithHD node8 = new NodeWithHD(8, node5, node3);
		NodeWithHD node22 = new NodeWithHD(22, node4, node25);
		NodeWithHD node20 = new NodeWithHD(20, node8, node22);
		
		BottomViewClass obj = new BottomViewClass();
		obj.BottomView(node20);
		System.out.println(obj.getMap());
	}

}

class BottomViewClass {
	TreeMap<Integer, Integer> distMap = new TreeMap<Integer, Integer>(Collections.reverseOrder());
	LinkedList<NodeWithHD> queue = new LinkedList<NodeWithHD>();
	
	public void BottomView(NodeWithHD root) {
		root.hd = 1;
		queue.add(root);
		
		while (!queue.isEmpty()) {
			NodeWithHD node = queue.removeFirst();
			
			if (node.left != null) {
				node.left.hd = node.hd + 1;
				queue.add(node.left);
			}
			
			if (node.right != null) {
				node.right.hd = node.hd - 1;
				queue.add(node.right);
			}
			
			distMap.put(node.hd, node.value);
		}
	}
	
	public TreeMap<Integer, Integer> getMap() {
		return distMap;
	}
}


class NodeWithHD {
	public int value;
	public NodeWithHD left;
	public NodeWithHD right;
	public int hd;
	
	
	public NodeWithHD(int value, NodeWithHD left, NodeWithHD right) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.hd = 0;
	}
}
