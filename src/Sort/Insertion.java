package Sort;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Yasic on 2016/4/23.
 */
public class Insertion {
    public Insertion() {
    }

    public static int[] insertion(int[] data, int lo, int hi) {
        boolean temp = true;

        for(int i = lo; i <= hi; ++i) {
            for(int j = i; j > 0 && data[j] < data[j - 1]; --j) {
                int var4 = data[j];
                data[j] = data[j - 1];
                data[j - 1] = var4;
            }
        }

        return data;
    }

    public static void main(String[] arg) {
        int[]  data = new int[10000];
        for (int j = 0; j < 10000; j++){
            data[j] = (int) (10000 * Math.random());
        }
        insertion(data, 0 ,data.length - 1);
        int[] var2 = data;
        int var3 = data.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int i = var2[var4];
            StdOut.println(i);
        }

    }
}

