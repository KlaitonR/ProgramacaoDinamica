package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Museu {

	public static void main(String[] args) {

		ArrayList<Vertice> vertices = new ArrayList<Vertice>();
		ArrayList<String> caminho = new ArrayList<String>();
//		ArrayList<Vertice> caminho = new ArrayList<Vertice>();
		
		
		
		for(int i=0; i<25; i++) {
			Vertice v = new Vertice("v"+(i+1));
			vertices.add(v);
		}
		
		inicializaLigacoes(vertices);
		Vertice origem = vertices.get(0);
		origem.Pai = origem;
		Vertice destino = vertices.get(15);
		Vertice atual  = origem;
		
		System.out.println("Atual: " + atual.nome + " - Visitado: " + atual.visitado + " - Pai: " + atual.Pai.nome);

		while(atual!=destino) {
			
			if(!atual.filhos.isEmpty()) {
				
				for(int i = 0; i<atual.filhos.size(); i++) {
					
					if(!atual.filhos.get(i).visitado) {
						atual.filhos.get(i).Pai = atual;
						atual = atual.filhos.get(i);
						break;
					}else {
						
						if(i==atual.filhos.size()-1) {
							atual.visitado = true;
							atual = atual.Pai;
						}
					}
				}
				
			}else {
				atual.visitado = true;
				atual = atual.Pai;
			}
			
			System.out.println("Atual: " + atual.nome + " - Visitado: " + atual.visitado + " - Pai: " + atual.Pai.nome);
		}
		
		System.out.println("Atual: " + atual.nome + " - Visitado: " + atual.visitado + " - Pai: " + atual.Pai.nome);	
		
		
		System.out.println("\n");
		
		atual = destino;
		
		while(atual != origem) {
			
//			caminho.add(atual);		
			caminho.add(atual.nome);	
			atual = atual.Pai;
		}

//		caminho.add(origem);
		caminho.add(origem.nome);
		
		Collections.sort(caminho);
		
		caminho.sort(Comparator.comparing(String::length));
		
		caminho.forEach((vertice) -> System.out.println(vertice));
		
	}
	
	
	public static void inicializaLigacoes(ArrayList<Vertice> v) {
		
		v.get(0).filhos.add(v.get(1));
//		v.get(1).Pai = v.get(0);
		v.get(0).filhos.add(v.get(2));
//		v.get(2).Pai = v.get(0);
		v.get(0).filhos.add(v.get(3));
//		v.get(3).Pai = v.get(0);
		
		v.get(1).filhos.add(v.get(4));
		v.get(1).filhos.add(v.get(5));
		v.get(1).filhos.add(v.get(6));
		v.get(2).filhos.add(v.get(6));
		v.get(2).filhos.add(v.get(7));
		v.get(3).filhos.add(v.get(8));
		v.get(4).filhos.add(v.get(9));
		v.get(5).filhos.add(v.get(9));
		v.get(6).filhos.add(v.get(10));
		v.get(7).filhos.add(v.get(10));
		v.get(8).filhos.add(v.get(11));
		v.get(8).filhos.add(v.get(14));
		v.get(9).filhos.add(v.get(12));
		v.get(10).filhos.add(v.get(13));
		v.get(11).filhos.add(v.get(13));
		v.get(0).filhos.add(v.get(15));
		v.get(3).filhos.add(v.get(16));
		v.get(14).filhos.add(v.get(18));
		v.get(18).filhos.add(v.get(23));
		v.get(11).filhos.add(v.get(19));
		v.get(13).filhos.add(v.get(22));
		v.get(13).filhos.add(v.get(21));
		v.get(21).filhos.add(v.get(24));
		v.get(12).filhos.add(v.get(20));
		v.get(12).filhos.add(v.get(21));
		v.get(4).filhos.add(v.get(17));
		
	}
	
//	public static void iniciaAresta(List<Vertice> vertices) {
//		Aresta a1 = new Aresta(vertices.get(0), vertices.get(1));
//		Aresta a2 = new Aresta(vertices.get(0), vertices.get(2));
//		Aresta a3 = new Aresta(vertices.get(0), vertices.get(3));
//		Aresta a4 = new Aresta(vertices.get(1), vertices.get(4));
//		Aresta a5 = new Aresta(vertices.get(1), vertices.get(5));
//		Aresta a6 = new Aresta(vertices.get(1), vertices.get(6));
//		Aresta a7 = new Aresta(vertices.get(2), vertices.get(6));
//		Aresta a8 = new Aresta(vertices.get(2), vertices.get(7));
//		Aresta a9 = new Aresta(vertices.get(3), vertices.get(8));
//		Aresta a10 = new Aresta(vertices.get(4), vertices.get(9));
//		Aresta a11 = new Aresta(vertices.get(5), vertices.get(9));
//		Aresta a12 = new Aresta(vertices.get(6), vertices.get(10));
//		Aresta a13 = new Aresta(vertices.get(7), vertices.get(10));
//		Aresta a14 = new Aresta(vertices.get(8), vertices.get(11));
//		Aresta a15 = new Aresta(vertices.get(8), vertices.get(14));
//		Aresta a16 = new Aresta(vertices.get(9), vertices.get(12));
//		Aresta a17 = new Aresta(vertices.get(10), vertices.get(13));
//		Aresta a18 = new Aresta(vertices.get(11), vertices.get(13));
//	}

}