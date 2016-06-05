package GraphTheory;

import edu.princeton.cs.introcs.In;

import java.lang.management.GarbageCollectorMXBean;
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

    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int getV(){return V;}
    public int getE(){return E;}

    //in this function we can check out the loopback
    // and avoid to record them twice
    public void addEdge(int v, int e){
        adj[v].add(e);
        adj[e].add(v);
        E++;
    }

    public List getAdj(int v){
        return adj[v];
    }
}
