package Estructuras_de_datos_implementaciones;
import Estructuras_de_datos_interfaces.IBag;
import Models.Node;
import java.util.*;

public class Bag <Item> implements IBag<Item>, Iterable<Item> {
	
	private Node<Item> first;
	
	public void add(Item item) {
		Node<Item> oldFirst = first;
		first = new Node<Item>(item);
		first.setNext(oldFirst);
	}
	
	// Iterator
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	// Private Classes
	
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
