package Estructuras_de_datos_interfaces;

import Estructuras_de_datos_implementaciones.Graph;

public interface ISymbolGraph {
	
	public boolean contains(String s);
	public int index(String s);
	public String name(int v);
	public Graph G();
}
