public class 모래시계 {
    public static void main(String[] args) {
        int start = 0, end = 10;
        for (int row = 0; row < 9; row++) {
            if (row < 10 / 2) {
                start = row; end--;
            } else {
                start--; end++;
            }

            for (int column = start; column > 0; column--) {
                System.out.print(" ");
            }
            for (int column = start; column < end; column++) {
                System.out.print("*");
            }
                System.out.print("\n");
        }
    }
}