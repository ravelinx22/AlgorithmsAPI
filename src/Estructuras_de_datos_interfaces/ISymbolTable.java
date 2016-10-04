package Estructuras_de_datos_interfaces;

public interface ISymbolTable <Key extends Comparable<Key>, Value> {

	public void put(Key k, Value v);
	public Value get(Key k);
}
