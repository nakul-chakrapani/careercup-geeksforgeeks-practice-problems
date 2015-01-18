package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MedianOfSortedArraysDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int count1 = sc.nextInt();
		ArrayList<Integer> numbers1 = new ArrayList<Integer>();
		
		for (int i=0;i<count1;i++) {
			numbers1.add(sc.nextInt());
		}
		
		int count2 = sc.nextInt();
		ArrayList<Integer> numbers2 = new ArrayList<Integer>();
		
		for (int i=0;i<count2;i++) {
			numbers2.add(sc.nextInt());
		}
		
		MedianSortedArraysClass obj = new MedianSortedArraysClass(numbers1, numbers2);
		System.out.println(obj.median(0, numbers1.size()-1, 0, numbers2.size()-1));
	}

}

class MedianSortedArraysClass {
	ArrayList<Integer> numbers1 = new ArrayList<Integer>();
	ArrayList<Integer> numbers2 = new ArrayList<Integer>();
	
	public MedianSortedArraysClass(ArrayList<Integer> numbers1, ArrayList<Integer> numbers2) {
		this.numbers1 = numbers1;
		this.numbers2 = numbers2;
	}
	
	public int median(int begin1, int end1, int begin2, int end2) {
		int med = 0;
		int med1, med2;
		
		if ((end1-begin1)%2 == 0) {
			med1 = numbers1.get((begin1+end1)/2);
		} else {
			int mid = (begin1+end1)/2;
			med1 = (numbers1.get(mid) + numbers1.get(mid+1))/2;
		}
		
		if ((end2-begin2)%2 == 0) {
			med2 = numbers2.get((begin2+end2)/2);
		} else {
			int mid = (begin2+end2)/2;
			med2 = (numbers2.get(mid) + numbers2.get(mid+1))/2;
		}
		
		if (end1-begin1 <=2 && end2-begin2 <=2) {
			med = (Math.max(numbers1.get(begin1), numbers2.get(begin2)) + Math.min(numbers1.get(end1), numbers2.get(end2)))/2;
		} else {
			if (med1 == med2) {
				med = med1;
			} else if (med1 < med2) {
				int mid1 = (begin1+end1)/2;
				int mid2 = (begin2+end2)/2;
				
				if ((begin2+end2)%2 != 0) {
					mid2++;
				}
				med = median(mid1, end1, begin2, mid2);
			} else if (med1 > med2) {
				int mid1 = (begin1+end1)/2;
				int mid2 = (begin2+end2)/2;
				
				if ((begin1+end1)%2 != 0) {
					mid1++;
				}
				med = median(begin1, mid1, mid2, end2);
			}
		}
		return med;
	}
}
