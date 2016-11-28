package Estructuras_de_datos_implementaciones;

import java.util.Scanner;

public class EdgeWeightedDigraph {
	private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V) {
         this.V = V;
         this.E = 0;
         adj = (Bag<DirectedEdge>[]) new Bag[V];
         for(int v = 0; v < V; v++)
              adj[v] = new Bag<DirectedEdge>();
    }

    public EdgeWeightedDigraph(Scanner sc) {
    	 this(sc.nextInt());
         int E = sc.nextInt();
        
         for (int i = 0; i < E; i++) {
             int v = sc.nextInt();
             int w = sc.nextInt();
             double weight = sc.nextDouble();
             addEdge(new DirectedEdge(v, w, weight));
         }
    }

    public int V() {
         return V;
    }

    public int E() {
         return E;
    }

    public void addEdge(DirectedEdge e) {
         adj[e.from()].add(e);
         E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
         return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
         Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
         for(int v = 0; v < V; v++)
              for(DirectedEdge e: adj[v])
                   bag.add(e);
         return bag;
    }
}
