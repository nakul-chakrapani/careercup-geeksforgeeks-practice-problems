package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class longestSubstringWoRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		longestSubstringWoRepeatingCharsClass obj = new longestSubstringWoRepeatingCharsClass(str);
		System.out.println(obj.longestSubstring());
	}

}

class longestSubstringWoRepeatingCharsClass {
	String str;
	HashMap<Character, Integer> charMap;
	
	public longestSubstringWoRepeatingCharsClass(String str) {
		this.str = str;
		charMap = new HashMap<Character, Integer>();
	}
	
	public int longestSubstring() {
		int start = 0;
		int end = start+1;
		int maximumLength = 1;
		int currentLength = 1;
		
		charMap.put(str.charAt(start), 0);
		while (end<str.length()) {
			Character ch = str.charAt(end);
			int indexFoundAt = -1;
			
			if (charMap.containsKey(ch)) {
				indexFoundAt = charMap.get(ch);
			}
			
			if (indexFoundAt == -1) {
				charMap.put(ch, end);
				currentLength++;
			} else {
				if (indexFoundAt >= start) {
					start = indexFoundAt+1;
					currentLength = end-start+1;
					charMap.put(ch, end);
				} else {
					charMap.put(ch, indexFoundAt);
					currentLength++;
				}
			}
			if (currentLength > maximumLength) {
				maximumLength = currentLength;
			}
			end++;
		}
		
		return maximumLength;
	}
}