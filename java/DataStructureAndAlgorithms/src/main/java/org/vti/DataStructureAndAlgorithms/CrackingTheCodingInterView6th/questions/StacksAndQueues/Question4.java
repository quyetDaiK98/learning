package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.StacksAndQueues;

import java.util.Stack;

public class Question4 {
	class MyQueue{
		Stack<Integer> s1;
		Stack<Integer> s2;
		
		public int getSize() {
			return s1.size() + s2.size();
		}
		
		public void push(int i) {
			s1.push(i);
		}
		
		public int peek() {
			while(!s1.isEmpty()) 
				s2.push(s1.pop());
			
			return s2.peek();
		}
		
		public void remove() {
			while(!s1.isEmpty()) 
				s2.push(s1.pop());
			
			s2.pop();
		}
	}
	
	
}
