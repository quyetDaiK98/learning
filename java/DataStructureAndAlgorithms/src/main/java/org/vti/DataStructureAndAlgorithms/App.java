package org.vti.DataStructureAndAlgorithms;

/**
 * Hello world!
 *
 */



public class App 
{
	public static int powersOf2(int n) {
		 if (n == 1) {
			System.out.println(1);
			return 1;
		}
		else {
			int prev = powersOf2(n / 2);
			int curr = 2 * prev;
			System.out.println(curr);
			return curr;
		}
	}
	
    public static void main( String[] args )
    {
    	String a = "quyết";
    	System.out.println((int)a.charAt(3));
    	
    	
    	MyLinkedList l = new MyLinkedList();
    	l.append(1);
    	l.append(2);
    	l.append(3);
    	l.append(4);
//    	l.reserveListRecursive(l.getHead());
    	l.reserveListIterative(l.getHead());
    	l.print1();
    }
}
