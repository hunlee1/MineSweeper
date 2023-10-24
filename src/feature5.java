import java.util.Random;

public class feature5 {
    public static void main(String[] args) {
        int size = 5; // 게임 보드 크기
        char[][] gameBoard = createGameBoard(size);

        printGameBoardWithSurroundingMines(gameBoard);
    }

    public static char[][] createGameBoard(int size) {
        char[][] board = new char[size][size];
        Random random = new Random();

        // 게임 보드 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = 'O';
            }
        }

        // 예시로 지뢰를 (1,1)과 (3,3)에 배치
        board[1][1] = 'X';
        board[3][3] = 'X';

        return board;
    }

    public static void printGameBoardWithSurroundingMines(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 'X') {
                    System.out.print("X ");
                } else {
                    int mineCount = countSurroundingMines(board, i, j);
                    System.out.print(mineCount + " ");
                }
            }
            System.out.println();
        }
    }

    public static int countSurroundingMines(char[][] board, int x, int y) {
        int count = 0;
        int size = board.length;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < size && j >= 0 && j < size && board[i][j] == 'X') {
                    count++;
                }
            }
        }

        return count;
    }
}
