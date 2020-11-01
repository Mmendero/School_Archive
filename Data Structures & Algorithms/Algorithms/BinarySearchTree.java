package Algorithms;

import DataStructures.TreeNode;

public class BinarySearchTree {
	public TreeNode root;
	
	public BinarySearchTree () {
		root = null;
	}
	
	public void inorder_tree_walk (TreeNode x) {
		if(x != null) {
			inorder_tree_walk(x.left);
			System.out.println(x.key);
			inorder_tree_walk(x.right);
		}
	}
	
	public TreeNode search (TreeNode x, int k) {
		if(x == null || k == x.key) 
			return x;
		if(k < x.key) 
			return search(x.left, k);
		else
			return search(x.right, k);
	}
	
	public TreeNode iterative_search (int k) {
		TreeNode x = root;
		while(x != null && k != x.key) {
			if(k < x.key)
				x = x.left;
			else
				x = x.right;
		}
		return x;
	}
	
	public TreeNode minimum () {
		TreeNode curr = root;
		while(curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}	
	
	public TreeNode maximum () {
		TreeNode curr = root;
		while(curr.right != null) {
			curr = curr.right;
		}
		return curr;
	}
	
	public TreeNode successor (TreeNode x) {		
		TreeNode successor;
		if(x.right != null) {
			TreeNode oldRoot = root;
			root = x.right;
			successor = minimum();
			root = oldRoot;
			return successor;
		}
		successor = x.p;
		while(successor != null && x == successor.right) {
			x = successor;
			successor = successor.p;
		}
		return successor;
		
	}
	
	public void insert (int k) {
		TreeNode y = null;
		TreeNode x = root;
		TreeNode newNode = new TreeNode(k);
		
		while(x != null) {
			y = x;
			if(newNode.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		
		newNode.p = y;
		
		if(y == null)
			root = newNode;
		else if(newNode.key < y.key)
			y.left = newNode;
		else
			y.right = newNode;
		
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
	}

}
