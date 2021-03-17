package exercicio_10;

class Caminho {

	final int n_vertices;

	int minDistance(int dist[], Boolean sptSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < n_vertices; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	void printar(int dist[]) {
		System.out.println("Vertice \t\t Distancia");
		for (int i = 0; i < n_vertices; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	void dijkstra(int grafo[][], int src) {
		int dist[] = new int[n_vertices];

		Boolean sptSet[] = new Boolean[n_vertices];

		for (int i = 0; i < n_vertices; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int count = 0; count < n_vertices - 1; count++) {
			int u = minDistance(dist, sptSet);

			sptSet[u] = true;

			for (int v = 0; v < n_vertices; v++)

				if (!sptSet[v] && grafo[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + grafo[u][v] < dist[v])
					dist[v] = dist[u] + grafo[u][v];
		}

		printar(dist);
	}

	public static void main(String[] args) {
		int n_vertices = 5;
		int[] d_sao_paulo = new int[]{0,0,0,2,5};
		int[] d_campinas = new int[]{7,0,0,0,0};;
		int[] d_rio_de_janeiro = new int[]{0,4,0,0,0};
		int[] d_ribeirao_preto = new int[]{0,3,0,0,4};
		int[] d_pocos_de_caldas = new int[]{0,0,6,0,0};

		final int sao_paulo = 0;
		final int campinas = 1;
		final int rio_de_janeiro = 2;
		final int ribeirao_preto = 3;
		final int pocos_de_caldas = 4;

		int grafo[][] = new int[][] {
			d_sao_paulo, d_campinas, d_rio_de_janeiro, d_ribeirao_preto, d_pocos_de_caldas
		};
		Caminho t = new Caminho(n_vertices);
		t.dijkstra(grafo, sao_paulo);
	}

	public Caminho(int n_vertices) {
		this.n_vertices = n_vertices;
	}
}
