/*
Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
 */

import java.util.LinkedList;
import java.util.Random;

public class Hw4Ex1 {
    public static void main(String[] args) {
        int n = 10;
        LinkedList<Integer> numbers = generateArray(n);
        System.out.println("Generated list: " + numbers);
        numbers = myReverse(numbers);
        System.out.println("Reversed list: " + numbers);

    }

    private static LinkedList<Integer> myReverse(LinkedList<Integer> lst) {
        LinkedList<Integer> res = new LinkedList<>();
        for (Integer num: lst){
            res.addFirst(num);
        }
        return res;
    }

    private static LinkedList<Integer> generateArray(int n) {
        LinkedList<Integer> ll = new LinkedList<>();
        Random rnd = new Random();
        for (int i = 0; i< n; i++) {
            ll.add(rnd.nextInt(1, 20));
        }
        return ll;
    }
}
