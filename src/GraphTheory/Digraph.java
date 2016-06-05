package GraphTheory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yasic on 16-6-5.
 */
public class Digraph {
    private final int V;
    private int E;
    private List[] adj;

    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for (int i = 0; i < V; i++){
            adj[i] = new ArrayList<Integer>();
        }
    }

    public int getV(){return V;}

    public int getE(){return E;}

    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }

    public List<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
        Digraph digraph = new Digraph(V);
        for (int i = 0; i < V; i++){
            for (int w : adj(i)){
                digraph.addEdge(w, i);
            }
        }
        return digraph;
    }
}
