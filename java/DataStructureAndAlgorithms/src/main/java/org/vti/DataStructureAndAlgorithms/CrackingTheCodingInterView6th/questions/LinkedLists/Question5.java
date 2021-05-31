package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.LinkedLists;

import org.vti.DataStructureAndAlgorithms.MyLinkedList;
import org.vti.DataStructureAndAlgorithms.MyLinkedList.Node;

public class Question5 {

	public static MyLinkedList sumReserve(Node node1, Node node2) {
		MyLinkedList ret = new MyLinkedList();
		
		int carry = 0;
		
		while (node1 != null || node2 != null) {
			int sum =(node1 != null ? node1.getData() : 0) + (node2 != null ? node2.getData() : 0);
			
			ret.append(sum % 10 + carry);
			
			carry = sum > 9 ? 1 : 0;
			
			if (node1 != null)
				node1 = node1.getNext();
			if (node2 != null)
				node2 = node2.getNext();
		}
		
		
		return ret;
	}
	
	public static void sumReserveRecursive(MyLinkedList l, Node n1, Node n2, int carry) {
		if(n1 == null && n2 == null)
			return;
		
		int sum =(n1 != null ? n1.getData() : 0) + (n2 != null ? n2.getData() : 0);
		
		l.append(sum % 10 + carry);
		
		sumReserveRecursive(l, n1 != null ? n1.getNext() : null, n2 != null ? n2.getNext() : null, sum > 9 ? 1 : 0);
		
	}

	public static double sumForward(Node node1, Node node2) {
		int epoch = 0;
		double sum = 0.0;

		return 0;
	}

	public static void main(String[] args) {
		MyLinkedList l1 = new MyLinkedList();
		l1.append(3);
		l1.append(5);
		l1.append(8);

		MyLinkedList l2 = new MyLinkedList();
		l2.append(5);
		l2.append(9);
		l2.append(2);
		l2.append(1);

		
		sumReserve(l1.getHead(), l2.getHead()).print1();
		
		MyLinkedList l3 = new MyLinkedList();
		sumReserveRecursive(l3, l1.getHead(), l2.getHead(), 0);
		l3.print();
	}
}
