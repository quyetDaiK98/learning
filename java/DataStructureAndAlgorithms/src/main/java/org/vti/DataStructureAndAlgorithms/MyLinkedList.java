package org.vti.DataStructureAndAlgorithms;

public class MyLinkedList {
	private int size;
	private Node head;

	public MyLinkedList() {
	}

	public int getSize() {
		return this.size;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void append(int d) {
		Node newNode = new Node(d);
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		Node i = head;
		while (i.getNext() != null)
			i = i.getNext();

		i.setNext(newNode);

		size++;
	}

	public void append(Node newNode) {
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		Node i = head;
		while (i.getNext() != null)
			i = i.getNext();

		i.setNext(newNode);

		size++;
	}

	public void print() {
		Node i = head;
		while (i != null) {
			System.out.println(i.getData());
			i = i.getNext();
		}

	}

	public Node reserveListRecursive(Node node) {
		if (node == null)
			return null;

		Node next = reserveListRecursive(node.getNext());
		if (next == null)
			this.head = node;
		else
			next.setNext(node);

		node.setNext(null);
		return node;
	}
	
	public void reserveListIterative(Node node) {
		Node preNode = null;
		Node currNode = head;
		
		while(currNode != null) {
			Node nextNode = currNode.getNext();
						
			currNode.setNext(preNode);
			preNode = currNode;
			
			if(nextNode == null) 
				head = currNode;
			
			currNode = nextNode;
		}
		
	}

	public void print1() {
		print(head);

	}

	public void print(Node curr) {

		if (curr == null)
			return;

		System.out.println(curr.getData());

		print(curr.getNext());
	}

	public static class Node {
		private int data;
		private Node next;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node(int d) {
			this.data = d;
		}

		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

	}
}
