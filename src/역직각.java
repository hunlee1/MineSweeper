public class 역직각 {
    public static void main(String[] args) {

        for(int row = 0; row < 6; row++){
            for (int column = 0; column < 5-row; column++){
                System.out.print("*"); // row < 여기에 변수를 넣을수 있음 예) row
            }
            System.out.print("\n"); // 줄넘김
        }
    }
}