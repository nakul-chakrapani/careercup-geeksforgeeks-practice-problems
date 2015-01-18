package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class oddOccurenceDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		String numberString = sc.nextLine();
		String numberSplits[] = numberString.split(" ");
		
		for (int i=0;i<numberSplits.length;i++) {
			numbers.add(Integer.parseInt(numberSplits[i]));
		}
		
		oddOccurence obj = new oddOccurence(numbers);
		obj.checkForOddOccurence();
	}

}

class oddOccurence {
	
	ArrayList<Integer> numbers;
 	public oddOccurence(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}
 	
 	public void checkForOddOccurence(){
 		int result = numbers.get(0);
 		for (int i=1;i<numbers.size();i++) {
 			result = result ^ numbers.get(i);
 		}
 		System.out.println(result);
 	}
}
