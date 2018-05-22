import java.util.*;

class Graph{
	int V;
	LinkedList[] g = null;
	Graph(int V){
		this.V = V;
		this.g = new LinkedList[V];
		for(int i = 0; i< V ; i++){
			g[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v){
		g[u].add(v);
		g[v].add(u);
	}

	public static void printGraph(Graph graph){
		int v = graph.V;

		for(int i =0 ; i < v; i++){
			System.out.print(i + " ==> ") ;
			Iterator<Integer> itr = graph.g[i].iterator();
			while(itr.hasNext()){
				System.out.print("  " + itr.next());
			}
			System.out.println();
		}
	}

	public static void main(String args[]){
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge( 1, 2);
        graph.addEdge( 1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        printGraph(graph);
	}

}