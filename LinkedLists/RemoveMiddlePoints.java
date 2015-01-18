package LinkedLists;

public class RemoveMiddlePoints {
    public static void main(String []args){
       System.out.println("Hello World");
       
       Node node1 = new Node(40,5,null);
       Node node2 = new Node(20,5,node1);
       Node node3 = new Node(7,5,node2);
       Node node4 = new Node(7,10,node3);
       Node node5 = new Node(5,10,node4);
       Node node6 = new Node(1,10,node5);
       Node node7 = new Node(0,10,node6);
       
       removeMiddleClass obj = new removeMiddleClass();
       obj.removeMiddle(node7);
       obj.printList(node7);
    }
}
class removeMiddleClass {
   
   public Node removeMiddle(Node start) {
       Node begin = start;
       boolean verticalLine = false;
       
       if (begin == null) {
           return begin;
       }
       
       Node current = begin.next;
       if (begin.x == current.x) {
           verticalLine = true;
       }
       
       while(current != null && current.next != null) {
               System.out.println(current.x + "," + current.y);
               if ((current.next.x == current.x && verticalLine) || (current.next.y == current.y && !verticalLine)) {
                   current = current.next;
               } else {
                   begin.next = current;
                   begin = current;
                   current = begin.next;
                   
                   if (verticalLine) {
                       verticalLine = false;
                   } else {
                       verticalLine = true;
                   }
               }
       }
       begin.next = current;
       
       return start;
   }
   
   public void printList(Node start) {
       Node current = start;
       
       while (current != null) {
           System.out.print("(" + current.x + "," + current.y + ") --> ");
           current = current.next;
       }
       System.out.println("null");
   }
}
class Node {
   public int x;
   public int y;
   public Node next;
   
   public Node(int x, int y, Node next) {
       this.x = x;
       this.y = y;
       this.next = next;
   }
}
