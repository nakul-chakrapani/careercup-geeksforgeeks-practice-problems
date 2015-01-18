package DynamicProgramming;

import java.util.Scanner;

public class MaximumSizeSqSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{0,1,1,0,1},
				{1,1,0,1,0},
				{1,1,1,1,0},
				{0,1,1,1,0},
				{1,1,1,1,1},
				{0,0,0,0,0}
		};
		
		maximumSubsquare obj = new maximumSubsquare(matrix);
		for (int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix[0].length;j++) {
				obj.maximumSSSize(i, j);
			}
		}
		
		System.out.println(obj.getMaximumSubSquareSize());
	}

}

class maximumSubsquare {
	int[][] matrix;
	int maximumSubsquareSize = 0;
	int[][] table;
	int rows, columns;
	
	public maximumSubsquare(int[][] matrix) {
		this.matrix = matrix;
		rows = matrix.length;
		columns = matrix[0].length;
		table = new int[rows][columns];
		
		for (int i=0;i<rows;i++) {
			for (int j=0;j<columns;j++) {
				table[i][j] = -1;
			}
		}
	}
	
	public int maximumSSSize(int i, int j) {
		int leftIndex = j-1;
		int upIndex = i-1;
		int leftLength = 0, upLength = 0;
		
		if (i==4 && j==3) {
			System.out.println("here");
		}
		if (table[i][j] >= 0) {
			return table[i][j];
		}
		
		if (matrix[i][j] == 0) {
			table[i][j] = 0;
			return 0;
		}
		
		int minimumLength = Math.min(leftIndex, upIndex);
		for (int z = 0;z<=minimumLength;z++) {
			if (matrix[i][leftIndex] == 1) {
				leftLength++;
				leftIndex--;
				continue;
			}
			break;
		}
		
		for (int z = 0;z<=minimumLength;z++) {
			if (matrix[upIndex][j] == 1) {
				upLength++;
				upIndex--;
				continue;
			}
			break;
		}
		int diagonalValue = 0;
		if (i-1 < 0 || j-1 < 0) {
			diagonalValue = 0;
		} else {
			diagonalValue = maximumSSSize(i-1, j-1);
		}
		int returnValue = Math.min(leftLength, Math.min(upLength, diagonalValue)) + 1;
		table[i][j] = returnValue;
		if (returnValue > maximumSubsquareSize) {
			maximumSubsquareSize = returnValue;
		}
		return returnValue;
	}
	
	public int getMaximumSubSquareSize() {
		return maximumSubsquareSize;
	}
}
