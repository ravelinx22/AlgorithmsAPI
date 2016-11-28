package Estructuras_de_datos_implementaciones;

public class LazyPrimMST {
	private boolean[] marked;
	private Queue<Edge> mst;
	private MinPQ<Edge> pq;
	private double weight;

	public LazyPrimMST(EdgeWeightedGraph G) {
		pq = new MinPQ<Edge>(G.V());
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();

		visit(G, 0);

		while(!pq.isEmpty()) {
			Edge e = pq.delMin();
			int v = e.either();
					int w = e.other(v);
			if(marked[v] && marked[w]) continue;
			mst.enQueue(e);
			weight += e.weight();
			if(!marked[v]) visit(G, v);
			if(!marked[w]) visit(G, w);
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;
		for(Edge e: G.adj(v))
			if(!marked[e.other(v)]) pq.insert(e);
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		return weight;
	}
}
