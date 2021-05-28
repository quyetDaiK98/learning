package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

import utils.Constants;

// Implement an algorithm to determine if a string has all unique characters.
public class Question1 implements Constants {
	
	private static boolean isUniqueStr(String s) {
		boolean[] charSet = new boolean[TOTAL_UNICODE_CHARACTERS];
		
		for (int i = 0; i < s.length(); i++) {
			int charIndex = s.charAt(i);
			
			if(charSet[charIndex])
				return false;
			
			charSet[charIndex] = true;
		}
		
		return true;
	}
	
	// Hash Table Solution
	private static boolean isUniqueStr1(String s) {
		Set<Integer> charSet = new HashSet<Integer>(); 
		
		for (int i = 0; i < s.length(); i++) {
			int charIndex = s.charAt(i);
			
			if(charSet.contains(charIndex))
				return false;
			
			charSet.add(charIndex);
		}
		
		return true;
	}
	
	// bit vector solution
	private static boolean isUniqueStr2(String s) {
		// an integer with value of 0 is a bit vector with 32 of length
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "quyett";
		System.out.println(a);
		System.out.println(isUniqueStr(a));
		System.out.println(isUniqueStr1(a));
		System.out.println(isUniqueStr2(a));
	}

}
