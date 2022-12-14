/*
Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
 */

import java.util.ArrayList;
import java.util.Random;

public class Hw3Ex3 {
    public static void main(String[] args) {

        int size = 20;
        ArrayList<Integer> numbers = generateList(size);
        System.out.println(numbers);
        findMinMaxAver(numbers);
    }

    private static void findMinMaxAver(ArrayList<Integer> numbers) {
        Integer max = numbers.get(0);
        Integer min = numbers.get(0);
        double sum = 0;
        for (Integer number: numbers) {
            if (number > max){
                max = number;
            }else if(number < min){
                min = number;
            }
            sum += number;
        }
        double aver = (sum / numbers.size());
        System.out.printf("Max number: %d, Min number: %d, average number: %.3f ", max, min, aver);
    }

    private static ArrayList<Integer> generateList(int size) {
        Random rnd = new Random();
        ArrayList<Integer> generated = new ArrayList<>(size);

        for (int i = 0; i < size; i++){
            generated.add(rnd.nextInt(1,50));
        }
        return generated;
    }
}
