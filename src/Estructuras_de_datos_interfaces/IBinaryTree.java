package Estructuras_de_datos_interfaces;

public interface IBinaryTree <Key extends Comparable<Key>, Value> {

	public void put(Key key, Value value);
	public Value get(Key key);
	public int size();
	public void delete(Key key);
}
