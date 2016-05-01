package Search;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Yasic on 2016/5/1.
 */
public class LinearProbingHashTable {
    private static int M = 16;
    private static int TOTAL;
    private static int[] keys, vals;
    public LinearProbingHashTable(){
        keys = new int[M];
        vals = new int[M];
    }

    public LinearProbingHashTable(int cap){
        keys = new int[M];
        vals = new int[M];
        this.M = cap;
    }

    private static int getHash(Integer key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private static void resize(int cap){
        LinearProbingHashTable linearProbingHashTable;
        linearProbingHashTable = new LinearProbingHashTable(cap);
        for (int i = 0; i < M; i++){
            if (keys[i] != 0){
                linearProbingHashTable.put(keys[i], vals[i]);
            }
        }
        keys = linearProbingHashTable.keys;
        vals = linearProbingHashTable.vals;
        M = linearProbingHashTable.M;
    }

    public static void put(int key, int val){
        if (TOTAL >= M/2){
            //resize(2 * M);
        }
        int temp;
        for (temp = getHash(key); keys[temp] != 0; temp = (temp + 1) % M){
            if (keys[temp] == key){
                vals[temp] = val;
                return;
            }
        }
        keys[temp] = key;
        vals[temp] = val;
        TOTAL++;
    }

    public static int get(int key){
        for (int i = getHash(key); keys[i] != 0; i = (i + 1) % M){
            if (keys[i] == key){
                return vals[i];
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int SIZE = 10;
        LinearProbingHashTable linearProbingHashTable = new LinearProbingHashTable();
        for (int i = 1; i <= SIZE; i++){
            linearProbingHashTable.put(i, i);
        }
        StdOut.print("\n" + linearProbingHashTable.get(6) + "\t");
        StdOut.print("polygenelubricants".hashCode());
    }
}
