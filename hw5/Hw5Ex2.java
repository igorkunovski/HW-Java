/*
Пусть дан список сотрудников:Иван Иванов и тд. Написать программу, которая найдет и выведет повторяющиеся имена с
количеством повторений. Отсортировать по убыванию популярности.
 */

import java.util.*;
import java.util.stream.Stream;

public class Hw5Ex2 {
    public static void main(String[] args) {

        Map<String, Integer> overlap = new HashMap<>();
        Map<String, Integer> sorted = new LinkedHashMap<>();

        ArrayList<String> emp = new ArrayList<>();
        emp.add("Ivan Ivanov");
        emp.add("Petr Petrov");
        emp.add("Ivan Ivanov");
        emp.add("Sergei Ivanov");
        emp.add("Ivan Ivanov");
        emp.add("Sergei Ivanov");
        emp.add("Petr Petrov");
        emp.add("Petr Petrov");
        emp.add("Elena Petrova");
        emp.add("Elena Petrova");
        emp.add("Ilon Mask");

        for (String name : emp) {
            if (!overlap.containsKey(name)) {
                overlap.put(name, 1);
            } else {
                overlap.put(name, overlap.get(name) + 1);
            }
        }
        System.out.println(overlap);

        Integer max = 0;
        String name = "";

        for (int i =0; i < overlap.size(); i++) {

            for (var item : overlap.entrySet()) {
                if (item.getValue() > max && !sorted.containsKey(item.getKey())) {
                    max = item.getValue();
                    name = item.getKey();
                }
            }
            sorted.put(name, max);
            max = 0;
            name = "";
        }
        System.out.println(sorted);
    }
}
