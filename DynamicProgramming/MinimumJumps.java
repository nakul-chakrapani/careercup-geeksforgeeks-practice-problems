package DynamicProgramming;

import java.util.Scanner;

public class MinimumJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] array = new int[count];
		
		for (int i=0;i<count;i++) {
			array[i] = sc.nextInt();
		}
		
		minimumJumpsClass obj = new minimumJumpsClass(array);
		for (int i=count-2;i>=0;i--) {
			System.out.println(obj.minimumJumps(i));
		}
	}

}

class minimumJumpsClass {
	int[] array;
	int[] table;
	
	public minimumJumpsClass(int[] array) {
		this.array = array;
		table = new int[array.length];
		
		for (int i=0;i<table.length;i++) {
			table[i] = -1;
		}
	}
	
	public int minimumJumps(int index) {
		
		if (table[index] != -1) {
			return table[index];
		}
		
		if ((array.length - 1 - index) < array[index]) {
			table[index] = 1;
			return table[index];
		} else {
			int steps = array[index];
			int minimumSteps = 1000;
			
			for (int i=index+1;i<=index+steps;i++) {
				int value = minimumJumps(i)+1;
				if (value < minimumSteps) {
					minimumSteps = value;
				}
			}
			table[index] = minimumSteps;
			return minimumSteps;
		}
	}
}