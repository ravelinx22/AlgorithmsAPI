package Estructuras_de_datos_implementaciones;
import Estructuras_de_datos_interfaces.IHash;

public class SeparateChainingHashST <Key extends Comparable<Key>, Value> implements IHash<Key, Value> {

	private int N;
	private int M;
	private SequentialST<Key, Value>[] st;
	
	public SeparateChainingHashST() {
		this(997);
	}
	
	@SuppressWarnings("unchecked")
	public SeparateChainingHashST(int M) {
		this.M = M;
		st = (SequentialST<Key, Value>[]) new SequentialST[M];
		for(int i = 0; i < st.length; i++) {
			st[i] = new SequentialST<Key,Value>();
		}
	}
	
	public void put(Key key, Value value) {
		st[hash(key)].put(key, value);
		N++;
	}
	
	public Value get(Key key) {
		return (Value) st[hash(key)].get(key);
	}
	
	public void delete(Key key) {
		st[hash(key)].delete(key);
		N--;
	}
	
	public int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
}
