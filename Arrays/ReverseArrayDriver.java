package Arrays;

import java.util.Scanner;

public class ReverseArrayDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count =sc.nextInt();
		int[] numbers = new int[count];
		
		for (int i=0;i<count;i++) {
			numbers[i] = sc.nextInt();
		}
		
		ReverseArrayClass obj = new ReverseArrayClass(numbers);
		obj.reverseArray(0, numbers.length-1);
		obj.printArray();

	}

}

class ReverseArrayClass {
	int[] numbers;
	
	public ReverseArrayClass(int[] numbers) {
		this.numbers = numbers;
	}
	
	public void reverseArray(int begin, int end) {
		int temp;
		
		if (begin >= end) {
			return;
		} else {
			temp = numbers[begin];
			numbers[begin] = numbers[end];
			numbers[end] = temp;
			reverseArray(begin+1, end-1);
		}
	}
	
	public void printArray() {
		for (int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}
}