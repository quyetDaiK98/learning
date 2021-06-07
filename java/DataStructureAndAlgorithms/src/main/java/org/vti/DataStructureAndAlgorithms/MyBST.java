package org.vti.DataStructureAndAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class MyBST {
	public MyTreeNode root;

	public void insert(int data) {
		root = insertRec(data, root);
	}

	private MyTreeNode insertRec(int data, MyTreeNode node) {
		if (node == null)
			return new MyTreeNode(data, null, null);

		if (data < node.data)
			node.leftChild = insertRec(data, node.leftChild);
		else
			node.rightChild = insertRec(data, node.rightChild);

		return node;
	}

	// left-node-right
	// one of special types of depth-first travasal
	public void inOrderTravesal(MyTreeNode node) {
		if (node == null)
			return;

		inOrderTravesal(node.leftChild);
		System.out.print(node.data + " ");
		inOrderTravesal(node.rightChild);
	}

	// node-left-right
	// one of special types of depth-first travasal
	public void preOrderTravesal(MyTreeNode node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");
		inOrderTravesal(node.leftChild);
		inOrderTravesal(node.rightChild);
	}

	// left-right-node
	// one of special types of depth-first travasal
	public void postOrderTravesal(MyTreeNode node) {
		if (node == null)
			return;

		inOrderTravesal(node.leftChild);
		inOrderTravesal(node.rightChild);
		System.out.print(node.data + " ");
	}

	public void breadthFirstTravesal() {
		if (root == null)
			return;

		Queue<MyTreeNode> q = new LinkedList<MyTreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			MyTreeNode node = q.remove();
			System.out.print(node.data + " ");
			
			if (node.leftChild != null)
				q.add(node.leftChild);
			
			if (node.rightChild != null)
				q.add(node.rightChild);
		}

	}

}
