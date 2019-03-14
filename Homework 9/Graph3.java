/*
 * Homework 9 - Graph3.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * November 29, 2018
 */

/*
 * CSIT 212 Homework 9 - Single Source Shortest Path
 * This program contains the implementation of the 
 * Single Source Shortest path problem using 
 * Dijkstra and Bellman-Ford's Algorithms 
 */

package graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph3 {
	int n;
	int[][] A;
	int[] d;	//shortest distance
	
	int[] parent;		// parent of each node
	int initialSource;	// initial source node of the path
	/**
	 * @param args
	 */
	
	public Graph3 () {
		
	}
	
	public Graph3 (int _n, int[][] _A) {
		n = _n;
		A = _A;
		d = new int[n];
		
		parent = new int[n]; 	// Initializes the array to store the parent of each node
	}
	
	public void initialize_single_source(int s) {
		for (int i = 0; i < n; i++)
			d[i] = Integer.MAX_VALUE;
		d[s] = 0;
		
		initialSource = s; 	// Keeps track of the source used for the path calculations
	}
	
	public void relax (int u, int v) {
		if (d[v] > (d[u] + A[u][v])) {
			d[v] = d[u] + A[u][v];
			
			parent[v] = u;		// Changes the parent of the node
		}
	}
	
	public boolean bellman_ford (int s) {
		// initializes the single source 
		initialize_single_source(s);
		
		// Boolean value returns false if there are negative weights
		boolean bellman_ford = true;
		
		// Initializes a queue and add the source node to it
		Queue<Integer> Q = new LinkedList<>();
		Q.add(s);
		
		int u;
		while (!Q.isEmpty()) {
			// Extracts the next node
			u = Q.poll(); 
		
			// Checks for adjacent edges to the extracted node
			for (int j = 0; j < n; j++) {
				if(A[u][j] != 0) {
					/*
					 * Only adds the item to the queue if the distance of the adjacent node
					 * is greater is greater than the possible shortest path distance to that node
					 */
					if (d[j] > (d[u] + A[u][j])) {
						Q.add(j);
					}
					// updates the shortest path distance
					relax(u, j);
				}
				
				// changes the value of the boolean to false if any of the edge weights are negative
				if (A[u][j] < 0) {
					bellman_ford = false;
				}
			}
		}
		return bellman_ford;
	}
	
	public void dijkstra (int s) {
		// initializes the single source
		initialize_single_source(s);
		
		// Initializes a Priority Queue with PrimNodes
		PriorityQueue<PrimNode> Q = new PriorityQueue<PrimNode>();
		
		// Initializes an array to store each node
		PrimNode[] node = new PrimNode[n];
		
		// Fills in the array and the queue with the nodes
		for(int i = 0; i < n; i++) {
			node[i] = new PrimNode(i, d[i]);
			Q.add(node[i]);
		}
		
		// Creates a PrimNode to be used for comparison
		PrimNode u;
		
		// As long as the Queue is not empty:
		while (!Q.isEmpty()) {
			// Extracts the smallest value of the Queue
			u = Q.poll();
			
			// Finds adjacent nodes to the extracted node that are still in the queue
			for (int j = 0; j < n; j++) {
				if(A[u.getId()][j] != 0 && Q.contains(node[j])) {
					
					// updates the distance for the shortest path
					relax(u.getId(), j);
					
					// changes the weight/key of the adjacent node
					node[j].setKey(d[j]);
					
					/* 
					 * removes the node from the priority queue and adds it to it again
					 * this way the node is added in the correct position in the queue.
					 */
					Q.remove(node[j]);
					Q.add(node[j]);
				} // end if
			} // end for
		} // end while
	}
	
	public void display_distance () {
		// Prints out the single source shortest path distance of each node
		for (int i = 0; i < n; i++) {
			System.out.println(i + ": " + d[i]);
		}
		
		// Prints out the shortest path of each node
		for (int i = 0; i < n; i++) {
			System.out.println("Shortest path to " + i + ": " + shortest_path(i));
		}
	}
	
	// Extra Credit: Prints the shortest path to a specific node
	public String shortest_path(int endNode) {
		
		String  s = "";
		
		// Stores the node at the end of the path
		int temp = endNode;
		
		/*
		 * travel keeps track of the index of the node we are at during the path.
		 * We use travel to get the parent of the next node we'll be traveling to
		 */
		int travel = endNode;
		
		/*
		 * As long as the parent of the node and the node we're at 
		 * is not the same as the initial source 
		 * (given that the parent of the initial source is initialized as 0)
		 */
		while (!(parent[travel] == 0 && travel == initialSource)) {
			s = parent[travel] + " --> " + s;
			travel = parent[travel];
		}
		
		// adds in the node at the end of the path
		s += temp;
		
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] A = {
		{0, 6, 0, 7, 0},
		{0, 0, 5, 8, -4},
		{0, -2, 0, 0, 0},
		{0, 0, -3, 0, 9},
		{2, 0, 7, 0, 0}
		};
		
		System.out.println("Bellman-Ford Algorithm:");
		Graph3 g1 = new Graph3(n, A);
		g1.bellman_ford(0);
		g1.display_distance();
		
		System.out.println("-----------------------");
		
		int[][] B = {
		{0, 10, 0, 5, 0},
		{0, 0, 1, 2, 0},
		{0, 0, 0, 0, 4},
		{0, 3, 9, 0, 2},
		{7, 0, 6, 0, 0}
		};
		Graph3 g2 = new Graph3(n, B);
		
		System.out.println("Dijkstra Algorithm:");
		g2.dijkstra(0);
		g2.display_distance();
		System.out.println("-----------------------");
	}
}