package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class LISDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i=0;i<count;i++) {
			numbers.add(sc.nextInt());
		}

		LISClass obj = new LISClass(numbers);
		System.out.println(obj.LIS(numbers.size()-1));
	}

}

class LISClass {
	
	ArrayList<Integer> numbers;
	int[] table;
	public LISClass(ArrayList<Integer> numbers) {
		this.numbers = numbers;
		table = new int[numbers.size()];
	}
	
	public int LIS(int index) {
		int returnValue = 1;
		for (int i = index-1;i>=0;i--) {
			if (numbers.get(i) <= numbers.get(index)) {
				int lisValue;
				
				if (table[i] > 0) {
					lisValue = table[i];
				} else {
					lisValue = LIS(i);
					table[i] = lisValue;
				}
				if (returnValue < lisValue+1) {
					returnValue = lisValue+1;
				}
			}
		}
		return returnValue;
	}
}
