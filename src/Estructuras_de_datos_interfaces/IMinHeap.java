package Estructuras_de_datos_interfaces;

public interface IMinHeap<Key> {
	
	public void insert(Key i);
	public Key delMin();
	public boolean isEmpty();
	public int size();
	public void swim(int k);
	public void sink(int k);
}
