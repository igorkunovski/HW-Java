/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */

import java.util.*;

public class Hw5Ex1 {
    public static void main(String[] args) {
        Map<String, Set<Integer>> phones = new HashMap<>();
        insertContact(phones);
    }

    private static void insertContact(Map<String, Set<Integer>> phones) {

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Insert name (or q to quit): ");
            String name = sc.next();
            if (name.equalsIgnoreCase("q")){
                System.out.println(phones);
                break;
            }

            System.out.println("Insert phone: ");
            Integer number = sc.nextInt();

            if (phones.containsKey(name)) {
                phones.get(name).add(number);
                System.out.println(phones);
            } else {

                Set<Integer> empty = new HashSet<>();
                empty.add(number);
                phones.put(name, empty);
                System.out.println(phones);
            }
        }
    }
}