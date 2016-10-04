package Estructuras_de_datos_interfaces;

public interface IMaxHeap<Key> {
	
	public void insert(Key i);
	public Key delMax();
	public boolean isEmpty();
	public int size();
	public void swim(int k);
	public void sink(int k);
}
