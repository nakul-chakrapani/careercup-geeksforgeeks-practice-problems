package Arrays;

import java.util.HashMap;

public class checkDuplicatewithinK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,1,2,3,4};
		
		checkDuplicatesWithinKClass obj = new checkDuplicatesWithinKClass(array);
		System.out.println(obj.checkDuplicate(4));
	}

}

class checkDuplicatesWithinKClass {
	int[] array;
	HashMap<Integer, Integer> numberMap;
	
	public checkDuplicatesWithinKClass(int[] array) {
		this.array = array;
		numberMap = new HashMap<Integer, Integer>();
	}
	
	public boolean checkDuplicate(int k) {
		
		for (int i=0;i<array.length;i++) {
			if (numberMap.containsKey(array[i])) 
				return true;
			
			numberMap.put(array[i], 1);
			if (i-k >= 0)
				numberMap.remove(array[i-k]);
		}
		return false;
	}
}
