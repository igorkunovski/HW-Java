/*
 * В калькулятор добавьте возможность отменить последнюю операцию.
 */
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;


public class Hw4Ex3 {
    public static void main(String[] args) {

        LinkedList<String> operations = new LinkedList<>();

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Insert command: calc, remove, log or exit to quit: ");
                String command = sc.next();

                if ("exit".equalsIgnoreCase(command)){
                    sc.close();
                    break;
                }

                switch (command){
                    case "calc" :

                        Scanner calc = new Scanner(System.in);

                        System.out.println("Insert first number: ");
                        double num1 = calc.nextDouble();

                        System.out.println("Insert calculation action: + - * /  ");
                        String action = String.valueOf(sc.next());

                        System.out.println("Insert second number: ");
                        double num2 = calc.nextDouble();

                        calculate(num1, action, num2, operations);
                        System.out.println();
                        break;

                    case "remove":
                        if (operations.size()>0) {
                            System.out.println("Last operation successfully removed if presented");
                        }
                        removeLastOperation(operations);

                        break;
                    case "log":
                        System.out.println("*** LOG START***");
                        showOperations(operations);
                        System.out.println("***LOG END***");
                        break;

                    default:
                        System.out.println("Unknown command");
                }

            } catch (InputMismatchException | ArithmeticException e) {
                System.out.println("Incorrect data inserted!");
            }
        }
    }

    private static void showOperations(LinkedList<String> log) {
        for (String s : log) {
            System.out.println(s);
        }
    }

    private static void removeLastOperation(LinkedList<String> log) {
        if (log.size() > 0) {
            log.removeFirst();
        }else {
            System.out.println("List is empty");
        }
    }

    private static void calculate(double num1, String action, double num2, LinkedList<String> log) {
        switch (action){
            case "+" :
                System.out.printf("Result: %.3f + %.3f = %.3f", num1, num2, num1+num2);
                log.addFirst("Result: " + num1 + " + " + num2 + " = " + (num1+num2));
                break;
            case "-" :
                System.out.printf("Result: %.3f - %.3f = %.3f", num1, num2, num1-num2);
                log.addFirst("Result: " + num1 + " -" + num2 + " = " + (num1-num2));
                break;
            case "*" :
                System.out.printf("Result: %.3f * %.3f = %.3f", num1, num2, num1*num2);
                log.addFirst("Result: " + num1 + " * " + num2 + " = " + (num1*num2));
                break;
            case "/" :
                if (num2 != 0) {
                    System.out.printf("Result: %.3f / %.3f = %.3f", num1, num2, num1/num2);
                    log.addFirst("Result: " + num1 + " / " + num2 + " = " + (num1/num2));
                } else{
                    throw new ArithmeticException(" Division by zeo!");
                }
                break;
            default:
                System.out.println("Incorrect action!");
        }
    }
}
