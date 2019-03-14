/*
 * Homework 8 - PrimNode.java
 * Joao Paulo D. S. Ferreira
 * CSIT 212 - Data Structures and Algorithms
 * Dr. Boxiang Dong
 * November 15, 2018
 */

/*
 * CSIT 212 Homework 8 - Minimum Spanning Tree
 * This program is used to create PrimNode Objects
 * you can also compare nodes, change their keys,
 * set their parents and get any information from them
 */

package graph;

public class PrimNode implements Comparable<PrimNode> {
    public int id;
    public int key;
    public PrimNode parent;

    public PrimNode(int id, int key) {
        this.id = id;
        this.key = key;
    }

    public int compareTo(PrimNode o) {
        return (this.key - o.key);
    }
    
    // Returns the key (minimum weight) of that node
    public int getKey() {
    	return key;
    }
    
    // Changes the key value of the node
    public void setKey(int key) {
    	this.key = key;
    }
    
    // Returns the id of the node
    public int getId() {
    	return id;
    }
    
    // Sets the parent of the node
    public void setParent(PrimNode a) {
    	parent = a;
    }
    
    // Returns the id of the parent of the node
    public int getParent() {
    	return parent.id;
    }
}
