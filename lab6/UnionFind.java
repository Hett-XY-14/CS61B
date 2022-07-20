/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unionfind;

import java.util.ArrayList;

public class UnionFind {
    int[] parent;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parent = new int[n];
        // set all the parents to be -1 to symbolize that they are disjoint
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid vertex. */
    private void validate(int v1) {
        if (v1 < 0 || v1 > parent.length) {
            throw new IllegalArgumentException("Not a valid vertex!");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        int root = find(v1);
        return -1 * parent[root];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        return parent[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean isConnected(int v1, int v2) {
        pathCompression(v1,v2);
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Connecting a
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void connect(int v1, int v2) {
        // First of all, we need to validate the inputs
        validate(v1);
        validate(v2);
        //let's connect both numbers
        int rootV1 = find(v1);
        int rootV2 = find(v2);
        int sizeV1 = parent[rootV1];
        int sizeV2 = parent[rootV2];

        if (sizeV1 < sizeV2) {
            parent[rootV2] = rootV1;
            parent[rootV1] = sizeV1 + sizeV2;
        } else {
            parent[rootV1] = rootV2;
            parent[rootV2] = sizeV1 + sizeV2;
        }
    }
    
    //path compression
    public void pathCompression(int v1, int v2) {
        if (isConnected(v1, v2)) {
            parent[v1] = find(v1);
            parent[v2] = find(v2);
        }
    }

    /* Returns the root of the set v1 belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int v1) {
        if (parent[v1] < 0) {
            return v1;
        } else {
            return find(parent[v1]);
        }
    }

    public void printArray() {
        for (int element : parent ) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        UnionFind test = new UnionFind(10);
        
        //test.printArray();
        
        test.connect(1,0);
        test.connect(4,2);
        test.connect(5,4);
        test.connect(3,2);
        test.connect(8,6);
        test.connect(7,6);

        test.printArray();
        
        test.connect(5,7);
        
        test.printArray();
	
	//Hi
    }
}

