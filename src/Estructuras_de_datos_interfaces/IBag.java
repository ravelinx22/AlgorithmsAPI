package Estructuras_de_datos_interfaces;

public interface IBag<Item> {

	public void add(Item item);
	public Item get();
	public boolean isEmpty();
	public int size();
}
