/*
 * Homework 3 - Queue.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * October 10, 2018
 */

/*
 * CSIT 212 Homework 3 - Stack, Queue and Linked List
 * This program contains the implementation of
 * the enqueue and dequeue methods of a queue.
 */

package ds;

public class Queue {
	
	// Constructors given by the professor
	public int size;
	public int[] array;
	public int head;
	public int tail;
	
	public Queue () {
		size = 0;
		array = null;
		head = -1;
		tail = 0;
	}
	
	public Queue (int _size) {
		size = _size;
		array = new int[size];
		head = -1;
		tail = 0;
	}
	
	/*
	 * Implement the ENQUEUE(x) function
	 */
	public void enqueue (int x) {
		
		// Bonus Credit: Checks if the queue is full
		if(head == tail) {
			System.err.println("Queue is Full");
		} 
		else {
			array[tail] = x;
			
			/* 
			 * only needed because of the given for loop
			 * in the toString method */
			if (head == -1) {
				head = 0;
			}
			
			if(tail == size) { 		
				tail = 0;
			} else {
				tail++;
			}
			//System.out.println(tail);
		}
	}
	
	/*
	 * Implement the DEQUEUE() function
	 */
	public int dequeue () {
		int x = array[head];
		
		// Bonus Credit: checks if the queue is empty
		if ((head + 1) % size == tail ) {
			System.err.println("Queue is Empty");
		} else {
			if(head == size) {			
				head = 0;
			} else {
				head++;
			}
			
		}
		return x;
	}
	
	/*
	 * All of the methods from here down were given by the professor
	 * Convert queue to string in the format of #size, head, tail, [#elements]
	 */
	public String toString () {
		String str;
		
		str = size + ", " + head + ", " + tail + ", [";
		for (int i = head; i%size < tail; i++) {
			str += array[i] + ",";
			//System.out.println(i%size + ", " + i);
		}
		
		str += "]";
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q;
		
		q = new Queue(10);
		for (int i = 0; i < 5 ; i++)
			q.enqueue(i);
		System.out.println(q.toString());
		for (int i = 0; i < 2; i++) 
			q.dequeue();
		System.out.println(q.toString());
	}

}
