package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class zigzagDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i=0;i<count;i++) {
			numbers.add(sc.nextInt());
		}
		
		zigzagClass obj = new zigzagClass(numbers);
		System.out.println(obj.zigzagLength(count-1).number);
		
	}

}

class zigzagClass {
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	int[][] table;
	
	public zigzagClass(ArrayList<Integer> numbers) {
		this.numbers = numbers;
		table = new int[2][this.numbers.size()];
	}
	
	public numberWithSign zigzagLength(int index) {
		numberWithSign returnValue = new numberWithSign(1, 0);
		
		for (int j=index-1;j>=0;j--) {
			numberWithSign object;
			if (table[0][j] == 0) {
				object = zigzagLength(j);
				table[0][j] = object.number;
				table[1][j] = object.difference;
			} else {
				object = new numberWithSign(table[0][j], table[1][j]);
			}
			
			if ((numbers.get(j) < numbers.get(index) && object.difference <= 0) || 
					numbers.get(j) > numbers.get(index) && object.difference > 0) {
				if (returnValue.number <= object.number) {
					returnValue.number = object.number + 1;
					returnValue.difference = numbers.get(index) - numbers.get(j);
				}
			}
		}
		
		
		return returnValue;
	}
}

class numberWithSign {
	public int number;
	public int difference;
	
	public numberWithSign(int number, int difference) {
		this.number = number;
		this.difference = difference;
	}
}