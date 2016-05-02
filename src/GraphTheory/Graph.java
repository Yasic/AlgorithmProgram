package GraphTheory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yasic on 2016/5/2.
 */
public class Graph {
    private int V;
    private int E;
    private List[] adj;

    public Graph(int V){
        this.V = V;
        adj = new List[V];
        for (int v = 0; v < V; v++){
            adj[v] = new ArrayList<Integer>();
        }
    }

    public int getV(){return V;}
    public int getE(){return E;}

    public void addEdge(int v, int e){
        adj[v].add(e);
        adj[e].add(v);
        E++;
    }

    public List getAdj(int v){
        return adj[v];
    }
}
