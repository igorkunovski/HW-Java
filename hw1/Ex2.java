//Вывести все простые числа от 1 до 1000

public class Ex2 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int counter = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 2; j < i/2+1; j++) {
                if (i % j == 0) {
                    counter++;
                }
            }
            if (counter == 0) {
                result.append(i).append(", ");
            } else {
                counter = 0;
            }
        }
        System.out.printf("Простые числа: %s", result.substring(0, result.length()-2));
    }
}