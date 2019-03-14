/*
 * Homework 8 - Graph2.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * November 15, 2018
 */

/*
 * CSIT 212 Homework 8 - Minimum Spanning Tree
 * This program contains the implementation of the 
 * Minimum Spanning Tree problem using Prim's Algorithm
 */

package graph;
import java.util.*;

public class Graph2 {
	
	public int n;		// number of vertices
	public int[][] A;	// the adjacency matrix
	
	public Graph2 () {
		n = 0;
		A = null;
	}
	
	public Graph2 (int _n, int[][] _A) {
		this.n = _n;
		this.A = _A;
	}
	
	public int prim (int r) {
		
		// Stores nodes in an array of nodes
		PrimNode[] node = new PrimNode[n];
		PrimNode[] parent = new PrimNode[n];
		
		// Stores the total weight of the minimum spanning tree
		int totalWeight =0;
		
		// Creates a priority queue of Nodes
		PriorityQueue<PrimNode> Q = new PriorityQueue<PrimNode>();
		
		// Initializes the nodes and stores them in the nodes array
		for (int i = 0; i < n; i++) {
			// Initializes the root of the tree with key/weight 0;
			if (i == r) {
				node[i] = new PrimNode(r, 0);
			} 
			// Initializes the key of non-root nodes to be 'infinity'
			else {
				node[i] = new PrimNode(i, Integer.MAX_VALUE);
			}
			
			// Initializes all the nodes parents as null
			node[i].setParent(null);
			
			// Adds the nodes to the priority queue
			Q.add(node[i]);
		}
		
		// As long as the queue is not empty:
		while(!Q.isEmpty()) {
			
			// Extracts the node with  the smallest key value
			PrimNode u = Q.poll();
			
			// Adds its weight to the total weight
			totalWeight += u.getKey();
			
			
			for (int j = 0; j < n; j++) {
				/* 
				 * 1. Finds the adjacent nodes to the extracted node
				 * 2. Checks if the adjacent node is in the Queue
				 * 3. Checks if the key value of the node is greater than the edge weight
				 *    that connects the extracted node and the adjacent node
				 */

				if (A[u.getId()][j] != 0 && Q.contains(node[j]) && A[u.getId()][j] < node[j].getKey()) {
					// Assigns the key/weight of the adjacent node to be the edge weight
					node[j].setKey(A[u.getId()][j]);
					
					// Sets the adjacent parent node to be the extracted node
					node[j].setParent(u);
					
					/* 
					 * removes the node from the priority queue and adds it to it again
					 * this way the node is added in the correct position in the queue.
					 */
					Q.remove(node[j]);
					Q.add(node[j]);
				}
			}
		}
		
		// Returns the total weight of the Minimum Spanning tree
		System.out.println("The total weight of the Minimum Spanning Tree is: ");
		return totalWeight;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int A[][] = {
				{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
				{4, 0, 8, 0, 0, 0, 0, 11, 0}, 
				{0, 8, 0, 7, 0, 4, 0, 0, 2}, 
				{0, 0, 7, 0, 9, 14, 0, 0, 0}, 
				{0, 0, 0, 9, 0, 10, 0, 0, 0}, 
				{0, 0, 4, 14, 10, 0, 2, 0, 0}, 
				{0, 0, 0, 0, 0, 2, 0, 1, 6}, 
				{8, 11, 0, 0, 0, 0, 1, 0, 7}, 
				{0, 0, 2, 0, 0, 0, 6, 7, 0} 
		};
		Graph2 g = new Graph2(n, A);
		System.out.println(g.prim(0));
	}
}
