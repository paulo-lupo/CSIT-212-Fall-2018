/*
 * Homework 5 - RodCut.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * October 19, 2018
 */

/*
 * CSIT 212 Homework 5 - Dynamic Programming I
 * This program solves the rod cut problem using Dynamic Programming
 */

package dp;

public class RodCut {
	int n;
	int[] p;
	int[] r;
	int[] s;
	
	// initializes the rod cut example from the textbook.
	public RodCut () {
		n = 10;
		p = new int[11];
		p[0] = 0;
		p[1] = 1;
		p[2] = 5;
		p[3] = 8;
		p[4] = 9;
		p[5] = 10;
		p[6] = 17;
		p[7] = 17;
		p[8] = 20;
		p[9] = 24;
		p[10] = 30;
	}
	
	// fills in the array r with negative infinity and calls the memoized method
	public int memoized_cut_rod () {
		r = new int[n+1];
		for (int i = 0; i <= n; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		return memoized_cut_rod_aux (p, n, r);
	}
	
	// auxiliary method that gives us the max revenue for each cut
	public int memoized_cut_rod_aux (int p[], int n, int r[]) {
		int q;
		if (r[n] >=0) {
			return r[n];
		}
		
		if (n == 0) {
			q = 0;
		} else {
			q = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++) {
				q = Math.max(q, (p[i]+memoized_cut_rod_aux (p, n-i, r)));
			}
		}
		r[n] = q;
		return q;
	}
	
	// bottom-up cut: only gives max revenue r[j]
	public int bottom_up_cut_rod () {
		r = new int[n+1];
		r[0] = 0;
		int q;
		for (int j = 1; j <= n; j++) {
			q = Integer.MIN_VALUE;
			for (int i= 1; i <= j; i++) {
				q = Math.max(q, p[i] + r[j-i]);
			}
			r[j] = q;
		}
		return r[n];
	}
	
	/* 
	 * extended bottom-up cut method gives max revenue r[j]
	 * and optimal size of first piece to cut off s[j] 
	 */
	public void extended_bottom_up_cut_rod () {
		r = new int[n+1];
		s = new int [n+1];
		int q;
		for (int j = 1; j <= n; j++) {
			q = Integer.MIN_VALUE;
			for (int i = 1; i <= j; i++) {
				if (q < (p[i] + r[j-i])) {
					q = p[i] + r[j-i];
					s[j] = i;	
				}
				
			}
			r[j] = q;
		}
	}

	public void print_cut_rod_solution () {
		for (int i = 0; i <= n; i++) {
			System.out.print(i + "\t");
		}
		System.out.print("\n");
		for (int i = 0; i <= n; i++) {
			System.out.print(r[i] + "\t");
		}
		System.out.print("\n");
		for (int i = 0; i <= n; i++) {
			System.out.print(s[i] + "\t");
		}
		System.out.print("\n");
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RodCut rc;
		
		rc = new RodCut();
		System.out.println("memoized_cut_rod starts ------------------");
		System.out.println(rc.memoized_cut_rod());
		System.out.println("memoized_cut_rod ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("bottom_up_cut_rod starts ------------------");
		System.out.println(rc.bottom_up_cut_rod());
		System.out.println("bottom_up_cut_rod ends ------------------");
		System.out.print("\n\n");

		System.out.println("extended_bottom_up_cut_rod starts ------------------");
		rc.extended_bottom_up_cut_rod();
		rc.print_cut_rod_solution();
		System.out.println("extended_bottom_up_cut_rod ends ------------------");
		System.out.print("\n\n");
	}

}
