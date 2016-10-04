package Models;

public class Node <Item> {
	
	private Node<Item> next;
	private Item item;
	
	// Constructors
	
	public Node(Item item) {
		this.item = item;
		this.next = null;
	}
	
	public Node(Item item, Node<Item> next) {
		this.item = item;
		this.next = next;
	}
	
	public Node() {
		this.item = null;
		this.next = null;
	}
	
	// Get methods
	
	public Node<Item> getNext() {
		return next;
	}
	
	public Item getItem() {
		return item;
	}
	
    // Set methods
	
	public void setNext(Node<Item> next) {
		this.next = next;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
}
