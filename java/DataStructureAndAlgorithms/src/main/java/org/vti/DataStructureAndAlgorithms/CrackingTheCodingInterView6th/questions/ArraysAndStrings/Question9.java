package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.ArraysAndStrings;

public class Question9 {

	// determine whether s2 is a substring of s1
	private static boolean isSubstring(String s1, String s2) {
		boolean matched = true;
		for (int i = 0; i < s1.length() - s2.length() + 1; i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i + j) == s2.charAt(j)) {
					matched = true;
					continue;
				}
				else {
					matched = false;
					break;
				}

			}
			if (matched)
				return true;

		}

		return matched;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isSubstring("quyet", "t"));

	}
}
