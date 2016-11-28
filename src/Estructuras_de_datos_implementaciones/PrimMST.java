package Estructuras_de_datos_implementaciones;

public class PrimMST {
	private Edge[] edgeTo;
	private double[] disTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;

	public PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		disTo = new double[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++)
			disTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());

		disTo[0] = 0.0;
		pq.insert(0, 0.0);
		while(!pq.isEmpty())
			visit(G, pq.delMin());
	}

	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;

		for(Edge e: G.adj(v)) {
			int w = e.other(v);
			if(marked[w]) continue;
			if(e.weight() < disTo[w]) {
				edgeTo[w] = e;
				disTo[w] = e.weight();
				if(pq.contains(w)) pq.change(w, disTo[w]);
				else pq.insert(w, disTo[w]);
			}
		}
	}

	public Iterable<Edge> edges() {
		Queue<Edge> mst = new Queue<Edge>();
		for(int v = 0; v < edgeTo.length; v++) {
			Edge e = edgeTo[v];
			if(e != null)
				mst.enQueue(e);
		}
		return mst;
	}

	public double weight() {
		double weight = 0.0;
		for(Edge e : edges())
			weight += e.weight();

		return weight;
	}
}
