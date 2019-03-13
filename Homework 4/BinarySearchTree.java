/*
 * Homework 4 - BinarySearchTree.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * October 11, 2018
 */

/*
 * CSIT 212 Homework 4 - Binary Search Tree
 * This program initializes a linked list
 * the search, insert and delete methods are also implemented
 */

package ds;

public class BinarySearchTree {
	
	public TreeNode root;
	
	public BinarySearchTree () {
		root = null;
	}
	
	// prints all of the elements in order from small to largest
	public void inorder_tree_walk (TreeNode x) {
		if (x != null) {
			/* 
			 * starts from the left most node (smallest)
			 * ends at right most node (largest)
			 */
			inorder_tree_walk(x.left);
			System.out.println(x.key);
			inorder_tree_walk(x.right);
		}
	}
	
	// Extra Credit: prints all of the elements, printing the root first
	public void preorder_tree_walk (TreeNode x) {
		if (x != null) {
			/* 
			 * starts from the root, the goes to left nodes
			 * finally printing the right nodes
			 */
			System.out.println(x.key);
			preorder_tree_walk(x.left);
			preorder_tree_walk(x.right);
		}
	}
	
	// Extra Credit: prints all of the elements, printing the root last
	public void postorder_tree_walk (TreeNode x) {
		if (x != null) {
			/* 
			 * starts from the root, the goes to left nodes
			 * finally printing the right nodes
			 */
			preorder_tree_walk(x.left);
			preorder_tree_walk(x.right);
			System.out.println(x.key);
		}
	}
	
	// searches the nodes for a value
	public TreeNode search (TreeNode x, int k) {
		/* 
		 * checks if there is a root at all
		 * or if the root is the number being searched
		 */
		if (x == null || k == x.key) {
			return x;
		} if (k < x.key) {
			return search(x.left, k);
		} else {
			return search(x.right, k);
		}
	}
	
	// searches the nodes iteratively for a value
	public TreeNode iterative_search (int k) {
		// starts looking from the root
		TreeNode x = root;
		
		//checks if the the node with the value exists
		while (x != null && k != x.key) {
			// goes to left node until the number is found
			if (k < x.key) {
				x = x.left;
			// goes to right node until the number is found
			} else {
				x = x.right;
			}
		}
		return x;
	}
	
	// Finds the smallest node
	public TreeNode minimum () {
		// starts from the root and moves to the left most node (smallest)
		TreeNode x = root;
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	// Finds the largest node
	public TreeNode maximum () {
		// starts from the root and moves to the right most node (largest)
		TreeNode x = root;
		while (x.right != null) {
			x = x.right;
		}
		return x;
	}

	// finds the smallest node that is larger than a given node
	public TreeNode successor (TreeNode x) {
		/* 
		 * If there are nodes to the right
		 * finds the min node on the subtree to the right
		 */
		if (x.right != null) {
			BinarySearchTree bst = new BinarySearchTree();
			bst.root = x.right;
			return bst.minimum();
		}
		
		/* 
		 * if there are no nodes to the right
		 * starts looking from the parent of the node
		 * until the first "right turn" is made
		 */
		TreeNode y = x.p;
		while (x != null && x == y.right) {
			x = y;
			y = y.p;
		}
		return y;
	}
	
	// inserts a new node in its correct position on the tree
	public void insert (int k) {
		TreeNode y = new TreeNode();
		TreeNode x = root;
		TreeNode z = new TreeNode(k);
		
		// finds the node y that will be z's parent
		while (x != null) {
			y = x;
			if (k < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		
		// assigns z as the correct y's child 
		z.p = y;
		if (y.p == null) {
			root = z;
		} else if (z.key < y.key) {
			y.left = z;
		} else {
			y.right = z;
		}
	}
	
	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
		BinarySearchTree bst;
		TreeNode n;
		
		bst = new BinarySearchTree();
		for (int i = 0; i < array.length; i++)
			bst.insert(array[i]);
		System.out.println("Inorder_tree_walk starts ------------------");
		bst.inorder_tree_walk(bst.root);
		System.out.println("Inorder_tree_walk ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("Search starts ------------------");
		n = bst.search(bst.root, 13);
		System.out.println("found: " + n.key);
		System.out.println("Search ends ------------------");
		System.out.print("\n\n");

		System.out.println("Iterative search starts ------------------");
		n = bst.iterative_search(4);
		System.out.println("found: " + n.key);
		System.out.println("Iterative search ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("Minimum starts ------------------");
		n = bst.minimum();
		System.out.println("Minimum key is " + n.key);
		System.out.println("Minimum ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("Maximum starts ------------------");
		n = bst.maximum();
		System.out.println("Maximum key is " + n.key);
		System.out.println("Maximum ends ------------------");
		System.out.print("\n\n");

		System.out.println("Successor starts ------------------");
		n = bst.successor(bst.root.left.right.right);
		System.out.println("Successor key is " + n.key);
		System.out.println("Successor ends ------------------");
		System.out.print("\n\n");
		
		// Extra credit: Preorder tree walk
		System.out.println("Preorder_tree_walk starts ------------------");
		bst.preorder_tree_walk(bst.root);
		System.out.println("Preorder_tree_walk ends ------------------");
		System.out.print("\n\n");
		
		// Extra credit: Postorder tree walk
		System.out.println("Postorder_tree_walk starts ------------------");
		bst.postorder_tree_walk(bst.root);
		System.out.println("Postorder_tree_walk ends ------------------");
		System.out.print("\n\n");
	}

}
