/*
 * Homework 4 - TreeNode.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * October 11, 2018
 */

/*
 * CSIT 212 Homework 4 - Binary Search Tree
 * This program is used to create TreeNode objects
 */

package ds;

public class TreeNode {
	public int key;
	public TreeNode p;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode () {
		p = left = right = null;
	}
	
	public TreeNode (int k) {
		key = k;
		p = left = right = null;
	}
}
