package Estructuras_de_datos_implementaciones;

public class DirectedCycle {

	private boolean marked[];
	private int edgeTo[];
	private boolean onStack[];
	private Stack<Integer> cycle;
	
	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		onStack = new boolean[G.V()];
		
		for(int v = 0; v < G.V(); v++)
			if(!marked[v])
				dfs(G, v);
	}
	
	public void dfs(Digraph G, int v) {
		onStack[v] = true;
		marked[v] = true;
		
		for(int w: G.adj(v))
			if(hasCycle())
				return;
			else if(!marked[v]) {
				edgeTo[w] = v;
				dfs(G, w);
			} else if(onStack[w]) {
				cycle = new Stack<Integer>();
				
				for(int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		
		onStack[v] = false;
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}
	
	public Iterable<Integer> cycle() {
		return cycle;
	}
}
