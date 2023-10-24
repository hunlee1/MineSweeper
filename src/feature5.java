import static MineSweeper.feature.createGameBoard;

public class feature5 {
    public static void main(String[] args) {
        // 게임 보드 생성 및 지뢰 배치는 이전 코드와 동일하게 수행합니다.
        char[][] gameBoard = createGameBoard(5, 2); // 5x5 보드에 2개의 지뢰 배치 예시

        // 주변 지뢰 개수 계산 및 출력
        calculateNeighborMineCounts(gameBoard);
        printGameBoard(gameBoard);
    }

    public static void calculateNeighborMineCounts(char[][] board) {
        int width = board.length;
        int height = board[0].length;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] != 'X') {
                    int mineCount = countNeighborMines(board, i, j);
                    if (mineCount > 0) {
                        board[i][j] = (char) ('0' + mineCount);
                    } else {
                        board[i][j] = 'O';
                    }
                }
            }
        }
    }

    public static int countNeighborMines(char[][] board, int x, int y) {
        int width = board.length;
        int height = board[0].length;
        int mineCount = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;

                if (newX >= 0 && newX < width && newY >= 0 && newY < height && board[newX][newY] == 'X') {
                    mineCount++;
                }
            }
        }

        return mineCount;
    }

    public static void printGameBoard(char[][] board) {
        int width = board.length;
        int height = board[0].length;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
