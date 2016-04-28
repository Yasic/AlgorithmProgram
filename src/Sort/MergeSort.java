package Sort;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Yasic on 2016/4/23.
 */
public class MergeSort {
    private static int SIZE = 10;

    public MergeSort() {
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int[] temp = new int[a.length];
        int i = lo;
        int j = mid + 1;

        int k;
        for (k = lo; k <= hi; k++) {
            temp[k] = a[k];
        }

        for (k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = temp[j++];
            } else if (j > hi) {
                a[k] = temp[i++];
            } else if (temp[j] < temp[i]) {
                a[k] = temp[j++];
            } else {
                a[k] = temp[i++];
            }
        }

    }

    public static void sortTopDownParse(int[] a) {
        sortTopDownParse(a, 0, a.length - 1);
    }

    public static void sortTopDownParse(int[] a, int lo, int hi) {
        if (hi <= lo + 15){
            Insertion.insertion(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sortTopDownParse(a, lo, mid);
        sortTopDownParse(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sortDownTopParse(int[] a) {
        int length = a.length;
        int[] temp = new int[length];

        for (int i = 1; i < length; i+=i) {//the merge size is increase by 2 times
            for (int lo = 0; lo < length - i; lo += i * 2) {
                merge(a, lo, lo + i - 1, Math.min(lo + i * 2 - 1, length - 1));
            }
        }

    }

    public static void main(String[] arg) {
        //int[] data = new int[]{1, 4, 7, 3, 2, 8, 11, 43, 22, 15};
        int[]  data = new int[SIZE];
        for (int j = 0; j < SIZE; j++){
            data[j] = (int) (SIZE * Math.random());
        }
        //sortTopDownParse(data);
        sortDownTopParse(data);
        int var3 = data.length;

        for (int i = 0; i < var3; i++) {
            StdOut.println(data[i]);
        }

    }
}

