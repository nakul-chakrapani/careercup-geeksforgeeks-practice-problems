package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class UglyNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		UglyNumbersClass obj = new UglyNumbersClass(count);
		System.out.println(obj.uglyNumber());
	}

}

class UglyNumbersClass {
	int count;
	HashMap<Integer, Boolean> table = new HashMap<Integer, Boolean>();
	
	public UglyNumbersClass(int count) {
		this.count = count;
	}
	
	public int uglyNumber() {
		int uglyNo = 0;
		
		while (count > 0) {
			uglyNo++;
			if (isUglyNo(uglyNo)) {
				count--;
			}
		}
		
		return uglyNo;
	}
	
	public boolean isUglyNo(int number) {
		int copy = number;
		if (table.get(number) != null) {
			return table.get(number);
		}
		
		number = maxDivide(number, 2);
		number = maxDivide(number, 3);
		number = maxDivide(number, 5);
		
		if (number == 1) {
			table.put(copy, true);
			return true;
		} else {
			table.put(copy, false);
			return false;
		}
	}
	
	public int maxDivide(int number, int divisor) {
		while (number%divisor == 0) {
			number = number/divisor;
			if (isUglyNo(number)) {
				return 1;
			}
		}
		return number;
	}
}