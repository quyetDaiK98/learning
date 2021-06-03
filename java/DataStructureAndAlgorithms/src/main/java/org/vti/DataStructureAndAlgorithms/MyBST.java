package org.vti.DataStructureAndAlgorithms;

public class MyBST {
	public MyTreeNode root;

	public void insert(int data, MyTreeNode node) {
		if (node == null) {
			node = new MyTreeNode(data, null, null);
			return;
		}

		if (data < node.data)
			insert(data, node.leftChild);
		else
			insert(data, node.rightChild);
	}
	
	// left-node-right
	public void inOrderTravesal(MyTreeNode node) {
		if(node == null)
			return;
		
		inOrderTravesal(node.leftChild);
		System.out.print(node.data + " ");
		inOrderTravesal(node.rightChild);
	}
	
	// node-left-right
	public void preOrderTravesal(MyTreeNode node) {
		if(node == null)
			return;
		
		System.out.print(node.data + " ");
		inOrderTravesal(node.leftChild);
		inOrderTravesal(node.rightChild);
	}
	
	// left-right-node
	public void postOrderTravesal(MyTreeNode node) {
		if(node == null)
			return;
		
		inOrderTravesal(node.leftChild);
		inOrderTravesal(node.rightChild);
		System.out.print(node.data + " ");
	}

}
