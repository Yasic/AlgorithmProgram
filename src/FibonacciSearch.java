/**
 * Created by Yasic on 2016/4/23.
 */
public class FibonacciSearch {
    public FibonacciSearch() {
    }

    public static int[] createFibonacci() {
        int[] fibonacci = new int[20];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for(int i = 2; i < fibonacci.length; ++i) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }

    public static int searchFibonacci(int[] data, int target) {
        int[] fibonacci = createFibonacci();
        int low = 0;
        boolean high = false;
        boolean mid = false;
        int flag = data.length - 1;

        int indexMax;
        for(indexMax = 0; fibonacci[indexMax] < flag; ++indexMax) {
            ;
        }

        for(int var8 = flag; low <= var8; --indexMax) {
            int var9 = low + fibonacci[indexMax - 2] - 1;
            if(data[var9] > target) {
                var8 = var9 - 1;
            } else {
                if(data[var9] >= target) {
                    if(var9 < flag) {
                        return var9 + 1;
                    }

                    return flag + 1;
                }

                low = var9 + 1;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        boolean mid = false;

        while(low <= high) {
            int mid1 = (low + high) / 2;
            if(data[mid1] > target) {
                high = mid1 - 1;
            } else {
                if(data[mid1] >= target) {
                    return mid1 + 1;
                }

                low = mid1 + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] testData = new int[]{1, 2, 5, 6, 10, 45, 66, 84, 92, 94};
        byte target = 10;
        System.out.println(searchFibonacci(testData, target) + "\n");
        System.out.println(binarySearch(testData, target) + "\n");
        target = 95;
        System.out.println(searchFibonacci(testData, target) + "\n");
        System.out.println(binarySearch(testData, target) + "\n");
        target = 93;
        System.out.println(searchFibonacci(testData, target) + "\n");
        System.out.println(binarySearch(testData, target) + "\n");
        target = 3;
        System.out.println(searchFibonacci(testData, target) + "\n");
        System.out.println(binarySearch(testData, target) + "\n");
        target = 45;
        System.out.println(searchFibonacci(testData, target) + "\n");
        System.out.println(binarySearch(testData, target) + "\n");
    }
}
