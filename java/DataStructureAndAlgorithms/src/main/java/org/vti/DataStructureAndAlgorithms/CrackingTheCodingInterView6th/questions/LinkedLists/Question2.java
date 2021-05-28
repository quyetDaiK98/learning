package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.LinkedLists;

import org.vti.DataStructureAndAlgorithms.MyLinkedList;
import org.vti.DataStructureAndAlgorithms.MyLinkedList.Node;

public class Question2 {
	
	// O(n) space
	// O(n) time
	static int reverseRecursiveTravesal(Node node, int k) {
		if(node == null)
			return -1;
		
		int indexFromLast = reverseRecursiveTravesal(node.getNext(), k) + 1;
		if(indexFromLast == k) 
			System.out.println(node.getData());
		
		return indexFromLast;
		
	}
	
	// O(1) space
	// O(n) time
	static Node reserveIterativeTraversal(MyLinkedList l, int k) {
		Node p1 = l.getHead();
		Node p2 = l.getHead();
		
		for(int i = 0; i < k; i++) 
			p1 = p1.getNext();
			
		while(p1.getNext() != null) {
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		
		return p2;
	}
	
	
	
	
	
	public static void main(String[] args) {
		MyLinkedList l = new MyLinkedList();
		l.append(1);
    	l.append(2);
//    	l.append(3);
    	l.append(3);
    	l.append(4);
    	
    	reverseRecursiveTravesal(l.getHead(), 1);
    	
    	System.out.println(reserveIterativeTraversal(l, 1).getData());
    	
	}
}
