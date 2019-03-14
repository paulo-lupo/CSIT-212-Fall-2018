/*
 * Homework 10 - Graph4.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * December 8, 2018
 */

/*
 * CSIT 212 Homework 10 - All Pair Shortest Path
 * This program contains the implementation of the 
 * All Pair Shortest path problem using Floyd-Warshall's
 * algorithm that involves dynamic programming
 */

package graph;

public class Graph4 {
	
	public int[][]A;
	public int n;
	
	public Graph4(int n_, int[][] A_) {
		A = A_;
		n = n_;
	}
	
	// floyd_warshall() method
	public int[][] floyd_warshall() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					/*
					 * Updates the matrix to be the min value of the distance between the direct distance 
					 * of one vertex to the other or the sum of the distance between the first vertex
					 * to a middle vertex plus the distance to the middle vertex to the end vertex
					 */
					A[i][j] = Math.min(A[i][j], A[i][k]+A[k][j]);
				} // end inner for
			} // end middle for
		} // end outer for
		
		// Returns the update matrix
		return A;
	}
	
	// Prints out the array in a nice way
	public String toString() {
		String s = "Pairwise shortest distance matrix:\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(A[i][j] < 0 || A[i][j] > 9)
					s += A[i][j]+ "  ";
				else
					s += " "+ A[i][j]+ "  ";
			} // end inner for
			s += "\n";
		} // end outer for
		
		return s;
	}
	
	public static void main(String[] args) {
		
		/*
		 * Defines infinity as half of the max integer value in java
		 * To avoid overflow during the floyd_warshall method
		 */
		int inf = Integer.MAX_VALUE/2;
		int n = 5;
		
		// Array representing the given problem
		int[][] A = {
		{ 0,   3,   8,  inf, -4},
		{inf,  0,  inf,  1,   7},
		{inf,  4,   0,  inf, inf},
		{ 2,  inf, -5,   0,  inf},
		{inf, inf, inf,  6,   0}
		};
		
		Graph4 g = new Graph4(n, A);
		g.floyd_warshall();
		System.out.println(g.toString());
	}
}
