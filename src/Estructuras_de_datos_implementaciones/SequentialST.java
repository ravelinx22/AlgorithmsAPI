package Estructuras_de_datos_implementaciones;

import Estructuras_de_datos_interfaces.ISymbolTable;

public class SequentialST <Key extends Comparable<Key>,Value> implements ISymbolTable<Key, Value> {
	
	private Node first;
	private int N;
	
	public void put(Key k, Value v) {
		
		for(Node current = first; current != null; current = current.next) {
			if(current.key.equals(k)) {
				current.value = v;
				return ;
			}
		}
		
		first = new Node(k, v, first);
		N++;
	}
	
	public Value get(Key k) {
		
		for(Node current = first; current != null; current = current.next) {
			if(current.key.equals(k)) {
				return current.value;
			}
		}
		
		return null;
	}
	
	public void delete(Key key) {
		if(first == null) return;
		
		for(Node current = first; current.next != null; current = current.next) {
			if(current.next.key.equals(key)) {
				current.next = current.next.next;
			}
		}
		
		N--;
	}
	
	public int size() {
		return N;
	}
	
	public boolean contains(Key k) {
		if(k == null) return false;
		
		for(Node current = first; current != null; current = current.next)
			if(current.key.equals(k))
				return true;
		
		return false;
	}
	
	public Iterable<Key> keys() {
		LinkedList<Key> k = new LinkedList<Key>();
		
		for(Node current = first; current != null; current = current.next) {
			k.add(current.key);
		}
		
		return k;
	}
	
	// Clases privadas
	
	private class Node {
		Key key;
		Value value;
		Node next;
		
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}
