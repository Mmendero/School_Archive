package Algorithms;
import java.util.*;

public class Graph2 {
	
	public int n;	//number of vertice
	public int[][] A;	//the adjacency matrix
	
	public Graph2 () {
		n = 0;
		A = null;
	}
	
	public Graph2 (int _n, int[][] _A) {
		this.n = _n;
		this.A = _A;
	}
	
	public int prim (int r) {
		//Initialize Priority Queue and Iterator
		PriorityQueue<PrimNode> pqueue = new PriorityQueue<PrimNode>();
		Iterator<PrimNode> itr = pqueue.iterator();
		
		//Filling Queue with Default Nodes
		for(int i = 0; i < A.length; i++) {
			PrimNode node = new PrimNode(i, Integer.MAX_VALUE);
			if(node.id == r)
				node.key = 0;
			pqueue.add(node);
		}
		
		//initialize minimum node and counting variable
		PrimNode min = pqueue.peek();
		
		int totalweight = 0;
		while(itr.hasNext()) {
			
			//Extract minimum
			for(PrimNode node: pqueue) {
				System.out.println(node.id);
				if(node.compareTo(min) < 0)
					min = node;
				
			}
			System.out.println("------");
			//Increment and remove
			totalweight += min.key;
			pqueue.remove(min);
			

			//Assign Weights
			for(PrimNode node: pqueue) {
				if(A[min.id][node.id] > 0 && A[min.id][node.id] < node.key) {
					node.key = A[min.id][node.id];
				}
			}
		}
		
		return 3;
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
