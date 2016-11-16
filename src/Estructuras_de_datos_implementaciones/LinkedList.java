package Estructuras_de_datos_implementaciones;

import java.util.Iterator;

import Estructuras_de_datos_interfaces.ILinkedList;
import Models.Node;

public class LinkedList<Item> implements ILinkedList<Item>, Iterable<Item>{

	private Node<Item> first;
	private int N;

	public LinkedList() {
		N = 0;
		first = null;
	}

	public void add(Item item) {
		if(first == null) {
			first = new Node<Item>(item);
		} else {
			Node<Item> current = first;

			while(current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(new Node<Item>(item));
		}

		N++;
	}

	public Item get(int index) {		
		Item ans = null;

		if(index < 0 || index >= N) {
			return ans;
		}
		else if(!isEmpty()) {
			int i = 0;
			Node<Item> current = first;

			while(i != index) {
				current = current.getNext();
				i++;
			}

			ans = current.getItem();
		}

		return ans;
	}

	public Node<Item> getFirst() {
		return first;
	}

	public void remove(int index) {

		if(index < 0 || index >= N) {
			return;
		} else if(index == 0) {
			first = first.getNext();
			N--;
		}
		else if(!isEmpty()) {
			int i = 0;
			Node<Item> current = first;

			while(i+1 != index) {
				current = current.getNext();
				i++;
			}

			current.setNext(current.getNext().getNext());
			N--;
		}
		
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}
	
	// Iterator
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	// Private classes
	
	private class ListIterator implements Iterator<Item> {
		Node<Item> current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public Item next() {
			Item item = current.getItem();
			current = current.getNext();
			return item;
		}
		
		public void remove() {}
	}
}
