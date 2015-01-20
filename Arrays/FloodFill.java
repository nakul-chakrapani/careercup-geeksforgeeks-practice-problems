package Arrays;

// http://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1, 1, 1, 1, 1, 1, 1, 1},
                		 {1, 1, 1, 1, 1, 1, 0, 0},
                		 {1, 0, 0, 1, 1, 0, 1, 1},
                		 {1, 2, 2, 2, 2, 0, 1, 0},
                		 {1, 1, 1, 2, 2, 0, 1, 0},
                		 {1, 1, 1, 2, 2, 2, 2, 0},
                		 {1, 1, 1, 1, 1, 2, 1, 1},
                		 {1, 1, 1, 1, 1, 2, 2, 1},
                };
		
		FloodFillClass obj = new FloodFillClass(matrix, 8, 8);
		obj.floodFillDriver(4, 4, 3);
		obj.printMatrix();
	}

}

class FloodFillClass {
	int[][] matrix;
	int m,n;
	
	public FloodFillClass(int[][] matrix, int m, int n) {
		this.matrix = matrix;
		this.m = m;
		this.n = n;
	}
	
	public void floodFillDriver(int x, int y, int new_value) {
		int old_value = matrix[x][y];
		floodFill(x, y, old_value, new_value);
	}
	
	public void floodFill(int x, int y, int old_value, int new_value) {
		
		if (x < 0 || y < 0 || x >= m || y >= n) {
			return;
		}
		
		if (matrix[x][y] == old_value) 
			matrix[x][y] = new_value;
		else 
			return;
		
		floodFill(x+1, y, old_value, new_value);
		floodFill(x, y+1, old_value, new_value);
		floodFill(x-1, y, old_value, new_value);
		floodFill(x, y-1, old_value, new_value);
	}
	
	public void printMatrix() {
		for (int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
	}
}