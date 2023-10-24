import java.util.Scanner;
import java.util.Random;

public class dlwlgns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 게임 보드 크기 입력 및 범위 확인
        int boardSize = 0;
        while (boardSize < 5 || boardSize > 15) {
            System.out.print("게임 보드 크기를 입력하세요 (5-15): ");
            boardSize = scanner.nextInt();
            if (boardSize < 5 || boardSize > 15) {
                System.out.println("입력값이 범위를 벗어났습니다. 다시 입력하세요.");
            }
        }

        // 지뢰 개수 입력 및 범위 확인
        int totalMines = 0;
        while (totalMines < (int)(boardSize * boardSize * 0.1) || totalMines > (int)(boardSize * boardSize * 0.2)) {
            System.out.print("지뢰 개수를 입력하세요 (" + (int)(boardSize * boardSize * 0.1) + " ~ " + (int)(boardSize * boardSize * 0.2) + "): ");
            totalMines = scanner.nextInt();
            if (totalMines < (int)(boardSize * boardSize * 0.1) || totalMines > (int)(boardSize * boardSize * 0.2)) {
                System.out.println("입력값이 범위를 벗어났습니다. 다시 입력하세요.");
            }
        }

        // 게임 보드 생성
        char[][] gameBoard = createGameBoard(boardSize, totalMines);

        // 게임 보드 출력
        printGameBoard(gameBoard);
    }

    public static char[][] createGameBoard(int size, int totalMines) {
        char[][] board = new char[size][size];
        Random random = new Random();

        // 게임 보드 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = 'O';
            }
        }

        // 지뢰 랜덤 배치
        while (totalMines > 0) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);

            if (board[x][y] != 'X') {
                board[x][y] = 'X';
                totalMines--;
            }
        }

        return board;
    }

    public static void printGameBoard(char[][] board) {
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
