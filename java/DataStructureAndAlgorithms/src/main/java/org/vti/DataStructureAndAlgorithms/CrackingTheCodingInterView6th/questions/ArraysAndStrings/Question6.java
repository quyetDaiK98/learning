package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.ArraysAndStrings;

public class Question6 {
	
	private static String compress(String s) {
		StringBuilder ret = new StringBuilder();
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
				count++;
				continue;
			}else {
				ret.append(s.charAt(i)).append(count);
				count=1;
			}
		}
		
		return ret.length() <= s.length() ? ret.toString() : s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress("aabcccccaaa"));
	}

}
