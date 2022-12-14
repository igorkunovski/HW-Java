/*
Пусть дан произвольный список целых чисел, удалить из него четные числа
 */

import java.util.ArrayList;
import java.util.Random;

public class Hw3Ex2 {
    public static void main(String[] args) {

        int size = 20;
        ArrayList<Integer> numbers = generateList(size);
        System.out.println(numbers);
        System.out.println(clearOdds(numbers));
    }

    private static ArrayList<Integer> clearOdds(ArrayList<Integer> numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer number: numbers) {
            if (number % 2 != 0){
                result.add(number);
            }
        }
        return result;
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
