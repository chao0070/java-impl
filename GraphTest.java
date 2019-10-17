import java.util.*;
import java.lang.*;

class DistNode {
	int dest;
	int weight;

	public DistNode(int dest) {
		this.dest = dest;
	}

	public boolean equals(Object o) {
		if (o == null) return false;
		if (o.getClass() != this.getClass()) return false;
		DistNode d = (DistNode) o;
		if (d.dest != this.dest) return false;
		return true;
	}
}

class Graph {
	int V;
	LinkedList<DistNode>[] adj;

	public Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int dest, int wt) {
		DistNode d = new DistNode(dest);
		d.weight = wt;
		adj[src].add(d);
	}

	public void dfs() {
		Stack<Integer> ts = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < V; i++) {
			if (visited[i]) {
				continue;
			}
			Stack st = new Stack<Integer>();
			st.push(i);
			while (!st.isEmpty()) {
				int curr = (int) st.peek();
				st.pop();
				visited[curr] = true;
				System.out.println(curr);

				for (DistNode dn : adj[curr]) {
					if (!visited[dn.dest])
						st.push(dn.dest);
				}
			}
		}
	}

}
public class GraphTest {

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(2, 3, 1);
		// g.addEdge(3, 0, 1);

		g.dfs();
	}
}