import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OilDrilling {
    public static void main(String[] args) {
        // 예시 입력
        int[][] land1 = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };

        int[][] land2 = {
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        };

        // 예시 호출
        printResult(land1);
        printResult(land2);
    }

    public static void printResult(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        int[][] dp = new int[n][m];


        for (int j = 0; j < m; j++) {
            dp[0][j] = land[0][j];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = land[i][j] + maxOfPreviousRow(dp[i - 1], j);
            }
        }

        int result = maxOfRow(dp[n - 1]);
        System.out.println("시추관의 위치\t   획득한 덩어리\t    총 석유량");
        for (int j = 0; j < m; j++) {
            System.out.println((j + 1) + "\t\t" + Arrays.toString(getOilPieces(land, dp, n - 1, j)) + "\t\t" + dp[n - 1][j]);
        }
        System.out.println("최종 결과: " + result);
        System.out.println();
    }

    private static int maxOfRow(int[] arr) {
        int max = 0;
        for (int value : arr) {
            max = Math.max(max, value);
        }
        return max;
    }

    private static int maxOfPreviousRow(int[] row, int excludeIndex) {
        int max = 0;
        for (int i = 0; i < row.length; i++) {
            if (i != excludeIndex) {
                max = Math.max(max, row[i]);
            }
        }
        return max;
    }

    private static int[] getOilPieces(int[][] land, int[][] dp, int i, int j) {
        List<Integer> pieces = new ArrayList<>();
        while (i >= 0) {
            pieces.add(land[i][j]);
            int maxIndex = maxOfPreviousRowIndex(dp[i], j);
            if (maxIndex == -1) {
                break;
            }
            j = maxIndex;
            i--;
        }
        Collections.reverse(pieces);
        return pieces.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int maxOfPreviousRowIndex(int[] row, int excludeIndex) {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < row.length; i++) {
            if (i != excludeIndex && row[i] > max) {
                max = row[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
