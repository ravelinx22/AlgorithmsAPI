package Estructuras_de_datos_implementaciones;
import java.util.*;

import Estructuras_de_datos_interfaces.IGraph;

public class Graph implements IGraph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[v];
		
		for(int i = 0; i < v; i++) 
			adj[i] = new Bag<Integer>();
	}
	
	public Graph(Scanner in) {
		this(in.nextInt());
		int E = in.nextInt();
		
		for(int i = 0; i < E; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			addEdge(v, w);
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	@SuppressWarnings("unused")
	public int degree(int v) {
		int count = 0;
		
		for(int w :adj(v)) 
			count++;
		
		return count;
	}
	
	public int maxDegree() {
		int max = 0;
		for(int i = 0; i < V(); i++) {
			if(degree(i) > max)
				max = degree(i);
		}
		
		return max;
	}
	
	public int avgDegree() {
		return 2*E()/V();
	}
	
	public int selfLoops() {
		int count = 0;
		
		for(int v = 0; v < V(); v++) {
			for(int w: adj(v)) {
				if(w == v){
					count++;
				}
			}
		}
		
		return count/2;
	}
}
