package DynamicProgramming;

import java.util.Scanner;

public class longestPalindromicSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		longestPalindromicSubsequenceClass obj = new longestPalindromicSubsequenceClass(str);
		System.out.println(obj.longestPalindromicSub(0, str.length()-1));
	}

}

class longestPalindromicSubsequenceClass {
	String str;
	int[][] table;
	
	public longestPalindromicSubsequenceClass(String str) {
		this.str = str;
		table = new int[str.length()][str.length()];
		
		for (int i=0;i<table.length;i++) {
			for (int j=0;j<table[0].length;j++) {
				table[i][j] = -1;
			}
		}
	}
	
	public int longestPalindromicSub(int i, int j) {
		
		if (i >= str.length() || j < 0) {
			return 0;
		}
		
		if (table[i][j] != -1) {
			return table[i][j];
		}
		
		if (i>j) {
			table[i][j] = 0;
			return table[i][j];
		}
		
		if (str.charAt(i) == str.charAt(j)) {
			int value = 0;
			if (i==j) {
				value = 1;
			} else {
				value = 2;
			}
			return longestPalindromicSub(i+1, j-1) + value;
		}
		
		return Math.max(longestPalindromicSub(i+1, j), longestPalindromicSub(i, j-1));
	}
}