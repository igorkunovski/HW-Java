/*
К калькулятору из предыдущего дз добавить логирование.
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Hw2Ex4 {

    public static void main(String[] args) throws IOException {

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

    private static void calculate(double num1, String action, double num2) throws IOException {

        Logger logger = Logger.getLogger(Hw2Ex4.class.getName());
        FileHandler fh = new FileHandler("C:\\Users\\Laptop\\IdeaProjects\\HW-Java\\hw2\\logCalc.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sForm = new SimpleFormatter();
        fh.setFormatter(sForm);

        switch (action){
            case "+" :
                System.out.printf("Result: %.3f + %.3f = %.3f", num1, num2, num1+num2);
                System.out.println();
                logger.log(Level.INFO, "Result: " + num1 + " + " + num2 + " = " + (num1+num2));
                break;
            case "-" :
                System.out.printf("Result: %.3f - %.3f = %.3f", num1, num2, num1-num2);
                System.out.println();
                logger.log(Level.INFO, "Result: " + num1 + " - " + num2 + " = " + (num1-num2));
                break;
            case "*" :
                System.out.printf("Result: %.3f * %.3f = %.3f", num1, num2, num1*num2);
                System.out.println();
                logger.log(Level.INFO, "Result: " + num1 + " * " + num2 + " = " + (num1*num2));
                break;
            case "/" :
                if (num2 != 0) {
                    System.out.printf("Result: %.3f / %.3f = %.3f", num1, num2, num1/num2);
                    System.out.println();
                    logger.log(Level.INFO, "Result: " + num1 + " / " + num2 + " = " + (num1/num2));
                } else{
                    logger.log(Level.WARNING, "Result: " + num1 + " / " + num2 + " =  Division by zeo!");
                    System.out.println();
                    throw new ArithmeticException(" Division by zeo!");
                }
                break;
            default:
                System.out.println("Incorrect action!");
                logger.log(Level.WARNING, "Incorrect action!");
        }
    }
}


