package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class LargestSumContiguousDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i=0;i<count;i++) {
			numbers.add(sc.nextInt());
		}
		
		LargestSumClass obj = new LargestSumClass(numbers);
		System.out.println(obj.largestSum());
	}

}

class LargestSumClass {
	
	ArrayList<Integer> numbers;
	public LargestSumClass(ArrayList<Integer> numbers) {
		// TODO Auto-generated constructor stub
		this.numbers = numbers;
	}
	
	public int largestSum() {
		int returnValue = 0;
		int maxTillNow = 0;
		
		for (int i=0;i<numbers.size();i++) {
			int number = numbers.get(i);
			maxTillNow += number;
			
			if (maxTillNow > returnValue) {
				returnValue = maxTillNow;
			}
			if (maxTillNow < 0) {
				maxTillNow = 0;
			}
		}
		return returnValue;
	}
}