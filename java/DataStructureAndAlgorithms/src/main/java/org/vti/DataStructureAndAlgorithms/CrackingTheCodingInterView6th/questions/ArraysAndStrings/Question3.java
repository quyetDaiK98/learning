package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.ArraysAndStrings;

public class Question3 {

	static void replace(char[] arr, int trueLength) {
		int spaceCount = 0;
		for (int i = 0; i < trueLength; i++) {
			if(arr[i] == ' ')
				spaceCount ++;
		}
		
		int index = trueLength + spaceCount * 2;
		
		for(int i = trueLength - 1; i >= 0; i--) {
			if(arr[i] == ' ') {
				arr[index - 1] = '0';
				arr[index - 2] = '2';
				arr[index - 3] = '%';
				index -= 3;
			}else {
				arr[index - 1] = arr[i];
				index --;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Mr John Smith          ";
		
		char[] arr = a.toCharArray();
		
		replace(arr, 13);
		
		System.out.println(arr);
	}

}
