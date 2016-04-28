package Sort;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Yasic on 2016/4/24.
 */
public class QuickSort {
    private static int SIZE = 10;

    public static void quickSort(int[] a, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    public static void threeDirectionQuickSort(int[] a, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        int targetValue = a[lo];
        while (i <= gt){
            if (a[i] < targetValue){
                exchange(a, i, lt);
                lt++;
                i++;
            }
            else if (a[i] > targetValue){
                exchange(a, i, gt);
                gt--;
            }
            else i++;
        }
        threeDirectionQuickSort(a, lo, lt - 1);
        threeDirectionQuickSort(a, gt + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        int i = lo, j = hi + 1;
        while (true){
            while (a[++i] < v){
                if (i == hi){
                    break;
                }
            }
            while (a[--j] > v){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            //above this line is the safety check of i and j
            exchange(a, i, j);
        }
        exchange(a, j, lo);
        return j;
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] arg) {
        //int[] data = new int[]{1, 4, 7, 3, 2, 8, 11, 43, 22, 15};
        int[]  data = new int[SIZE];
        for (int j = 0; j < SIZE; j++){
            data[j] = (int) (SIZE * Math.random());
        }

        //quickSort(data, 0, data.length - 1);
        threeDirectionQuickSort(data, 0, data.length - 1);
        int var3 = data.length;

        for (int i = 0; i < var3; i++) {
            StdOut.println(data[i]);
        }
    }
}
