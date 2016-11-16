package Estructuras_de_datos_implementaciones;

import java.util.*;
import Estructuras_de_datos_interfaces.*;
import Models.*;

public class Queue<Item> implements IQueue<Item>, Iterable<Item> {
	
	private Node<Item> first;
	private Node<Item> last;
	private int N;
	
	public void enQueue(Item item) {
		Node<Item> oldLast = last;
		last = new Node<Item>();
		last.setItem(item);
		
		if(isEmpty())
			first = last;
		else oldLast.setNext(last);
		
		N++;
	}
	
	public Item deQueue() {
		Item item = first.getItem();
		first = first.getNext();
		
		if(isEmpty()) last = null;
		
		N--;
		
		return item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	// Iterators
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	// Private classes
	
	private class ListIterator implements Iterator<Item> {
		
		Node<Item> current = first;
		
		public Item next() {
			Item item = current.getItem();
			current = current.getNext();
			
			return item;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {}
	}
}
