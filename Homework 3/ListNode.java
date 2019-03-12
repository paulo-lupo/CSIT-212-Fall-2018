/*
 * Homework 3 - ListNode.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * October 10, 2018
 */

/*
 * CSIT 212 Homework 3 - Stack, Queue and Linked List
 * This method was given by the professor.
 * Used to create ListNode objects
 */

package ds;

public class ListNode {
	public int key;
	public ListNode prev;
	public ListNode next;
	
	public ListNode () {
		prev = next = null;
	}
	
	public ListNode (int _key) {
		key = _key;
		prev = next = null;
	}
}
