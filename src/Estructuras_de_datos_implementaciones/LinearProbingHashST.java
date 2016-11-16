package Estructuras_de_datos_implementaciones;
import Estructuras_de_datos_interfaces.IHash;

public class LinearProbingHashST <Key extends Comparable<Key>, Value> implements IHash<Key, Value> {
	
	private int N;
	private int M = 16;
	private Key[] keys;
	private Value[] vals;
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashST() {
		keys = (Key[]) new Comparable[M];
		vals = (Value[]) new Object[M];
	}
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashST(int max) {
		M = max;
		keys = (Key[]) new Comparable[M];
		vals = (Value[]) new Object[M];
	}
	
	public void put(Key key, Value value) {
		if(N >= M/2) resize(2*M);
		
		int i;
		for(i = hash(key); keys[i] != null; i = (i+1) % M)
			if(keys[i].equals(key)) { vals[i] = value; return;}
		
		keys[i] = key;
		vals[i] = value;
		N++;
	}
	
	public Value get(Key key) {
		for(int i = hash(key); keys[i] != null; i = (i+1) % M)
			if(keys[i].equals(key)) return vals[i];
		
		return null;
	}
	
	public int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void delete(Key key) {
		if(!contains(key)) return;
		
		int i = hash(key);
		while(!key.equals(keys[i])) {
			i = (i+1) % M;
		}
		
		keys[i] = null;
		vals[i] = null;
		
		i = (i+1) % M;
		
		while(keys[i] != null) {
			Key keyToRedo = keys[i];
			Value valueToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRedo, valueToRedo);
			i = (i+1) % M;
		}
		N--;
		
		if(N > 0 && N == M/8)
			resize(M/2);
	}
	
    // Helpers 
	
	public void resize(int size) {
		  LinearProbingHashST<Key, Value> t = new LinearProbingHashST<Key, Value>(size);
		  for(int i = 0; i < M; i++) {
			  if(keys[i] != null)
				  t.put(keys[i], vals[i]);
		  }
		  
		  keys = t.keys;
		  vals = t.vals;
		  M = t.M;
	}
	
	public boolean contains(Key key) {
		for(int i = hash(key); keys[i] != null; i = (i+1) % M) {
			if(keys[i].equals(key))
				return true;
		}
		
		return false;
	}
}
