import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class landminehunting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 게임 보드 크기 입력 및 범위 확인
        int boardSize = getInputInRange(scanner, "게임 보드 크기를 입력하세요 (5-15): ", 5, 15);

        // 지뢰 개수 입력 및 범위 확인
        int totalMines = getInputInRange(scanner, "지뢰 개수를 입력하세요 (" + (int) (boardSize * boardSize * 0.1) + " ~ " + (int) (boardSize * boardSize * 0.2) + "): ",
                (int) (boardSize * boardSize * 0.1), (int) (boardSize * boardSize * 0.2));

        // 게임 보드 생성
        char[][] gameBoard = createGameBoard(boardSize, totalMines);

        // 게임 보드 출력
        printGameBoard(gameBoard);
    }

    private static int getInputInRange(Scanner scanner, String prompt, int min, int max) {
        int inputValue = 0;
        do {
            System.out.print(prompt);
            inputValue = scanner.nextInt();
            if (inputValue < min || inputValue > max) {
                System.out.println("입력값이 범위를 벗어났습니다. 다시 입력하세요.");
            }
        } while (inputValue < min || inputValue > max);
        return inputValue;
    }

    public static char[][] createGameBoard(int size, int totalMines) {
        char[][] board = new char[size][size];
        Random random = new Random();

        // 게임 보드 초기화
        for (char[] row : board) {
            Arrays.fill(row, 'O');
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
                if (isValidCell(i, j, size) && board[i][j] == 'X') {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValidCell(int x, int y, int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}
