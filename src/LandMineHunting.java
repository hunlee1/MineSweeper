import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class InputRange {
    int min;
    int max;

    InputRange(int min, int max) {
        this.min = min;
        this.max = max;
    }
}


public class LandMineHunting {

    private static final int MIN_BOARD_SIZE = 5;
    private static final int MAX_BOARD_SIZE = 15;
    private static final char EMPTY_CELL = 'O';
    private static final char MINE_SYMBOL = 'X';
    private static final String EMPTY_CELL_SYMBOL = " ";
    // 상수로 빈 셀을 나타내는 문자를 정의 (↑코드)

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String inputBoardSizeMsg = "게임 보드 크기를 입력하세요 (" + MIN_BOARD_SIZE + "-" + MAX_BOARD_SIZE + "): ";
        InputRange boardSizeRange = new InputRange(MIN_BOARD_SIZE, MAX_BOARD_SIZE);
        int boardSize = getInputInRange(inputBoardSizeMsg, boardSizeRange);

        int minMines = (int) (boardSize * boardSize * 0.1);
        int maxMines = (int) (boardSize * boardSize * 0.2);
        String inputMinesMsg = "지뢰 개수를 입력하세요 (" + minMines + " ~ " + maxMines + "): ";
        InputRange minesRange = new InputRange(minMines, maxMines);
        int totalMines = getInputInRange(inputMinesMsg, minesRange);

        char[][] gameBoard = createGameBoard(boardSize, totalMines);

        printGameBoard(gameBoard);
    }

    private static int getInputInRange(String prompt, InputRange range) {
        int inputValue = 0;
        do {
            System.out.print(prompt);
            inputValue = scanner.nextInt();
            if (inputValue < range.min || inputValue > range.max) {
                System.out.println("입력값이 범위를 벗어났습니다. 다시 입력하세요.");
            }
        } while (inputValue < range.min || inputValue > range.max);
        return inputValue;
    }

    private static char[][] createGameBoard(int size, int totalMines) {
        char[][] board = InitializeGameBoard(size);
        Random random = new Random();

        placeMines(board, totalMines, random);

        return board;
    }
    private static char[][] InitializeGameBoard(int size) {
        char[][] board = new char[size][size];
        for (char[] row : board) {
            Arrays.fill(row, EMPTY_CELL);
        }
        return board;
    }

    private static void placeMines(char[][] board, int totalMines, Random random) {
        while (totalMines > 0) {
            int x = random.nextInt(board.length);
            int y = random.nextInt(board[0].length);

            if (board[x][y] != MINE_SYMBOL) {
                board[x][y] = MINE_SYMBOL;
                totalMines--;
            }
        }
    }

    private static void printGameBoard(char[][] board) {
        int size = board.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == MINE_SYMBOL) {
                    System.out.print(MINE_SYMBOL + EMPTY_CELL_SYMBOL);
                } else {
                    int mineCount = countSurroundingMines(board, i, j);
                    System.out.print(mineCount + EMPTY_CELL_SYMBOL);
                }
            }
            System.out.println();
        }
    }
    private static int countSurroundingMines(char[][] board, int x, int y) {
        int count = 0;
        int size = board.length;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (isValidCell(i, j, size) && board[i][j] == MINE_SYMBOL) {
                    count++;
                }
            }
        }

        return count;
    }


    private static boolean isValidCell(int x, int y, int size) {
        if (x < 0)
            return false;
        if (x >= size)
            return false;
        if (y < 0)
            return false;
        if (y >= size)
            return false;

        return true;
    }
}

