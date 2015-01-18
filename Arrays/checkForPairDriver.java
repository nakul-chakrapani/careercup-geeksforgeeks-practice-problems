package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class checkForPairDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numberOfElements = sc.nextInt();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for (int i=0;i<numberOfElements;i++) {
			numbers.add(sc.nextInt());
		}
		
		checkForPair obj = new checkForPair(numbers);
		
		int sum = sc.nextInt();
		obj.checkSum1(sum);
		
	}

}

class checkForPair {
	
	ArrayList<Integer> numbers;
	public checkForPair(ArrayList<Integer> input) {
		numbers = input;
	}
	
	public void printNumbers() {
		for (int i=0;i<numbers.size();i++) {
			System.out.println(numbers.get(i));
		}
	}
	
	public void checkSum(int sum) {
		int i = 0;
		int j = numbers.size()-1;
		
		Collections.sort(numbers);
		while (i<j) {
			int num1 = numbers.get(i);
			int num2 = numbers.get(j);
			
			if ( num1 + num2 == sum) {
				System.out.println(num1 + " " + num2);
				break;
			} else if (num1 + num2 < sum) {
				i++;
			} else {
				j--;
			}
		}
		if (i >= j) {
			System.out.println("No pair found");
		}
	}
	
	public void checkSum1(int sum) {
		HashMap<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		boolean flag = false;
		
		for (int number:numbers) {
			if (numberMap.containsKey(number)) {
				System.out.println((sum - number) + " " + number);
				flag = true;
				break;
			} else {
				numberMap.put(sum-number, 1);
			}
		}
		
		if (!flag) {
			System.out.println("No pair found");
		}
	}
}