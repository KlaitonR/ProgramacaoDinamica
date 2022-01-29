package museuProgDinamica;

import java.util.ArrayList;
import java.util.Collections;

public class Museu {

	public static void main(String[] args) {

		ArrayList<Vertice> vertices = new ArrayList<Vertice>();
		ArrayList<Aresta> arestas = new ArrayList<Aresta>();
		ArrayList<Vertice> caminho = new ArrayList<Vertice>();
		
		for(int i=0; i<25; i++) {
			Vertice v = new Vertice("Sala "+(i+1));
			vertices.add(v);
		}
		
		inicializaLigacoes(vertices, arestas);
		Vertice origem = vertices.get(0);
		origem.Pai = origem;
		Vertice destino = vertices.get(24);
		Vertice atual  = origem;
		
		System.out.println("Iniciando Algoritmo... Procurando sainda...\n\n" + 
							"Atual: " + atual.nome + " - Visitado: " +
							atual.visitado + " - Pai: " + atual.Pai.nome);

		int n = 0;
		
		while(atual!=destino) {
			
			if(!atual.filhos.isEmpty()) {
				
				if(atual.index <= atual.filhos.size()-1) {
					System.out.println("Verificando as salas vizinhas não visitadas..." +
										"Verificando sala " + atual.filhos.get(atual.index).nome);
					
					if(!atual.filhos.get(atual.index).visitado) {
						atual.filhos.get(atual.index).Pai = atual;
						atual.index++;
						atual = atual.filhos.get(atual.index-1);
						System.out.println("Sala não visitada... Entrando na sala " + atual.nome);
						
					}else {
						System.out.println("Sala já visitada!"); 
						if(atual.index==atual.filhos.size()-1) {
							System.out.println("Todas as salas vizinhas de " +
												atual.nome + " já foram visitadas!");
							atual.visitado = true;
							atual = atual.Pai;
							System.out.println("Voltando para sala " + atual.nome);
							System.out.println("\nAtual: " + atual.nome + " - Visitado: " + atual.visitado + " - Pai: " + atual.Pai.nome + "\n");
						}else {
							atual.index++;
						}
					}
				}else {
					System.out.println("Todas as salas vizinhas de " +
							atual.nome + " já foram visitadas!");
					atual.visitado = true;
					atual = atual.Pai;
					System.out.println("Voltando para sala " + atual.nome);
				}
				
			}else {
				atual.visitado = true;
				atual = atual.Pai;
				System.out.println("A porta de saida desta sala esta trancada... Voltando para sala " + atual.nome);
			}
			
			n++;
			
			System.out.println("\nAtual: " + atual.nome + " - Visitado: " + atual.visitado + " - Sala Anterior: " + atual.Pai.nome + "\n");
		}

		System.out.println("\nSAIDA ENCONTRADA! Porta encontrada na sala " + atual.nome);
		
		atual = destino;
		while(atual != origem) {
			
			caminho.add(atual);	
			atual = atual.Pai;
		}
		caminho.add(origem);

		Collections.reverse(caminho);
		mostraCaminho(caminho);
		
		int i = 0;
		int j = 0;
		
		System.out.println("\nDISTÂNCIA DO CAMINHO\n");
		
		while(j<caminho.size()) {
			if(i < arestas.size()) {
				if(arestas.get(i).origem == caminho.get(j)) {
					arestas.get(i).origemCaminho = true;
				}
				i++;
			}else {
				j++;
				i = 0;
			}
		}
		
		j=0;
		i=0;
		
		while(j<caminho.size()) {
			if(i < arestas.size()) {
				if(arestas.get(i).origemCaminho) {
					if(arestas.get(i).destino == caminho.get(j)) {
						arestas.get(i).destinoCaminho = true;
					}
				}
				i++;
			}else {
				j++;
				i = 0;
			}
		}
		
		arestas.forEach(a -> {
			if(a.origemCaminho && a.destinoCaminho)
				System.out.println(a.label + " - Peso: " + a.peso);
		});
		
		int sum = arestas.stream()
				.filter(a -> a.destinoCaminho && a.origemCaminho)
				.mapToInt(a -> a.peso)
				.sum();
		
		System.out.println("\nDistância do caminho: " + sum + " u");
		System.out.println("\nNúmero de iterações do algoritmo: " + n);
	
	}
	
	public static void inicializaLigacoes(ArrayList<Vertice> v, ArrayList<Aresta> a) {
		
		v.get(0).filhos.add(v.get(1));
		Aresta a1 = new Aresta("a1", v.get(0), v.get(1), 4 );
		a.add(a1);
		v.get(0).filhos.add(v.get(2));
		Aresta a2 = new Aresta("a2", v.get(0), v.get(2), 3 );
		a.add(a2);
		v.get(0).filhos.add(v.get(3));
		Aresta a3 = new Aresta("a3", v.get(0), v.get(3), 12 );
		a.add(a3);
		v.get(0).filhos.add(v.get(4));
		Aresta a4 = new Aresta("a4", v.get(0), v.get(4), 6 );
		a.add(a4);
		v.get(1).filhos.add(v.get(5));
		Aresta a5 = new Aresta("a5", v.get(1), v.get(5), 7 );
		a.add(a5);
		v.get(1).filhos.add(v.get(6));
		Aresta a6 = new Aresta("a6", v.get(1), v.get(6), 2 );
		a.add(a6);
		v.get(1).filhos.add(v.get(7));
		Aresta a7 = new Aresta("a7", v.get(1), v.get(7), 7 );
		a.add(a7);
		v.get(2).filhos.add(v.get(7));
		Aresta a8 = new Aresta("a8", v.get(2), v.get(7), 1 );
		a.add(a8);
		v.get(2).filhos.add(v.get(8));
		Aresta a9 = new Aresta("a9", v.get(2), v.get(8), 5 );
		a.add(a9);
		v.get(3).filhos.add(v.get(13));
		Aresta a10 = new Aresta("a10", v.get(3), v.get(13), 6 );
		a.add(a10);
		v.get(3).filhos.add(v.get(9));
		Aresta a11 = new Aresta("a11", v.get(3), v.get(9), 5 );
		a.add(a11);
		v.get(5).filhos.add(v.get(10));
		Aresta a12 = new Aresta("a12", v.get(5), v.get(10), 15 );
		a.add(a12);
		v.get(5).filhos.add(v.get(11));
		Aresta a13 = new Aresta("a13", v.get(5), v.get(11), 9 );
		a.add(a13);
		v.get(6).filhos.add(v.get(11));
		Aresta a14 = new Aresta("a14", v.get(6), v.get(11), 4 );
		a.add(a14);
		v.get(7).filhos.add(v.get(12));
		Aresta a15 = new Aresta("a15", v.get(7), v.get(12), 10 );
		a.add(a15);
		v.get(8).filhos.add(v.get(12));
		Aresta a16 = new Aresta("a16", v.get(8), v.get(12), 13 );
		a.add(a16);
		v.get(11).filhos.add(v.get(14));
		Aresta a17 = new Aresta("a17", v.get(11), v.get(14), 2 );
		a.add(a17);
		v.get(12).filhos.add(v.get(18));
		Aresta a18 = new Aresta("a18", v.get(12), v.get(18), 3 );
		a.add(a18);
		v.get(13).filhos.add(v.get(15));
		Aresta a19 = new Aresta("a19", v.get(13), v.get(15), 5 );
		a.add(a19);
		v.get(13).filhos.add(v.get(16));
		Aresta a20 = new Aresta("a20", v.get(13), v.get(16), 8 );
		a.add(a20);
		v.get(14).filhos.add(v.get(17));
		Aresta a21 = new Aresta("a21", v.get(14), v.get(17), 19 );
		a.add(a21);
		v.get(14).filhos.add(v.get(20));
		Aresta a22 = new Aresta("a22", v.get(14), v.get(20), 14 );
		a.add(a22);
		v.get(15).filhos.add(v.get(18));
		Aresta a23 = new Aresta("a23", v.get(15), v.get(18), 4 );
		a.add(a23);
		v.get(15).filhos.add(v.get(19));
		Aresta a24 = new Aresta("a24", v.get(15), v.get(19), 1 );
		a.add(a24);
		v.get(16).filhos.add(v.get(22));
		Aresta a25 = new Aresta("a25", v.get(16), v.get(22), 15 );
		a.add(a25);
		v.get(18).filhos.add(v.get(20));
		Aresta a26 = new Aresta("a26", v.get(18), v.get(20), 3 );
		a.add(a26);
		v.get(18).filhos.add(v.get(21));
		Aresta a27 = new Aresta("a27", v.get(18), v.get(21), 11 );
		a.add(a27);
		v.get(20).filhos.add(v.get(23));
		Aresta a28 = new Aresta("a28", v.get(20), v.get(23), 22 );
		a.add(a28);
		v.get(22).filhos.add(v.get(24));
		Aresta a29 = new Aresta("a29", v.get(22), v.get(24), 13 );
		a.add(a29);
		
	}
	
	public static void mostraCaminho(ArrayList<Vertice>caminho) {
        String path = "Caminho: [";
        for (int i = 0; i < caminho.size(); i++) {

            if (!caminho.get(i).nome.equalsIgnoreCase(caminho.get(caminho.size() - 1).nome)) {
                path += caminho.get(i).nome + " -> ";
            } else {
                path += caminho.get(i).nome + ']';
            }
        }
        System.out.println(path);
    }
}
