package Search;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Yasic on 2016/5/1.
 */
public class SeparateChainingHashTable {
    private int N;
    private static int M;
    private static int SIZE = 10;
    private SequentialSearchST[] sequentialSearchST;

    public SeparateChainingHashTable(){
        this(997);
    }

    public SeparateChainingHashTable(int M){
        this.M = M;
        sequentialSearchST = new SequentialSearchST[M];
        for (int i = 0; i < M; i++){
            sequentialSearchST[i] = new SequentialSearchST();
        }
    }

    private static int getHash(Integer key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public String get(int key){
        return sequentialSearchST[getHash(key)].get(key);
    }

    public void put(int key, String val){
        StdOut.print(getHash(key) + "\t");
        sequentialSearchST[getHash(key)].put(key, val);
    }

    public static void main(String[] args){
        SeparateChainingHashTable test = new SeparateChainingHashTable();
        for (int i = 0; i < SIZE; i++){
            test.put(i, i + ":" + i);
        }
        StdOut.print("\n" + test.get(6) + "\t");
    }

    public static class SequentialSearchST{
        private Node first;
        private class Node{
            int key;
            String val;
            Node next;
            public Node(int key, String val, Node next){
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }

        public String get(int key){
            for (Node node = first; node != null; node = node.next){
                if (key == node.key){
                    return node.val;
                }
            }
            return null;
        }

        public void put(int key, String val){
            for (Node node = first; node != null; node = node.next){
                if (key == node.key){
                    node.val = val;
                    return;
                }
            }
            first = new Node(key, val, first);
        }
    }
}
