package Estructuras_de_datos_implementaciones;
import Models.*;
import Estructuras_de_datos_interfaces.*;
import java.util.*;

public class Stack <Item> implements IStack<Item>, Iterable<Item> {

	private int N;
	private  Node<Item> first;
	
	public void push(Item item) {
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.setItem(item);
		first.setNext(oldFirst);
		N++;
	}
	
	public Item pop() {
		Item item = first.getItem();
		first = first.getNext();
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
