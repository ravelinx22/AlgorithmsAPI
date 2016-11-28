package Estructuras_de_datos_implementaciones;

public class AcyclicSP {
	private DirectedEdge[] edgeTo;
    private double[] disTo;

    public AcyclicSP(EdgeWeightedDigraph G, int s) {
         edgeTo = new DirectedEdge[G.V()];
         disTo = new double[G.V()];

         for(int v = 0; v < G.V(); v++)
              disTo[v] = Double.POSITIVE_INFINITY;
         disTo[s] = 0.0;

         Topological top = new Topological(G);

         for (int v : top.order()) {
             for (DirectedEdge e : G.adj(v))
                 relax(e);
         }
    }

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        if (disTo[w] > disTo[v] + e.weight()) {
            disTo[w] = disTo[v] + e.weight();
            edgeTo[w] = e;
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
