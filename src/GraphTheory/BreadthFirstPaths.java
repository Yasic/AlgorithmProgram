package GraphTheory;

import edu.princeton.cs.introcs.StdOut;

import java.util.Stack;

/**
 * Created by Yasic on 2016/5/2.
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BreadthFirstPaths(Graph graph, int s){
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];
        this.s = s;
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s){
        Queue queue = new Queue();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w = 0; w < graph.getAdj(v).size(); w++){
                if (!marked[(Integer) graph.getAdj(v).get(w)]){
                    edgeTo[(Integer) graph.getAdj(v).get(w)] = v;
                    marked[(Integer) graph.getAdj(v).get(w)] = true;
                    queue.enqueue((Integer) graph.getAdj(v).get(w));
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    /**
     * Shortest Path
     * @param v
     */
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
        BreadthFirstPaths depthFirstPaths = new BreadthFirstPaths(graph, 4);
        depthFirstPaths.pathTo(1);
    }
}
