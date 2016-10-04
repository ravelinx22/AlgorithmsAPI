package Estructuras_de_datos_implementaciones;

import Estructuras_de_datos_interfaces.IMaxHeap;

public class MaxHeap<Key extends Comparable<Key>> implements IMaxHeap<Key> {
	
	private Key[] pq;
	private int N = 0;
	
	@SuppressWarnings("unchecked")
	public MaxHeap(int maxN) {
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		
		return max;
	}
	
	public void sink(int k) {
		while(2*k <= N) {
			int j = 2*k;
			if(j < N && less(j, j+1)) j++;
			if(!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	public void swim(int k) {
		while(k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	// Helpers
	
	private void exch(int index1, int index2) {
		Key temp = pq[index1];
		pq[index1] = pq[index2];
		pq[index2] = temp;
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
}
