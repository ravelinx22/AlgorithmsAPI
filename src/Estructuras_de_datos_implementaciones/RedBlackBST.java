package Estructuras_de_datos_implementaciones;

import Estructuras_de_datos_interfaces.IRedBlackBST;

public class RedBlackBST <Key extends Comparable<Key>, Value> implements IRedBlackBST<Key, Value> {

	// Constants
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	// Atributes
	
	private Node root;
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
		root.color = BLACK;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	public void delete(Key key)
	{
	   if (!isRed(root.left) && !isRed(root.right))
	      root.color = RED;
	   root = delete(root, key);
	   if (!isEmpty()) root.color = BLACK;
	}

	// Helpers
	
	public Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	public Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	public void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public int size() {
		return size(root);
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void deleteMax()
    {
       if (!isRed(root.left) && !isRed(root.right))
          root.color = RED;
       root = deleteMax(root);
       if (!isEmpty()) root.color = BLACK;
    }
    
    public void deleteMin()
    {
       if (!isRed(root.right) && !isRed(root.left))
          root.color = RED;
       root = deleteMax(root);
       if (!isEmpty()) root.color = BLACK;
    }
    
    
	
	// Private Methods
	
	private Node put(Node node, Key key, Value val) {
		if(node == null) return new Node(key, val, 1, RED);
		
		int cmp = key.compareTo(node.key);
		
		if(cmp < 0) node.left = put(node.left, key, val);
		else if(cmp > 0) node.right = put(node.right, key, val);
		else node.val = val;
		
		if(isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
		if(isRed(node.left) && !isRed(node.right)) node = rotateRight(node);
		if(isRed(node.left) && isRed(node.right)) flipColors(node);
		
		node.N = 1 + size(node.left) + size(node.right);
		return node;
	}
	
	private boolean isRed(Node node) {
		if(node == null) return false;
		return node.color == RED;
	}
	
	private int size(Node node) {
		if(node == null) return 0;
		else return node.N;
	}
	
	private Node delete(Node node, Key key) {
		if(key.compareTo(node.key) < 0) {
			if(!isRed(node.left) && !isRed(node.left.left)) 
				node = moveRedLeft(node);
			
			node.left = delete(node.left, key);
		} else {
			if(isRed(node.left))
				node = rotateRight(node);
			
			if(key.compareTo(node.key) == 0 && (node.right == null))
				return null;
			if(!isRed(node.right) && !isRed(node.right.left))
				node = moveRedRight(node);
			if(key.compareTo(node.key) == 0) {
				node.val = get(node.right, min(node.right).key);
				node.key = min(node.right).key;
				node.right = deleteMin(node.right);
			}
			else 
				node.right = delete(node.right, key);
		}
		return balance(node);
	}
	
      private Node deleteMax(Node h)
      {
         if (isRed(h.left))
             h = rotateRight(h);
         if (h.right == null)
            return null;
         if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);
         h.right = deleteMax(h.right);
         return balance(h);
      }
      
      private Node deleteMin(Node h)
      {
         if (isRed(h.right))
             h = rotateLeft(h);
         if (h.left == null)
            return null;
         if (!isRed(h.left) && !isRed(h.left.right))
            h = moveRedLeft(h);
         h.left = deleteMax(h.left);
         return balance(h);
      }
	
	private Node balance(Node node) {
		if(isRed(node.right))
			node = rotateLeft(node);
		return node;
	}
	private Value get(Node node, Key key) {
		if(node == null) return null;
		int cmp = key.compareTo(node.key);
		
		if(cmp < 0) return get(node.left, key);
		else if(cmp > 0) return get(node.right, key);
		else return node.val;
	}
	
	private Node min(Node node) {
		if(node.left == null) return node;
		return min(node.left);
	}
	
	private Node moveRedRight(Node node) {
		flipColors(node);
		if(!isRed(node.left.left))
			node = rotateRight(node);
		
		return node;
	}
	
	private Node moveRedLeft(Node node) {
		flipColors(node);
		if(!isRed(node.right.right))
			node = rotateLeft(node);
		
		return node;
	}
	
	// Private Classes
	
	private class Node {
		Key key;
		Value val;
		Node left;
		Node right;
		int N;
		boolean color;
		
		Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
}
