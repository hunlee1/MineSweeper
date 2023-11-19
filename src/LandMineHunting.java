import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

// 범위 데이터를 담는 클래스
class Range {
    String prompt;
    int min;
    int max;

    Range(String prompt, int min, int max) {
        this.prompt = prompt;
        this.min = min;
        this.max = max;
    }
}

public class LandMineHunting {
    // 상수화된 변수 추가
    private static final int MIN_BOARD_SIZE = 5;
    private static final int MAX_BOARD_SIZE = 15;
    private static final char EMPTY_CELL = 'O';
    private static final char MINE_SYMBOL = 'X';
    private static final String EMPTY_SYMBOL = " ";

    // Scanner를 멤버 변수로 변경
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 게임 보드 크기 입력 및 범위 확인
        Range boardSizeRange = new Range("게임 보드 크기를 입력하세요 (" + MIN_BOARD_SIZE + "-" + MAX_BOARD_SIZE + "): ", MIN_BOARD_SIZE, MAX_BOARD_SIZE);
        int boardSize = getInputInRange(boardSizeRange);

        // 지뢰 개수 입력 및 범위 확인
        int totalMines = getInputInRange(new Range("지뢰 개수를 입력하세요 (" + (int) (boardSize * boardSize * 0.1) + " ~ " + (int) (boardSize * boardSize * 0.2) + "): ",
                (int) (boardSize * boardSize * 0.1), (int) (boardSize * boardSize * 0.2)));

        // 게임 보드 생성
        char[][] gameBoard = createGameBoard(boardSize, totalMines);

        // 게임 보드 출력
        printGameBoard(gameBoard);
    }

    // Range 클래스를 인자로 받도록 수정
    private static int getInputInRange(Range range) {
        int inputValue = 0;
        do {
            System.out.print(range.prompt);
            inputValue = scanner.nextInt();
            if (inputValue < range.min || inputValue > range.max) {
                System.out.println("입력값이 범위를 벗어났습니다. 다시 입력하세요.");
            }
        } while (inputValue < range.min || inputValue > range.max);
        return inputValue;
    }

    private static char[][] createGameBoard(int size, int totalMines) {
        char[][] board = new char[size][size];
        Random random = new Random();

        // 게임 보드 초기화
        for (char[] row : board) {
            Arrays.fill(row, EMPTY_CELL);
        }

        // 지뢰 랜덤 배치
        while (totalMines > 0) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);

            if (board[x][y] != MINE_SYMBOL) {
                board[x][y] = MINE_SYMBOL;
                totalMines--;
            }
        }

        return board;
    }

    private static void printGameBoard(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == MINE_SYMBOL) {
                    System.out.print(MINE_SYMBOL + " ");
                } else {
                    int mineCount = countSurroundingMines(board, i, j);
                    System.out.print(mineCount + EMPTY_SYMBOL);
                }
            }
            System.out.println();
        }
    }

    private static int countSurroundingMines(char[][] board, int x, int y) {
        int count = 0;
        int size = board.length;

        if (!isValidCell(x - 1, y, size) || board[x - 1][y] == MINE_SYMBOL) {
            count++;
        }

        if (!isValidCell(x + 1, y, size) || board[x + 1][y] == MINE_SYMBOL) {
            count++;
        }

        if (!isValidCell(x, y - 1, size) || board[x][y - 1] == MINE_SYMBOL) {
            count++;
        }

        if (!isValidCell(x, y + 1, size) || board[x][y + 1] == MINE_SYMBOL) {
            count++;
        }

        return count;
    }

    private static boolean isValidCell(int x, int y, int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}
