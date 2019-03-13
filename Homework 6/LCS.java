/*
 * Homework 6 - LCS.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * October 11, 2018
 */

/*
 * CSIT 212 Homework 6 - Dynamic Programming II
 * This program solves the Largest Common Sequence problem
 * by using Dynamic Programming
 */

package dp;

public class LCS {
	
	public static int lcs_length (String X, String Y) {
		int m = X.length();
		int n = Y.length();
		
		// b is not really needed for this problem
		String[][] b = new String[m][n];
		
		// creates a table of size m+1 by n+1
		int[][] c = new int[m+1][n+1];
		
		// fills in the first column but c[0][0] with 0's
		for (int i = 1; i <= m; i++) {
			c[i][0] = 0;
		}
		
		// fills in the first row with 0's
		for (int j = 0; j <= n; j++) {
			c[0][j] = 0;
		}
		
		// compares all of the characters and fills the tables accordingly
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				
				/* 
				 * if the characters are equals increment the top left value with 
				 * reference to c[i][j] by 1 and place it on c[i][j]
				 */
				if (X.charAt(i-1) == Y.charAt(j-1)) {
					c[i][j] = c[i-1][j-1]+1;
					b[i-1][j-1] = "top Left";
				}
				
				/* 
				 * if they are not equals but the value at the left of c[i][j]
				 * is greater than or equals to the value at the top of c[i][j],
				 * copy the value at the top of c[i][j] and place it at c[i][j] 
				 * */
				else if (c[i-1][j] >= c[i][j-1]) {
					c[i][j] = c[i-1][j];
					b[i-1][j-1] = "Top";
				} 
				
				/* 
				 * if they are not equals and the value at the left of c[i][j]
				 * is not greater than the value at the top of c[i][j], 
				 * copy the value at the left of c[i][j] and place it at c[i][j] */
				else {
					c[i][j]=c[i][j-1];
					b[i-1][j-1] = "Left";
				}
			}
		}
	
		/* 
		 * returns the size of the largest common subsequence
		 * which is store at the bottom right of the table (last element) 
		 */
		return c[m][n];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LCS.lcs_length("ABCBDAB", "BDCABA"));
		System.out.println(LCS.lcs_length("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA"));
	}
}
