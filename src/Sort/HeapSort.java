package Sort;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Yasic on 2016/4/24.
 */
public class HeapSort {
    /**
     * Index 0
     */
    private static int SIZE = 10;

    public static void heapSort(int[] a){
        int length = a.length - 1;
        for (int k = length/2; k >= 0; k--){
            sink(a, k, length);
        }
        int var = a.length;
        for (int temp = 0; temp < var; temp++){
            StdOut.print(a[temp] + "\t");
        }
        StdOut.print("\n");
        while (length > 0){
            exchange(a, 0, length--);
            sink(a, 0, length);
            for (int temp = 0; temp < var; temp++){
                StdOut.print(a[temp] + "\t");
            }
            StdOut.print("\n");
        }
    }

    private static void sink(int[] a, int k, int n){
        while (2 * k <= n){
            int j = 2 *k;
            if (j < n && a[j] < a[j+1]){
                j++;
            }
            if (a[k] >= a[j]){
                break;
            }
            exchange(a, k, j);
            k = j;
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] arg) {
        int[]  data = new int[SIZE];
        for (int j = 0; j < SIZE; j++){
            data[j] = (int) (SIZE * Math.random());
        }
        heapSort(data);

        int var3 = data.length;
        for (int i = 0; i < var3; i++) {
            StdOut.print(data[i] + "\t");
        }
    }
}
