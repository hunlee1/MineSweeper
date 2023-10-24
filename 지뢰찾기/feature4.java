import java.util.Scanner;

public class feature4 {
    public static void main(String[] args) {
        int boardSize = getBoardSizeFromUser();

        if (boardSize == -1) {
            System.out.println("유효한 크기를 입력하세요 (5~15). 프로그램을 종료합니다.");
            return;
        }

        int mineCount = getMineCountFromUser(boardSize);

        if (mineCount == -1) {
            System.out.println("유효한 지뢰 개수를 입력하세요 (10%~20% 범위 내). 프로그램을 종료합니다.");
            return;
        }

        char[][] gameBoard = createGameBoard(boardSize, mineCount);
        printGameBoard(gameBoard);
    }

    public static int getBoardSizeFromUser() {
        Scanner scanner = new Scanner(System.in);
        int boardSize;

        do {
            System.out.print("게임 보드 크기를 입력하세요 (5~15): ");
            boardSize = scanner.nextInt();

            if (boardSize < 5 || boardSize > 15) {
                System.out.println("유효한 크기를 입력하세요 (5~15).");
            }
        } while (boardSize < 5 || boardSize > 15);

        return boardSize;
    }

    public static int getMineCountFromUser(int boardSize) {
        Scanner scanner = new Scanner(System.in);
        int minMineCount = (int) (0.1 * boardSize * boardSize);
        int maxMineCount = (int) (0.2 * boardSize * boardSize);
        int mineCount;

        do {
            System.out.print("지뢰의 개수를 입력하세요 (" + minMineCount + "~" + maxMineCount + "): ");
            mineCount = scanner.nextInt();

            if (mineCount < minMineCount || mineCount > maxMineCount) {
                System.out.println("유효한 지뢰 개수를 입력하세요 (" + minMineCount + "~" + maxMineCount + ").");
            }
        } while (mineCount < minMineCount || mineCount > maxMineCount);

        return mineCount;
    }

    public static char[][] createGameBoard(int size, int mineCount) {
        char[][] board = new char[size][size];
        // 지뢰 배치 로직은 이전과 동일
        // ...
        return board;
    }

    public static void printGameBoard(char[][] board) {
        // 게임 보드 출력 로직은 이전과 동일
        // ...
    }
}
