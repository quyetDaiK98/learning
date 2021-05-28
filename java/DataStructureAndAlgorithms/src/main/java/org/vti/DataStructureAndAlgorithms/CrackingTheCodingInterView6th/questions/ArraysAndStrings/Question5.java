package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.ArraysAndStrings;

public class Question5 {

	public static boolean isOneEditAway(String s1, String s2) {
		if(s1.length() == s2.length())
			return isEdited(s1, s2);
		else if(s1.length() - 1 == s2.length())
			return isInserted(s1, s2);
		else if(s1.length() == s2.length() -1)
			return isInserted(s2, s1);
		
		return false;
	}
	
	private static boolean isInserted(String s1, String s2) {
		boolean inserted = false;
		int i = 0, j = 0;
		
		while(i < s1.length() && j < s2.length()) {
			if(s1.charAt(i) == s2.charAt(j)) {
				i++;j++;
			}
			else {
				if(inserted)
					return false;
				inserted = true;
				i++;
			}
		}
		
		return true;
	}
	
	private static boolean isEdited(String s1, String s2) {
		boolean edited = false;
		
		for (int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(edited)
					return false;
				edited = true;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isOneEditAway("pale", "ple"));
		System.out.println(isOneEditAway("pales", "pale"));
		System.out.println(isOneEditAway("pale", "bale"));
		System.out.println(isOneEditAway("pale", "bake"));
	}

}
