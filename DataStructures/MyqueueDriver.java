package DataStructures;

import java.util.Scanner;

public class MyqueueDriver {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of queue : ");
		int size = sc.nextInt();
		MyQueue q = new MyQueue(size);
		
		while (true) {
			System.out.println("Choose what you wanna do :");
			System.out.println("1 - Enqueue , 2 - Dequeue , 3 - print queue, 4 - come out");
			int choice = sc.nextInt();
			
			if (choice == 4) {
				break;
			} else if (choice == 1) {
				System.out.println("enter element you want to insert");
				int element = sc.nextInt();
				q.enqueue(element);
			} else if (choice == 2) {
				System.out.println("Element dequeed : " + q.dequeue());
			} else if (choice == 3) {
				System.out.println("queue contents");
				q.printQueue();
			} else {
				System.out.println("Please select correct choice");
			}
		}
	}
}
class MyQueue {
	int[] queue;
	int front;
	int rear;
	
	public MyQueue(int size) {
		queue = new int[size];
		front = -1;
		rear = 0;
	}
	
	public void enqueue(int element) {
		if (rear<queue.length) {
			queue[rear++] = element;
		} else {
			System.out.println("Queue is full");
		}
	}
	
	public int dequeue() {
		int element = -1;
		if (front < rear) {
			element = queue[++front];	
		} else {
			System.out.println("No elements in queue");
		}
		return element;
	}
	
	public void printQueue() {
		for (int i=front+1;i<rear;i++) {
			System.out.print(queue[i] + " ");
		}
		System.out.println();
	}
}
