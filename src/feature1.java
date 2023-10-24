public class feature1 {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;
        char[][] gameBoard = createGameBoard(rows, columns);

        // 게임 보드 출력
        printGameBoard(gameBoard);
    }

    public static char[][] createGameBoard(int rows, int columns) {
        char[][] board = new char[rows][columns];

        // 게임 보드 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = '0'; // 빈 칸을 나타내는 'O'로 초기화
            }
        }

        return board;
    }

    public static void printGameBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
