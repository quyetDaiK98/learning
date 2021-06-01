package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.LinkedLists;

import java.util.Stack;

import org.vti.DataStructureAndAlgorithms.MyLinkedList;
import org.vti.DataStructureAndAlgorithms.MyLinkedList.Node;

public class Question6 {

	// length of list is provided
	static boolean isPalindrome(Node node, int length) {
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < length; i++) {
			if (i == length / 2 && length % 2 != 0) {
				node = node.getNext();
				continue;
			} else if (i < length / 2) {
				st.push(node.getData());
			} else {
				if (node.getData() != st.peek())
					return false;
				st.pop();
			}
			node = node.getNext();
		}

		return true;
	}

	// dont know length
	static boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;

		Stack<Integer> st = new Stack<Integer>();

		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext() != null ? fast.getNext().getNext() : null;
			st.push(slow.getData());
			if (fast != null && fast.getNext() != null)
				slow = slow.getNext();

		}

		// length of list is odd
		if (fast != null)
			slow = slow.getNext().getNext();
		else 
			slow = slow.getNext();
		
		while (slow != null) {
			if (slow.getData() != st.peek())
				return false;
			st.pop();
			slow = slow.getNext();
		}

		return true;
	}

	public static void main(String[] args) {
		MyLinkedList l1 = new MyLinkedList();
		l1.append(0);
		l1.append(1);
		l1.append(2);
		l1.append(3);
		l1.append(2);
		l1.append(1);
		l1.append(0);

		MyLinkedList l2 = new MyLinkedList();
		l2.append(1);
		l2.append(2);
		l2.append(2);
		l2.append(1);

		System.out.println(isPalindrome(l1.getHead(), l1.getSize()));
		System.out.println(isPalindrome(l2.getHead(), l2.getSize()));

		System.out.println(isPalindrome(l1.getHead()));
		System.out.println(isPalindrome(l2.getHead()));
	}

}
