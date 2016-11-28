package Estructuras_de_datos_implementaciones;
import Estructuras_de_datos_interfaces.IMinIndexHeap;

public class IndexMinPQ<Key extends Comparable<Key>> implements IMinIndexHeap<Key> {

	private int N = 0;
	private int[] pq;
	private int[] qp;
	private Key[] keys;
	
	@SuppressWarnings("unchecked")
	public IndexMinPQ(int maxN) {
		keys = (Key[]) new Comparable[maxN +1];
		pq = new int[maxN+1];
		qp = new int[maxN+1];
		
		for(int i = 0, n = qp.length; i < n; i++) qp[i] = -1;
	}
	
	public void insert(int k, Key key) {
		N++;
		qp[k] = N;
		pq[N] = k;
		keys[k] = key;
		swim(N);
	}

	public void change(int k, Key key) {
		keys[k] = key;
		swim(qp[k]);
		sink(qp[k]);
	}

	public boolean contains(int k) {
		return qp[k] != -1;
	}

	public void delete(int k) {
		exch(k, N--);
		swim(qp[k]);
		sink(qp[k]);
		keys[pq[N+1]] = null;
		qp[pq[N+1]] = -1;
	}

	public Key min() {
		return keys[pq[1]];
	}

	public int minIndex() {
		return pq[1];
	}

	public int delMin() {
		int indexOfMin = pq[1];
		exch(1, N--);
		sink(1);
		keys[pq[N+1]] = null;
		qp[pq[N+1]] = -1;
		return indexOfMin;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
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
		Key temp = keys[index1];
		keys[index1] = keys[index2];
		keys[index2] = temp;
	}
	
	private boolean less(int i, int j) {
		return keys[i].compareTo(keys[j]) < 0;
	}

}
