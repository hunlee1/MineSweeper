public class 다이아 {
    public static void main(String[] args) {
        int i = 5;
        for(int row=0; row < i; row++){
            for (int column = i-1; column > row; column--){
                System.out.print(" ");
            }

            for (int column=0; column <2*row+1; column++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for(int row=1; row < i; row++){
            for(int column = 0; column < row; column++){
                System.out.print(" ");
            }

            for(int column=2*i-1; column >2*row; column--){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

