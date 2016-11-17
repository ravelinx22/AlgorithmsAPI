package Estructuras_de_datos_interfaces;

import Estructuras_de_datos_implementaciones.Digraph;

public interface ISymbolDigraph {
	
	public boolean contains(String s);
	public int index(String s);
	public String name(int v);
	public Digraph G();
}
