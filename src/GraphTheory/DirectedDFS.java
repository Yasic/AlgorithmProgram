package GraphTheory;

import java.util.List;

/**
 * Created by yasic on 16-6-5.
 */
public class DirectedDFS {
    private boolean[] marked;
    private Digraph digraph;

    public DirectedDFS(Digraph digraph, int s){
        this.digraph = digraph;
        marked = new boolean[digraph.getV()];
        dfs(s);
    }

    public DirectedDFS(Digraph digraph, List<Integer> sources){
        marked = new boolean[digraph.getV()];
        for (int s : sources){
            if (!marked[s]){
                dfs(s);
            }
        }
    }

    private void dfs(int v){
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]){
                dfs(w);
            }
        }
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0,1);
        digraph.addEdge(1,3);
        digraph.addEdge(2,4);
        digraph.addEdge(3,4);
        digraph.addEdge(0,4);
        DirectedDFS directedDFS = new DirectedDFS(digraph, 4);
    }
}
