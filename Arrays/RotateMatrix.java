package Arrays;

import java.util.Scanner;

public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int dim = sc.nextInt();
		int[][] matrix = new int[dim][dim];
		
		for (int i=0;i<dim;i++) {
			for (int j=0;j<dim;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		rotateMatrixClass obj = new rotateMatrixClass(matrix, dim);
		obj.rotate();
		obj.printArray();

	}

}

class rotateMatrixClass {
	int[][] matrix;
	int dim;
	
	public rotateMatrixClass(int[][] matrix, int dim) {
		this.matrix = matrix;
		this.dim = dim;
	}
	
	public void rotate() {
		int temp;
		int layer = dim/2;
		int count;
		
		for (int i=0;i<dim-1;i++) {
			for (int j=dim-1;j>=0;j--) {
				System.out.println(i + " " + j);
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][dim-j];
				matrix[i][dim-j] = matrix[i][j];
				matrix[i][j] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
		
	}
	
	public void printArray() {
		for (int i=0;i<dim;i++) {
			for (int j=0;j<dim;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}