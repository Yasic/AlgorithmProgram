package Sort;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Yasic on 2016/4/23.
 */
public class ShellSort {
    public ShellSort() {
    }

    public static int[] shellSort(int[] data) {
        int step = 1;
        int length = data.length;

        for(boolean temp = false; step < length / 3; step = step * 3 + 1) {
            ;
        }

        while(step >= 1) {
            for(int i = step; i < length; ++i) {
                for(int j = i; j >= step && data[j] < data[j - step]; j -= step) {
                    int var6 = data[j];
                    data[j] = data[j - step];
                    data[j - step] = var6;
                }
            }

            step /= 3;
        }

        return data;
    }

    public static void main(String[] arg) {
        int[] data = new int[]{1, 4, 7, 3, 2, 8, 11, 43, 22, 15};
        shellSort(data);
        int[] var2 = data;
        int var3 = data.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int i = var2[var4];
            StdOut.println(i);
        }

    }
}

