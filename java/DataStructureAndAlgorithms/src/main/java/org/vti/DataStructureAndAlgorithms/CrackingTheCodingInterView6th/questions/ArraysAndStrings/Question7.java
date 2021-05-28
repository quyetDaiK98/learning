package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.ArraysAndStrings;

public class Question7 {
	
	private static void RotateMatrix(int[][] m, int n) {
		int layers = n / 2;
		
		for(int layer = 0; layer < layers; layer++) {
			
			for(int i = layer; i < n - layer - 1; i++) {
				int lastItem = n - layer - i - 1;
				
				// save top
				int tmpTop = m[layer][i];
				
				// fill left to top
				m[layer][i] = m[lastItem][layer];
				
				// fill bot to left
				m[lastItem][layer] = m[n - layer - 1][lastItem];
				
				// fill right to bot
				m[n - layer - 1][lastItem] = m[i][n - layer - 1];
				
				// fill tmp to right
				m[i][n - layer - 1] = tmpTop;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] m = {{1, 2, 3, 4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
		
		RotateMatrix(m, 4);
		
		for(int i = 0; i < m.length; i++) {
		    for(int j = 0; j < m[i].length; j++) 
		        System.out.print(m[i][j]);
		    
		    System.out.println();
		}
	}
}
