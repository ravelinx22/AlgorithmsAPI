package Estructuras_de_datos_implementaciones;

import Estructuras_de_datos_interfaces.ISymbolTable;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements ISymbolTable<Key, Value>{
	
	private Key[] keys;
	private Value[] values;
	private int N;
 	
	// Constructor
	
	@SuppressWarnings("unchecked")
	public BinarySearchST(int max) {
		keys = (Key[]) new Comparable[max];
		values = (Value[] )new Object[max];
		N = 0;
	}
	
	// Methods
	
	public void put(Key k, Value v) {
		int i = rank(k);
		
		if(i < N && keys[i].compareTo(k) == 0) {
			values[i] = v;
			return;
		}
		
		for(int j = N; i < j; j--) {
			keys[j] = keys[j-1];
			values[j] = values[j-1];
		}
		
		keys[i] = k;
		values[i] = v;
		N++;
	}
	
	public Value get(Key k) {
		int i = rank(k);
		
		if(isEmpty()) 
			return null;
		
		if(i < N && keys[i].compareTo(k) == 0) {
			return values[i];
		}
		
		return null;
	}
	
	public int rank(Key k) {
		int lo = 0;
		int hi = N-1;
		
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			
			if(keys[mid].compareTo(k) == 0) {
				return mid;
			} else if(keys[mid].compareTo(k) < 0) {
				lo = mid+1;
			} else if(keys[mid].compareTo(k) > 0) {
				hi = mid-1;
			}
		}
		
		return lo;
	}
	
	public boolean contains(Key key) {
		if(key == null) return false;
		
		for(Key k : keys) {
			if(k.equals(key))
				return true;
		}
		
		return false;
	}
	
	// Helpers
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
}
