package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int changes = sc.nextInt();
		int[] S = new int[changes];
		
		for (int i=0;i<changes;i++) {
			S[i] = sc.nextInt();
		}
		
		coinChangeClass obj = new coinChangeClass(S);
		System.out.println(obj.coinChange(sum));
	}

}

class coinChangeClass {
	int[] S;
	HashMap<Integer, Integer> numSolutions;
	
	public coinChangeClass(int[] S) {
		this.S = S;
		numSolutions = new HashMap<Integer, Integer>();
	}
	
	public int coinChange(int sum) {
		if (sum == 0) {
			return 1;
		}
		
		if (numSolutions.containsKey(sum)) {
			return numSolutions.get(sum);
		}
		
		int numPossibleSoltions = 0;
		for (int i=0;i<S.length;i++) {
			if (sum-S[i] >= 0) {
				numPossibleSoltions += coinChange(sum-S[i]); 
			}
		}
		numSolutions.put(sum, numPossibleSoltions);
		return numPossibleSoltions;
	}
}