public class 피라미드 {
    public static void main(String[] args) {
        int i = 5;
        for(int row=0; row < i; row++){
            for (int column = i-1; column > row; column--){
                System.out.print(" "); // row < 여기에 변수를 넣을수 있음 예) row
            }
            //System.out.print("\n"); // 줄넘김

            for (int column=0; column <2*row+1; column++){
                System.out.print("*"); // row < 여기에 변수를 넣을수 있음 예) row
            }
            System.out.print("\n"); // 줄넘김
        }
    }
}
