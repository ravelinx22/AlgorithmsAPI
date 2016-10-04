package Estructuras_de_datos_interfaces;

public interface IHash <Key extends Comparable<Key>, Value> {
	public int hash(Key key);
	public void put(Key key, Value value);
	public Value get(Key key);
	public void delete(Key key);
}
