package GraphTheory;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Yasic on 2016/5/2.
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph graph, int s){
        marked = new boolean[graph.getV()];
        count = 0;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v){
        marked[v] = true;
        count++;
        for (int w = 0; w < graph.getAdj(v).size(); w++){
            if (!marked[(Integer) graph.getAdj(v).get(w)]){
                dfs(graph, (Integer) graph.getAdj(v).get(w));
            }
        }
    }
    public int getCount(){
        return count;
    }

    public static void main(String[] arg){
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(0,4);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 1);
        StdOut.print(depthFirstSearch.getCount());
    }
}
