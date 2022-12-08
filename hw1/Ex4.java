import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * +Задано уравнение вида q + w = e, q, w, e >= 0.
 Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
 Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
 **/

public class Ex4 {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Insert equation in format 2? + ?5 = 69: ");
            String eq = sc.nextLine();
            sc.close();

            int result = getResult(eq);

            String[] expression = get_expr(eq);
            String left = expression[0];
            String right = expression[1];

            boolean flag = false;
            for (int i = 0; i < 10; i++) {
                int numLeft = Integer.parseInt(left.replace("?", String.valueOf(i)));

                for (int j = 0; j < 10; j++) {
                    int numRight = Integer.parseInt(right.replace("?", String.valueOf(j)));
                    if (result == numLeft + numRight) {
                        System.out.printf("%d + %d = %d", numLeft, numRight, result);
                        System.out.println();
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                System.out.println("No solutions!");
            }
        }catch (InputMismatchException | ArrayIndexOutOfBoundsException e){
            System.out.println("Incorrect data inserted!");
        }
    }

    private static String[] get_expr(String eq){
        String[] expr = new String[2];
        String ex = eq.split("=")[0];
        expr[0] = ex.split("\\+")[0].trim();
        expr[1] = ex.split("\\+")[1].trim();
        return expr;
    }

    private static int getResult(String eq) {
        String result_str = eq.split("=")[1].trim();
        return Integer.parseInt(result_str);
    }
}
