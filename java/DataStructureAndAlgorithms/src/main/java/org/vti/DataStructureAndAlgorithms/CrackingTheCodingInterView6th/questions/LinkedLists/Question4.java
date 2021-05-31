package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.LinkedLists;

import org.vti.DataStructureAndAlgorithms.MyLinkedList;
import org.vti.DataStructureAndAlgorithms.MyLinkedList.Node;

public class Question4 {
	public static void partion(MyLinkedList l, int x) {
		Node preNode = l.getHead();
		Node currNode = l.getHead().getNext();
		
		while(currNode != null) {
			Node nextNode = currNode.getNext();
			if(currNode.getData() < x) {
				currNode.setNext(l.getHead());
				l.setHead(currNode);
				preNode.setNext(nextNode);
			}
			else {
				preNode = currNode;
			}
			
			currNode = nextNode;
		}
		
		Node nodeX = new Node(x);
		nodeX.setData(x);
		nodeX.setNext(null);
		
		preNode.setNext(nodeX);
	}
	
	
	public static void main(String[] args) {
		MyLinkedList l = new MyLinkedList();
		l.append(3);
    	l.append(5);
    	l.append(8);
    	l.append(5);
    	l.append(10);
    	l.append(2);
    	l.append(1);
    	
    	partion(l, 5);
    	l.print1();
	}
}
