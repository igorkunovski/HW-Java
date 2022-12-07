//Реализовать простой калькулятор

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Insert first number: ");
            double num1 = sc.nextDouble();

            System.out.println("Insert calculation action: + - * /  ");
            String action = String.valueOf(sc.next());

            System.out.println("Insert second number: ");
            double num2 = sc.nextDouble();
            sc.close();

            calculate(num1, action, num2);

        } catch (InputMismatchException | ArithmeticException e){
            System.out.println("Incorrect data inserted!");
        }
    }

    private static void calculate(double num1, String action, double num2) {
        switch (action){
            case "+" :
                System.out.printf("Result: %.3f + %.3f = %.3f", num1, num2, num1+num2);
                break;
            case "-" :
                System.out.printf("Result: %.3f - %.3f = %.3f", num1, num2, num1-num2);
                break;
            case "*" :
                System.out.printf("Result: %.3f * %.3f = %.3f", num1, num2, num1*num2);
                break;
            case "/" :
                if (num2 != 0) {
                    System.out.printf("Result: %.3f / %.3f = %.3f", num1, num2, num1/num2);
                } else{
                    throw new ArithmeticException(" Division by zeo!");
                }
                break;
            default:
                System.out.println("Incorrect action!");
        }
    }
}
