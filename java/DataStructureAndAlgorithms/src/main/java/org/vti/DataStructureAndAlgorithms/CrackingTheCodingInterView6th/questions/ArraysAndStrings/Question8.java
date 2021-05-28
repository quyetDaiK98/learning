package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class Question8 {

	private static void setZero(int[][] matrix) {
		Set<Integer> rowSet = new HashSet<Integer>();
		Set<Integer> colSet = new HashSet<Integer>();

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
			}

		for (Integer val : rowSet)
			for (int i = 0; i < matrix[val].length; i++)
				matrix[val][i] = 0;

		for (Integer val : colSet)
			for (int i = 0; i < matrix.length; i++)
				matrix[i][val] = 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] m = { { 1, 0, 3}, { 4,0,6 }, { 7,8,9 }};

		setZero(m);

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++)
				System.out.print(m[i][j]);
			 System.out.println();
		}
	}

}
