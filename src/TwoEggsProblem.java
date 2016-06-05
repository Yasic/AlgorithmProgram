/**
 * Created by Yasic on 2016/4/23.
 */
public class TwoEggsProblem {
    public TwoEggsProblem() {
    }

    private static int findLeastTime(int egg, int floor) {
        int[][] solutions = new int[egg + 1][floor + 1];

        int i;
        for(i = 1; i <= egg; ++i) {
            solutions[i][1] = 1;
            solutions[i][0] = 0;
        }

        int j;
        for(j = 1; j <= floor; solutions[1][j] = j++) {
            solutions[1][j] = 1;
        }

        for(i = 2; i <= egg; ++i) {
            for(j = 2; j <= floor; ++j) {
                solutions[i][j] = 9999;

                for(int x = 1; x <= j; ++x) {
                    int res = 1 + Math.max(solutions[i - 1][x - 1], solutions[i][j - x]);
                    solutions[i][j] = Math.min(solutions[i][j], res);
                }
            }
        }

        return solutions[egg][floor];
    }

    private static int findMinimumDetermineTime(int egg, int floor) {
        int minimum = 9999;
        boolean dex = true;
        boolean temp = false;
        if(egg == 1) {
            return floor;
        } else if(floor != 1 && floor != 0) {
            for(int var5 = 1; var5 <= floor; ++var5) {
                int var6 = 1 + Math.max(findMinimumDetermineTime(egg - 1, var5 - 1), findMinimumDetermineTime(egg, floor - var5));
                if(var6 < minimum) {
                    minimum = var6;
                }
            }

            return minimum;
        } else {
            return floor;
        }
    }

    private static int searchTime(int[] data) {
        int[] determinLocation = new int[]{14, 27, 39, 50, 60, 69, 77, 84, 90, 95, 99, 100};
        int time = 0;

        for(int target = 1; target <= 100; ++target) {
            for(int j = 0; j < determinLocation.length; ++j) {
                ++time;
                boolean completeFlag = false;
                if(data[determinLocation[j]] >= target) {
                    if(data[determinLocation[j]] > target) {
                        int low;
                        if(j == 0) {
                            low = 0;
                        } else {
                            low = determinLocation[j - 1];
                        }

                        for(int k = 1; k < determinLocation[j] - low; ++k) {
                            ++time;
                            if(data[low + k] == target) {
                                System.out.println("tf:" + target + "  time:" + time);
                                time = 0;
                                completeFlag = true;
                                break;
                            }
                        }
                    } else if(data[determinLocation[j]] == target) {
                        System.out.println("tf:" + target + "  time:" + time);
                        time = 0;
                        completeFlag = true;
                    }
                }

                if(completeFlag) {
                    break;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] data = new int[101];

        for(int i = 1; i <= 100; data[i] = i++) {
            ;
        }

        searchTime(data);
        System.out.println("Complete");
    }
}

