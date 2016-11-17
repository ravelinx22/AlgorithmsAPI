package Estructuras_de_datos_implementaciones;

import java.util.Scanner;

import Estructuras_de_datos_interfaces.ISymbolDigraph;

public class SymbolDigraph implements ISymbolDigraph {

	private SequentialST<String, Integer> st;
	private String keys[];
	private Digraph G;
	
	public SymbolDigraph(String stream, String sp) {
		st = new SequentialST<String, Integer>();
		Scanner in = new Scanner(System.in);

		while(in.hasNextLine()) {
			String[] a = in.nextLine().split(sp);
			for(int i = 0; i < a.length; i++)
				if(!st.contains(a[i]))
					st.put(a[i], st.size());
		}
		
		keys = new String[st.size()];
		
		for(String name: st.keys())  
			keys[st.get(name)] = name;
		
		G = new Digraph(st.size());
		in.close();
		
		in = new Scanner(System.in);
		while(in.hasNextLine()) {
			String[] a = in.nextLine().split(sp);
			int v = st.get(a[0]);
			for(int i = 1; i < a.length; i++)
				G.addEdge(v, st.get(a[i]));
		}
		
		in.close();
	}
	
	public boolean contains(String s) {
		return st.contains(s);
	}

	public int index(String s) {
		return st.get(s);
	}

	public String name(int v) {
		return keys[v];
	}

	public Digraph G() {
		return G;
	}

}
