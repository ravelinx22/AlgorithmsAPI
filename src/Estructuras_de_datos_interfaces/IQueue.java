package Estructuras_de_datos_interfaces;

public interface IQueue<Item> {
	public void enQueue(Item item);
	public Item deQueue();
	public boolean isEmpty();
	public int size();
}
