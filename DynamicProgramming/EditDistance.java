package DynamicProgramming;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		String outputStr = sc.nextLine();
		
		editDistanceClass obj = new editDistanceClass(inputStr, outputStr);
		System.out.println(obj.editDistance(inputStr.length()-1, outputStr.length()-1));
	}

}

class editDistanceClass {
	String inputStr;
	String outputStr;
	int[][] table;
	
	public editDistanceClass(String str1, String str2) {
		this.inputStr = str1;
		this.outputStr = str2;
		table = new int[inputStr.length()][outputStr.length()];
		
		for (int i=0;i<table.length;i++) {
			for (int j=0;j<table[0].length;j++) {
				table[i][j] = 1000;
			}
		}
	}
	
	public int editDistance(int i, int j) {
		int value = 0;
		if (i < 0 && j < 0) {
			return 0;
		}
		
		if (i >= 0 && j >= 0 ) {
			if (table[i][j] != 1000) {
				return table[i][j];
			}
		}	
		
		if (i < 0) {
			return j+1;
		}
		
		if (j < 0) {
			return i+1;
		}
		
		if (inputStr.charAt(i) == outputStr.charAt(j)) {
			value = editDistance(i-1, j-1);
		} else {
			value = Math.min(editDistance(i-1, j), Math.min(editDistance(i, j-1), editDistance(i-1, j-1))) + 1;
		}
		
		table[i][j] = value;
		return value;
	}
}