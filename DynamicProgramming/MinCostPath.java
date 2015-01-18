package DynamicProgramming;

import java.util.Scanner;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		
		int[][] costMatrix = new int[rows][cols];
		
		for (int i=0;i<rows;i++) {
			for (int j=0;j<cols;j++) {
				costMatrix[i][j] = sc.nextInt();
			}
		}

		minCostPathClass obj = new minCostPathClass(costMatrix);
		System.out.println(obj.minCostPath(rows-1, cols-1));
	}

}

class minCostPathClass {
	int[][] costMatrix;
	int[][] table;
	
	public minCostPathClass(int[][] costMatrix) {
		this.costMatrix = costMatrix;
		table = new int[costMatrix.length][costMatrix[0].length];
		
		for (int i=0;i<table.length;i++) {
			for (int j=0;j<table[0].length;j++) {
				table[i][j] = 1000;
			}
		}

	}
	
	public int minCostPath(int i, int j) {
		int value = 0;
		if (i < 0 || j < 0) {
			return 1000;
		} else {
			if (table[i][j] != 1000) {
				value = table[i][j];
			} else {
				value = Math.min(minCostPath(i-1, j-1), Math.min(minCostPath(i, j-1), minCostPath(i-1, j)));
				if (value >= 1000)
					value = value - 1000 + costMatrix[i][j];
				else 
					value = value + costMatrix[i][j];
				table[i][j] = value;
			}
			return value;
		}
	}
}