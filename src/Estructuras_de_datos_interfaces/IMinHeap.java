package Estructuras_de_datos_interfaces;

public interface IMinHeap <Item> {
	
	public void insert(int k, Item item);
	public void change(int k, Item item);
	public boolean contains(int k);
	public void delete(int k);
	public Item min();
	public int minIndex();
	public int delMin();
	public boolean isEmpty();
	public int size();
	public void swim(int k);
	public void sink(int k);
}
