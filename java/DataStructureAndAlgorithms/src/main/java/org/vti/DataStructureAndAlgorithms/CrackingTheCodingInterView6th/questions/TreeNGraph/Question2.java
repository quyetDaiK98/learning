package org.vti.DataStructureAndAlgorithms.CrackingTheCodingInterView6th.questions.TreeNGraph;

import java.util.ArrayList;
import java.util.List;

import org.vti.DataStructureAndAlgorithms.MyBST;

public class Question2 {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		
		MyBST tree = new MyBST(list);
		tree.breadthFirstTravesal();
		
		
		System.out.println();
		tree.inOrderTravesal(tree.root);
		System.out.println();
		tree.preOrderTravesal(tree.root);
		System.out.println();
		tree.postOrderTravesal(tree.root);
	}
}
