package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchPivotArrayDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i=0;i<count;i++) {
			numbers.add(sc.nextInt());
		}
		int search = sc.nextInt();

		SearchPivotArrayClass obj = new SearchPivotArrayClass(numbers);
		System.out.println("Search key found at :" + obj.pivotSearch(search));
	}

}

class SearchPivotArrayClass {
	
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	public SearchPivotArrayClass(ArrayList<Integer> numbers) {
		// TODO Auto-generated constructor stub
		this.numbers = numbers;
	}
	
	public int pivotSearch(int searchKey) {
		int index = 0;
		int pivotIndex;
		
		pivotIndex = findPivot(0, numbers.size()-1);
		System.out.println(pivotIndex);
		if (numbers.get(pivotIndex) == searchKey) {
			index = pivotIndex;
		}
		else if (numbers.get(0) <= searchKey) {
			index = binarySearch(0, pivotIndex-1, searchKey);
		} else {
			index = binarySearch(pivotIndex+1, numbers.size()-1, searchKey);
		}
		
		return index;
	}
	
	private int findPivot(int begin, int end) {
		int pivotIndex = 0;
		int mid = (begin+end)/2;
		
		if (numbers.get(mid+1) < numbers.get(mid)) {
			pivotIndex = mid;
		} else if (numbers.get(begin) < numbers.get(mid)) {
			pivotIndex = findPivot(mid+1, end);
		} else {
			pivotIndex = findPivot(begin, mid-1);
		}
		
		return pivotIndex;
	}
	
	private int binarySearch(int begin, int end, int key) {
		int index;
		int mid = (begin+end)/2;
		
		if (numbers.get(mid) == key) {
			index = mid;
		} else if (numbers.get(mid) < key) {
			index = binarySearch(mid+1, end, key);
		} else {
			index = binarySearch(begin, mid-1, key);
		}
		
		return index;
	}
}