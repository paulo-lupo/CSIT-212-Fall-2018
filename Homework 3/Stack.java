/*
 * Homework 3 - Stack.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * October 10, 2018
 */

/*
 * CSIT 212 Homework 3 - Stack, Queue and Linked List
 * This program contains the implementation of
 * the empty, push and pop methods of a stack.
 */

package ds;

public class Stack {
	
	// Constructors given by the professor
	public int size;
	public int top;
	public int[] array;
	
	public Stack () {
		size = 0;
		top = -1;
		array = null;
	}
	
	public Stack (int _size) {
		size = _size;
		top = -1;
		array = new int[size];
	}
	
	/*
	 * Implement the Stack-Empty(S) function
	 */
	public boolean empty () {
		// checks if the stack is empty
		if (top == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * Implement the Push(S, x) function
	 */
	public void push (int x) {
		// Bonus Credit: checks if the stack is full
		if(top == 9) {
			System.err.println("The stack is full");
		} else {
			// increments the top index
			top++;
			
			// adds the element to the top
			array[top] = x;
		}
	}
	
	/*
	 * Implement the Pop(S) function
	 * Return -1 if the stack is empty
	 */
	public int pop () {
		// Bonus Credit: Checks if the stack is empty
		if (empty()) {
			System.err.println("The Stack is empty");
		}
		else {
			// decreases the top index
			top--;
		}
		return array[top+1];
	}
	
	/*
	 * All of the methods from here down were given by the professor
	 * Convert stack to string in the format of #size, [#elements]
	 */
	public String toString () {
		String str;
		
		str = size + ", [";
		for (int i = 0; i <= top; i++)
			str += array[i] + ", ";
		
		str += "]";
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s;
		
		s = new Stack(10);
		for (int i = 0; i < 5; i++)
			s.push(i);
		System.out.println(s.toString());
		
		for (int i = 0; i < 2; i++)
			s.pop();
		System.out.println(s.toString());
	}

}
