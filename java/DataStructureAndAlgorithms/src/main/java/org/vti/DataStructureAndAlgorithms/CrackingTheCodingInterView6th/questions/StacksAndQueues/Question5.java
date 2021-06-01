package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.StacksAndQueues;

import java.util.Stack;

public class Question5 {
	public static Stack<Integer> sort(Stack<Integer> primary) {
		Stack<Integer> tempority = new Stack<Integer>();

		tempority.push(primary.pop());
		
		while (!primary.isEmpty()) {
			int currItem = primary.peek();
			while (tempority.peek() < currItem)
				primary.push(tempority.pop());
			
			while (primary.peek() != currItem) {
				tempority.push(primary.pop());
			}
			tempority.push(primary.pop());
		}
		return tempority;
	}

	public static void main(String[] args) {
		Stack<Integer> primary = new Stack<Integer>();
		
		primary.add(5);
		primary.add(2);
		primary.add(6);
		primary.add(1);
		primary.add(3);
		primary.add(8);
		
		System.out.println(sort(primary));
	}
}
