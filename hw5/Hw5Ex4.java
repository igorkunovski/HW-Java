/*
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */
public class Hw5Ex4 {
    static int [][] board = new int[8][8]; //поле

    public static void main(String[] args) {

        for (int i =0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;    //заполнили поле 0
            }
        }

        tryQueen(0);    //начинаем с 0,0

        for (int i =0; i<8; i++){
            for (int j=0; j<8; j++){
                if (board[i][j] == -1){
                    System.out.print("[]");
                }else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    private static boolean tryQueen(int i){

        boolean result = false;

        for (int j = 0; j <8; j++){
            if (board[i][j] == 0){
                setQueen(i,j);
                if (i==7){
                    result = true;
                }else {
                    if(!(result = tryQueen(i+1))){
                        resetQueen(i, j);
                    }
                }
                if (result){
                    break;  //выход при найденой позиции
                }
            }
        }
        return result;
    }

    private static void resetQueen(int i, int j) {

        for (int x = 0; x < 8; x++) {
            --board[x][j];
            --board[i][x];
            int diagonal;

            diagonal = j - i + x;
            if (diagonal >= 0 && diagonal < 8) {
                --board[x][diagonal];
            }

            diagonal = j + i - x;
            if (diagonal >= 0 && diagonal < 8) {
                --board[x][diagonal];
            }

            board[i][j] = 0; //возврат 0 на позицию ферзя
        }
    }

    private static void setQueen(int i, int j) {
        for (int x = 0; x < 8; x++) {
            ++board[x][j];
            ++board[i][x];
            int diagonal;

            diagonal = j - i + x;
            if (diagonal >= 0 && diagonal < 8) {
                ++board[x][diagonal];
            }

            diagonal = j + i - x;
            if (diagonal >= 0 && diagonal < 8) {
                ++board[x][diagonal];
            }
            board[i][j] = -1; // там стоит ферзь
        }
    }
}

