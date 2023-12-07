import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OilDrilling {
    public static void main(String[] args) {
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };
        int n = land.length;
        int m = land[0].length;


        int[][] dp = new int[n][m];
        System.arraycopy(land[0], 0, dp[0], 0, m);


        for (int i = 1; i < n; i++) {
            int[] maxValues = getMaxValues(dp[i - 1]);
            for (int j = 0; j < m; j++) {
                dp[i][j] = maxValues[j] + land[i][j];
            }
        }


        int result = getMaxValue(dp[n - 1]);


        System.out.println("가장 많은 석유량: " + result);
    }

    private static int[] getMaxValues(int[] row) {
        int length = row.length;
        int[] maxValues = new int[length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, row[i]);
            maxValues[i] = max;
        }

        max = Integer.MIN_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            max = Math.max(max, row[i]);
            maxValues[i] = Math.max(maxValues[i], max);
        }

        return maxValues;
    }

    private static int getMaxValue(int[] row) {
        int max = Integer.MIN_VALUE;
        for (int value : row) {
            max = Math.max(max, value);
        }
        return max;
    }
}
