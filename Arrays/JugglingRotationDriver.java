package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class JugglingRotationDriver {

	public static void main(String[] args) {
		// TODO  Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] numbers = new int[count];
		
		for (int i=0;i<count;i++) {
			numbers[i] = sc.nextInt();
		}
		
		JugglingRotation obj = new JugglingRotation(numbers);
		obj.juggleRotate(5);
		obj.printArray();
	}

}

class JugglingRotation {
	int[] numbers;
	
	public JugglingRotation(int[] numbers) {
		this.numbers = numbers;
	}
	
	public void juggleRotate(int juggleBy) {
		int size = numbers.length;
		int gcd = GCD(size, juggleBy);
		
		int rotationCount = 0;
		
		while (rotationCount < juggleBy) {
			int temp = numbers[rotationCount];
			int i;
			for (i=0;i<size;i = i+gcd) {
				numbers[i-gcd] = numbers[i];
			}
			numbers[i-gcd] = temp;
			rotationCount++;
		}
	}
	
	private int GCD(int a, int b) {
		if (b==0) return a;
		return GCD(b,a%b);
	}
	
	public void printArray() {
		for (int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}
}