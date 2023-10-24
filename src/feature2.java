import java.util.Random;

public class feature2 {
    public static void main(String[] args) {
        char[][] gameBoard = createGameBoard(5, 5, 2);
        printGameBoard(gameBoard);
    }

    public static char[][] createGameBoard(int width, int height, int mineCount) {
        char[][] board = new char[width][height];
        Random random = new Random();

        // 게임 보드 초기화
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = 'O';
            }
        }

        // 지뢰 랜덤 배치
        while (mineCount > 0) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);

            if (board[x][y] != 'X') {
                board[x][y] = 'X';
                mineCount--;
            }
        }

        return board;
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
