package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.LinkedLists;

import java.util.HashSet;
import java.util.Set;

import org.vti.DataStructureAndAlgorithms.MyLinkedList;
import org.vti.DataStructureAndAlgorithms.MyLinkedList.Node;

public class Question1 {
	
	public static void removeDuplicateds(MyLinkedList l) {
		Set<Integer> hs = new HashSet<Integer>();
		
		Node p = null;
		Node c = l.getHead();
		
		while(c != null) {
			if(!hs.contains(c.getData())) {
				hs.add(c.getData());
				p = c;
			} else {
				p.setNext(c.getNext());
			}
			c = c.getNext();
			
		}
		
	}
	
	public static void main(String[] args) {
		MyLinkedList l = new MyLinkedList();
		l.append(1);
    	l.append(2);
    	l.append(3);
    	l.append(3);
    	l.append(4);
    	removeDuplicateds(l);
    	
    	l.print();
    	
	}
}
