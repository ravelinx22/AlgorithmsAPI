package Estructuras_de_datos_implementaciones;
import Estructuras_de_datos_interfaces.IBinaryTree;

public class BinaryTree <Key extends Comparable<Key>, Value> implements IBinaryTree<Key, Value> {

	private Node root;

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	public Value get(Key key) {
		return get(root,key);
	}

	public int size() {
		return size(root);
	}

	public Key min() {
		return min(root).key;
	}

	public Key floor(Key key) {
		Node node = floor(root, key);
		if(node == null) return null;
		return node.key;
	}
	
	public int rank(Key key){
		return rank(root, key);
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	public void deleteMax() {
		root = deleteMax(root);
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	// Helpers

	private Node put(Node node, Key key, Value value) {
		if(node == null) return new Node(key, value, 1);

		int cmp = key.compareTo(node.key);

		if(cmp < 0) node.left = put(node.left, key, value);
		else if(cmp > 0) node.right = put(node.right, key, value);
		else node.value = value;

		node.N = size(node.left) + size(node.right) + 1;

		return node;
	}

	private Value get(Node node, Key key) {
		if(node == null) return null;

		int cmp = key.compareTo(node.key);

		if(cmp < 0) return get(node.left, key);
		else if(cmp > 0) return get(node.right, key);
		else return node.value;
	}

	private int size(Node node) {
		if(node == null) return 0;
		else return node.N;
	}

	private Node min(Node node) {
		if(node.left == null) return node;
		return min(node.left);
	}

	private Node floor(Node node, Key key) {
		if(node == null) return null;
		int cmp = key.compareTo(node.key);
		if(cmp == 0) return node;
		if(cmp < 0) return floor(node.left, key);

		Node t = floor(node.right, key);
		if(t != null) return t;
		else return node;
	}
	
	private int rank(Node node, Key key) {
		if(node == null) return 0;
		
	    int cmp = key.compareTo(node.key);
	    
	    if(cmp < 0) return rank(node.left, key);
	    else if(cmp > 0) return 1 + size(node.left) + rank(node.right, key);
	    else return size(node.left);
	    
	}
	
	private Node deleteMin(Node node) {
		if(node.left == null) return node.right;
		node.left = deleteMin(node.left);
		node.N = 1 + size(node.left) + size(node.right);
		
		return node;
	}
	
	private Node deleteMax(Node node) {
		if(node.right == null) return node.left;
		node.right = deleteMax(node.right);
		node.N = 1 + size(node.left) + size(node.right);
		
		return node;
	}
	
	private Node delete(Node node, Key key) {
		if(node == null) return null;
		int cmp = key.compareTo(node.key);
		
		if(cmp < 0) {
			return delete(node.left, key);
		} else if( cmp > 0) {
			return delete(node.right, key);
		} else {
			if(node.left == null) return node.right;
			if(node.right == null) return node.left;
			
			Node t = node;
			node = min(t.right);
			node.right = deleteMin(t.right);
			node.left = t.left;
		}
		
		node.N = 1+ size(node.left) + size(node.right);
		return node;
	}
	
	// Private Classes 

	private class Node {

		Key key;
		Value value;
		Node left;
		Node right;
		int N;

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}
}
