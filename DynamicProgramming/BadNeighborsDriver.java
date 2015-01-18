package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class BadNeighborsDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i=0;i<count;i++) {
			numbers.add(sc.nextInt());
		}
		
		BadNeighborClass obj = new BadNeighborClass(numbers);
		System.out.println(obj.badNeighbor());

	}

}

class BadNeighborClass {
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	int[][] table;
	
	public BadNeighborClass(ArrayList<Integer> numbers) {
		this.numbers = numbers;
		table = new int[2][numbers.size()];
	}
	
	public int badNeighbor() {
		table[0][0] = numbers.get(0);
		table[1][0] = 0;
		table[0][1] = numbers.get(0);
		table[1][1] = numbers.get(1);
		
		int includingFirstElement, excludingFirstElement;
		for (int i=2;i<numbers.size();i++) {
			includingFirstElement = excludingFirstElement = -1;
			
			for (int j=i-2;j>=0;j--) {
				if (includingFirstElement < table[0][j]) {
					includingFirstElement = table[0][j];
				}
				if (excludingFirstElement < table[1][j]) {
					excludingFirstElement = table[1][j];
				}
			}
			if (i == numbers.size()-1) {
				table[0][i] = table[1][i] = excludingFirstElement + numbers.get(i);
			} else {
				table[0][i] = includingFirstElement + numbers.get(i);
				table[1][i] = excludingFirstElement + numbers.get(i);
			}
		}
		
		int maximumDonation = -1;
		for (int i=0;i<2;i++) {
			for (int j=0;j<numbers.size();j++) {
				if (maximumDonation < table[i][j]) {
					maximumDonation = table[i][j];
				}
			}
		}
		return maximumDonation;
	}
}
