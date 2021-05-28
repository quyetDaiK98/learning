package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Question4 {
	public static boolean isPalindrome(String s) {
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ')
				continue;
			int count = charCount.containsKey(s.charAt(i)) ? charCount.get(s.charAt(i)) + 1 : 1;
			charCount.put(s.charAt(i), count);
		}
			
		int oddCharCount = 0;
		for (Entry<Character, Integer> entry : charCount.entrySet()) {
			if(entry.getValue() % 2 != 0)
				oddCharCount ++;
		}
		
		if(oddCharCount > 1)
			return false;
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("quyet"));
		
		int a = 1;
		System.out.println(a & (1 << 100));
	}
}
