package DynamicProgramming;

import java.util.Scanner;

public class PalindromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		palindromePartitionClass obj = new palindromePartitionClass(str);
		for (int i=0;i<str.length();i++) {
			System.out.println(obj.minimumCuts(0, i));
		}

	}

}

class palindromePartitionClass {
	String s;
	int[][] table;
	
	public palindromePartitionClass(String s) {
		this.s = s;
		table = new int[s.length()][s.length()];
		
		for (int i=0;i<table.length;i++) {
			for (int j=0;j<table[0].length;j++) {
				table[i][j] = 1000;
			}
		}
	}
	
	public int minimumCuts(int start, int end) {
		int minimumCuts = table[start][end];
		
		if (start == end) {
			table[start][end] = 0;
			minimumCuts = 0;
		}
		
		if (minimumCuts == 1000 && checkPalindrome(start, end)) {
			table[start][end] = 0;
			minimumCuts = 0;
		}
		
		int index = start+1;
		int minCutsBefore, minCutsAafter;
		while (index <= end) {
			if (table[start][index-1] != 1000) {
				minCutsBefore = table[start][index-1];
			} else {
				minCutsBefore = minimumCuts(start, index-1);
				table[start][index-1] = minCutsBefore;
			}
			
			if (table[index][end] != 1000) {
				minCutsAafter = table[index][end];
			} else {
				minCutsAafter = minimumCuts(index, end);
				table[index][end] = minCutsAafter;
			}
			
			if (minimumCuts > (minCutsAafter + minCutsBefore + 1) ) {
				minimumCuts = minCutsAafter + minCutsBefore + 1;
			}
			index++;
		}
		
		return minimumCuts;
	}
	
	private boolean checkPalindrome(int start, int end) {
		boolean isPalindrome = true;
		
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			}
			else {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}
}