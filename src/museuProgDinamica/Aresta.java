package museuProgDinamica;

public class Aresta {
	
	String label;
	Vertice origem;
	Vertice destino;
	int peso;
	boolean origemCaminho;
	boolean destinoCaminho;
	
	public Aresta(String label, Vertice origem, Vertice destino, int peso) {
		this.label = label;
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}

}
