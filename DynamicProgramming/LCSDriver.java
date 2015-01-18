package DynamicProgramming;

import java.util.Scanner;

public class LCSDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		LCSClass obj = new LCSClass(s1, s2);
		int result = obj.LCS(0,0);
		
		System.out.println(result);
	}

}

class LCSClass {
	String str1;
	String str2;
	int[][] table;
	
	public LCSClass(String s1, String s2) {
		this.str1 = s1;
		this.str2 = s2;
		table = new int[s1.length()][s2.length()];
	}
	
	public int LCS(int i, int j) {
		int returnValue = 0;
		if (i >= str1.length() || j >= str2.length()) {
			returnValue = 0;
		} else if (str1.charAt(i) == str2.charAt(j)) {
			returnValue = LCS(i+1, j+1) + 1;
		} else {
			returnValue = Math.max(LCS(i+1, j), LCS(i, j+1));
		}
		
		if (i < str1.length() && j < str2.length()) {
			table[i][j] = returnValue;
		}
		return returnValue;
	}
	
}