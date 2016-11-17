package Estructuras_de_datos_implementaciones;

public class TransitiveClosure {

	private DirectedDFS[] all;
	
	public TransitiveClosure(Digraph G) {
		all = new DirectedDFS[G.V()];
		for(int v = 0; v < G.V(); v++)
			all[v] = new DirectedDFS(G, v);
	}
	
	public boolean reachable(int v, int w) {
		return all[v].marked(w);
	}
}
