package GraphTheory;

import edu.princeton.cs.introcs.StdOut;

import java.util.Stack;

/**
 * Created by Yasic on 2016/5/2.
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph graph, int s){
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v){
        marked[v] = true;
        for (int w = 0; w < graph.getAdj(v).size(); w++){
            if (!marked[(Integer) graph.getAdj(v).get(w)]){
                edgeTo[(Integer) graph.getAdj(v).get(w)] = v;
                dfs(graph, (Integer) graph.getAdj(v).get(w));
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public void pathTo(int v){
        if (!hasPathTo(v))return;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        for (Integer integer : path){
            StdOut.print(integer + "\t");
        }
    }

    public static void main(String[] args){
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(0,4);
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, 1);
        depthFirstPaths.pathTo(0);
    }
}
