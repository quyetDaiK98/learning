package org.vti.DataStructureAndAlgorithms;

public class InsertionSort {

	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			
			int j = i - 1;
			while (j >= 0 && key < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		
	}
	
	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int[] arr = {31, 14, 59 , 26 , 41, 58};
		
		System.out.println("Array before sort : ");
		printArr(arr);
		
		insertionSort(arr);
		
		System.out.println("Array after sort : ");
		printArr(arr);
	}

}
