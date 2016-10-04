package Estructuras_de_datos_interfaces;

import Models.Node;

public interface ILinkedList <Item> {
	
	public void add(Item item);
	public void remove(int index);
	public Item get(int index);
	public Node<Item> getFirst();
	public boolean isEmpty();
	public int size();
}
