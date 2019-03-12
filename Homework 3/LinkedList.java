/*
 * Homework 3 - LinkedList.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * October 10, 2018
 */

/*
 * CSIT 212 Homework 3 - Stack, Queue and Linked List
 * This program initializes a linked list
 * the search, insert and delete methods are also implemented
 */

package ds;

public class LinkedList {
	
	public ListNode head;
	
	public LinkedList () {
		head = null;
	}
	
	// method to check if a node with key value k exists in the list
	public ListNode search (int k) {
		// starts the search at the head
		ListNode y = head;
		
		/*
		 * searches through all of the values until 
		 * it is found or there are no more elements to be searched.
		 */
		while (y != null && y.key !=k) {
			y = y.next;
		}
		
		return y;
	}
	
	// method to insert a node with key x into the linked list
	public void insert (int x) {
		
		// initializes a node z with x as its key value
		ListNode z= new ListNode(x);
		
		// creates the link between z and the current head
		z.next = head;
		
		// makes sure the head has a value so the link can exist
		if (head != null) {
			head.prev = z;
		}
		
		// assigns the inserted node to become the new head.
		head = z;
	}

	// method to delete a node from the linked list
	public void delete (ListNode x) {
		
		/*
		 * if there is a node before the node to be deleted:
		 * creates a link between the previous node and the next node
		 * this removes the "previous" link to the node being deleted
		 */
		if (x.prev != null) {
			x.prev.next = x.next;
			
		// otherwise, assigns the next node to become the new head
		} else {
			head = x.next;
		}
		
		/*
		 * if there is a node after the node to be deleted:
		 * creates a link between the next node and the previous node
		 * this removes the "next" link to the node being deleted
		 */
		if (x.next != null) {
			x.next.prev = x.prev;
		}
	}
	
	/* 
	 * All of the methods from here down were given by the professor
	 * Convert a LinkedList to a string in the format of [#elements]
	 */
	public String toString () {
		String str;
		ListNode n;
		
		str = "[";
		n = this.head;
		while (n != null) {
			str += n.key + ",";
			n = n.next;
		}
		
		str += "]";
		return str;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l;
		
		l = new LinkedList();
		for (int i = 0; i < 5; i++)
			l.insert(i);
		System.out.println(l.toString());
		for (int i = 0; i < 2; i++) 
			l.delete(l.head.next);
		System.out.println(l.toString());
	}
}
