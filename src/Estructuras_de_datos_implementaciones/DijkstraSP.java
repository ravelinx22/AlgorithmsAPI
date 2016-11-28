package Estructuras_de_datos_implementaciones;

public class DijkstraSP {
	 private DirectedEdge[] edgeTo;
     private double[] disTo;
     private IndexMinPQ<Double> pq;

     public DijkstraSP(EdgeWeightedDigraph G, int s) {
          edgeTo = new DirectedEdge[G.V()];
          disTo = new double[G.V()];
          pq = new IndexMinPQ<Double>(G.V());

          for(int v = 0; v < G.V(); v++)
               disTo[v] = Double.POSITIVE_INFINITY;
          disTo[s] = 0.0;

          pq.insert(s, 0.0);
          while(!pq.isEmpty())
               relax(G, pq.delMin());
     }

     private void relax(EdgeWeightedDigraph G, int v) {
          for(DirectedEdge e : G.adj(v)) {
               int w = e.to();
               if(disTo[w] > disTo[v] + e.weight()) {
                    disTo[w] = disTo[v] + e.weight();
                    edgeTo[w] = e;
                    if(pq.contains(w)) pq.change(w, disTo[w]);
                    else pq.insert(w, disTo[w]);
               }
          }
     }

     public double disTo(int v) {
          return disTo[v];
     }

     public boolean hasPathTo(int v) {
          return disTo[v] < Double.POSITIVE_INFINITY;
     }

     public Iterable<DirectedEdge> pathTo(int v) {
          if(!hasPathTo(v)) return null;
          Stack<DirectedEdge> path = new Stack<DirectedEdge>();
          for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
               path.push(e);
          return path;
     }
}
