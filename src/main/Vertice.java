package main;

import java.util.ArrayList;

public class Vertice {

	String nome;
	Vertice Pai;
	int id;
	ArrayList<Vertice> filhos = new ArrayList<Vertice>();
	boolean visitado;
	
	public Vertice(String nome) {
		this.nome = nome;
	}
	
}
