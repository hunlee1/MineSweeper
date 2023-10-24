import java.util.Scanner;

public class feature3 {
    public static void main(String[] args) {
        int boardSize = getBoardSizeFromUser();

        if (boardSize == -1) {
            System.out.println("유효한 크기를 입력하세요 (5~15). 프로그램을 종료합니다.");
            return;
        }

        char[][] gameBoard = createGameBoard(boardSize, 2);
        printGameBoard(gameBoard);
    }

    public static int getBoardSizeFromUser() {
        Scanner scanner = new Scanner(System.in);
        int boardSize;

        do {
            System.out.print("게임 보드 크기를 입력하세요 (5~15): ");
            boardSize = scanner.nextInt();

            if (boardSize < 5 || boardSize > 15) {
                System.out.println("입력값이 범위를 벗어났습니다. 다시 입력하세요.");
            }
        } while (boardSize < 5 || boardSize > 15);

        return boardSize;
    }

    public static char[][] createGameBoard(int size, int mineCount) {
        char[][] board = new char[size][size];
        // 이전에 작성한 지뢰 배치 로직을 그대로 사용
        // ...
        return board;
    }

    public static void printGameBoard(char[][] board) {
        // 이전에 작성한 게임 보드 출력 로직을 그대로 사용
        // ...
    }
}
