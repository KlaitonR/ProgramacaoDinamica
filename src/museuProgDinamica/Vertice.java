package museuProgDinamica;

import java.util.ArrayList;

public class Vertice{
	
	String nome;
	Vertice Pai;
	int index;
	ArrayList<Vertice> filhos = new ArrayList<Vertice>();
	boolean visitado;
	
	public Vertice(String nome) {
		this.nome = nome;
	}
}
