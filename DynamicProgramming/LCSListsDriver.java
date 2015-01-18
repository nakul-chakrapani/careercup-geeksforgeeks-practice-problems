package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class LCSListsDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		int count1 = sc.nextInt();
		for (int i=0;i<count1;i++) {
			list1.add(sc.nextInt());
		}
		
		int count2 = sc.nextInt();
		for (int i=0;i<count2;i++) {
			list2.add(sc.nextInt());
		}
		//String s1 = sc.nextLine();
		//String s2 = sc.nextLine();
		
		LCSListClass obj = new LCSListClass(list1, list2);
		int result = obj.LCS(0,0);
		
		System.out.println(result);
	}

}

class LCSListClass {
	ArrayList<Integer> list1;
	ArrayList<Integer> list2;
	int[][] table;
	
	public LCSListClass(ArrayList<Integer> s1, ArrayList<Integer> s2) {
		this.list1 = s1;
		this.list2 = s2;
		table = new int[s1.size()][s2.size()];
	}
	
	public int LCS(int i, int j) {
		if (i >= list1.size() || j >= list2.size()) {
			return 0;
		}
			
		if (table[i][j] > 0) {
			return table[i][j];
		} 
		
		int returnValue = 0;
		if (list1.get(i) == list2.get(j)) {
			returnValue = LCS(i+1, j+1) + 1;
		} else {
			returnValue = Math.max(LCS(i+1, j), LCS(i, j+1));
		}
		
		if (i < list1.size() && j < list2.size()) {
			table[i][j] = returnValue;
		}
		return returnValue;
	}
	
}