/*
 * Homework 7 - Graph.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * November 8, 2018
 */

/*
 * CSIT 212 Homework 7 - BFS & DFS
 * This program contains the implementation of the 
 * Breath and Depth First Search Algorithms 
 */

package graph;

import ds.Queue;

public class Graph {
	public int n;		//number of vertices
	public int[][] A;	//the adjacency matrix
	private final int WHITE = 2;
	private final int GRAY = 3;
	private final int BLACK = 4;
	public int time;
	
	public Graph () {
		n = 0;
		A = null;
	}
	
	public Graph (int _n, int[][] _A) {
		this.n = _n;
		this.A = _A;
	}
	
	/*
	 * Input: s denotes the index of the source node
	 * Output: the array dist, where dist[i] is the distance between the i-th node to s
	 */
	public int[] bfs (int s) {
		
		/* 
		 * creates an array to store the color
		 * and an array to store the distance from the source 
		 */
		int[] color = new int[n];
		int[] distance = new int[n];
		
		/* 
		 * initialize the arrays with WHITE as color
		 * and infinity as the distance of each node 
		 * */
		for (int i = 0; i < n; i++) {
			color[i] = WHITE;
			distance[i] = Integer.MAX_VALUE;
		}
		
		// Source turns GRAY and its distance is 0
		color[s] = GRAY;
		distance[s] = 0;
		
		// Creates a queue and put the source in it
		Queue Q = new Queue(n);
		Q.enqueue(s);
		
		/* 
		 * as long as the queue is not empty travel to all
		 * of the nodes until they all turn BLACK 
		 */
		while (!Q.isEmpty()) {
			
			// removes an element from the queue and assigns it as a pseudo-source
			s = Q.dequeue();
			
			/* 
			 * checks adjacent nodes, if they are WHITE, turn them GRAY
			 * and updates the distance from them to the initial source node
			 * lastly adds the node to the queue 
			 */
			for (int j = 0; j < n; j++) {
				if(A[s][j] == 1 && color[j] == WHITE) {
					color[j] = GRAY;
					distance[j] = distance[s]+1;
					Q.enqueue(j);	
				}
			}
			
			// once all the adjacent nodes are visited, turn the node BLACK
			color[s] = BLACK;
		}
		// returns the distance between the nodes and the source nodes
		return distance;
	}
	
	/*
	 * DFS() method starts at node 0, visits all nodes that are
	 * part of the linked connection to that node.
	 * Output: returns the time each node turned black
	 */
	public int[] DFS() {
		
		/* 
		 * Creates arrays to store the color, the time the node turned GRAY
		 * and the time the node turned BLACK
		 */
		int[] color = new int[n];
		int[] timeGray = new int[n];
		int[] timeBlack= new int[n];
		
		// Initialize the colors of all nodes to be WHITE
		for (int i = 0; i < n; i++) {
			color[i] = WHITE;
		}
		
		// Starts the time at 0
		time = 0;
		
		// Starting from node 0, visits all of the nodes that are connected to it somehow
		for (int i = 0; i < n; i++) {
			if (color[i] == WHITE) {
				DFS_Visit(i, color, timeGray, timeBlack);
			}
		}
		
		// returns the time the nodes turned BLACK
		return timeBlack;
	}
	
	// Takes the arrays from the DFS Method and updates after it traverses the nodes
	public void DFS_Visit(int s, int[] color, int[] timeGray, int[] timeBlack) {
		
		// Increases the time, turns the node GRAY and stores the time that happened
		time = time +1;
		color[s] = GRAY;
		timeGray[s] = time;
		
		// Visits adjacent vertices that have not been visited at all
		for (int j = 0; j < n; j++) {
			if(A[s][j] == 1 && color[j] == WHITE) {
				DFS_Visit(j, color, timeGray, timeBlack);
			}
		}
		
		/* 
		 * After visiting all of the WHITE adjacent nodes
		 * turns the node to BLACK and stores the time that happened 
		 */
		time = time +1;
		color[s] = BLACK;
		timeBlack[s] = time;
	}
	
	
	public void print_array (int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.println(i + ": " + array[i]);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int[][] A = 
			{{0, 1, 0, 0, 1, 0, 0, 0},
			{ 1, 0, 0, 0, 0, 1, 0, 0},
			{ 0, 0, 0, 1, 0, 1, 1, 0},
			{ 0, 0, 1, 0, 0, 0, 1, 1},
			{ 1, 0, 0, 0, 0, 0, 0, 0},
			{ 0, 1, 1, 0, 0, 0, 1, 0},
			{ 0, 0, 1, 1, 0, 1, 0, 1},
			{ 0, 0, 0, 1, 0, 0, 1, 0}};
		Graph g = new Graph(n, A);
		
		System.out.println("Using BFS: ");
		g.print_array(g.bfs(1));
		
		System.out.println("\nUsing DFS: ");
		g.print_array(g.DFS());
	}
}
