package Estructuras_de_datos_interfaces;

public interface IStack<Item> {
	public void push(Item item);
	public Item pop();
	public boolean isEmpty();
	public int size();
}