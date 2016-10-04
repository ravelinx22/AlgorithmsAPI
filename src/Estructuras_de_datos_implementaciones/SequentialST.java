package Estructuras_de_datos_implementaciones;

import Estructuras_de_datos_interfaces.ISymbolTable;

public class SequentialST <Key extends Comparable<Key>,Value> implements ISymbolTable<Key, Value> {
	
	private Node first;
	
	public void put(Key k, Value v) {
		
		for(Node current = first; current != null; current = current.next) {
			if(current.key.equals(k)) {
				current.value = v;
				return ;
			}
		}
		
		first = new Node(k, v, first);
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
