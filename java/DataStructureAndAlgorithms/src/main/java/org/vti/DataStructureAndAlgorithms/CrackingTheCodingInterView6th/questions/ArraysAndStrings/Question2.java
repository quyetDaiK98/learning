package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

import utils.Constants;

// dicide if a string is a permutation of the other 
public class Question2 implements Constants {

	private static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		// key : charIndex
		// value : disapear count
		Map<Integer, Integer> charMap1 = new HashMap<Integer, Integer>();

		for (int i = 0; i < s1.length(); i++) {
			int charIndex = s1.charAt(i);
			int currCount = 1;

			if (charMap1.containsKey(charIndex)) {
				int previousCount = charMap1.get(charIndex);
				currCount = previousCount + 1;
			}

			charMap1.put(charIndex, currCount);

		}

		Map<Integer, Integer> charMap2 = new HashMap<Integer, Integer>();

		for (int i = 0; i < s2.length(); i++) {
			int charIndex = s2.charAt(i);
			int currCount = 1;

			if (charMap2.containsKey(charIndex)) {
				int previousCount = charMap2.get(charIndex);
				currCount = previousCount + 1;
			}

			charMap2.put(charIndex, currCount);

		}

		for (Map.Entry<Integer, Integer> entry : charMap1.entrySet()) {
			int key = entry.getKey();
			if (!charMap2.containsKey(key) || charMap1.get(key) != charMap2.get(key))
				return false;
		}

		return true;
	}

	// array solution
	private static boolean isPermutation1(String s1, String s2) {
		int[] charSet = new int[TOTAL_UNICODE_CHARACTERS];

		for (int i = 0; i < s1.length(); i++) {
			int charIndex = s1.charAt(i);

			charSet[charIndex]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			int charIndex = s2.charAt(i);

			charSet[charIndex]--;

			if (charSet[charIndex] < 0)
				return false;

		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPermutation("quyet", "tqyue"));
	}

}
