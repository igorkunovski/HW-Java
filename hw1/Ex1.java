import java.util.Scanner;
//Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
// (произведение чисел от 1 до n)

public class Ex1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int n = sc.nextInt();
        int res = 0;
//        int res = 1;  // для n!
        if (n > 0) {
            while (n > 0){
                res += n;
//                res *= n;  // для n!
                n--;
            }
        } else {
            while (n < 0){
                res += n;
                n++;
            }
        }
        System.out.printf("Ответ: %d", res);
        sc.close();
    }
}