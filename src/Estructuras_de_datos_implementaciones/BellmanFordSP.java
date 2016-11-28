package Estructuras_de_datos_implementaciones;

public class BellmanFordSP {
	private double[] disTo;
	private DirectedEdge[] edgeTo;
	private boolean[] onQ;
	private Queue<Integer> queue;
	private int cost;
	private Iterable<DirectedEdge> cycle;

	public BellmanFordSP(EdgeWeightedDigraph G, int s) {
		disTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		onQ = new boolean[G.V()];
		queue = new Queue<Integer>();
		for(int v = 0; v < G.V(); v++)
			disTo[v] = Double.POSITIVE_INFINITY;
		disTo[s] = 0.0;
		queue.enQueue(s);
		onQ[s] = true;
		while(!queue.isEmpty() && !this.hasNegativeCycle()) {
			int v = queue.deQueue();
			onQ[v] = false;
			relax(G, v);
		}
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for(DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(disTo[w] > disTo[v] + e.weight()) {
				disTo[w] = disTo[v] + e.weight();
				edgeTo[w] = e;
				if(!onQ[w]) {
					queue.enQueue(w);
					onQ[w] = true;
				}
			}
			if(cost++ % G.V() == 0)
				findNegativeCycle();
		}
	}

	private void findNegativeCycle() {
		int V = edgeTo.length;
		EdgeWeightedDigraph spt;
		spt = new EdgeWeightedDigraph(V);
		for(int v = 0; v < V; v++)
			if(edgeTo[v] != null)
				spt.addEdge(edgeTo[v]);

		EdgeWeightedDirectedCycle cf;
		cf = new EdgeWeightedDirectedCycle(spt);

		cycle = cf.cycle();
	}

	public boolean hasNegativeCycle() {
		return cycle != null;
	}

	public Iterable<DirectedEdge> negativeCycle() {
		return cycle;
	}
}
