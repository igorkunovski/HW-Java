/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
и выведет ноутбуки,отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую
необходимому критерию. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры
фильтрации можно также в Map. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Notebook> notebooks = new HashSet<>();

        Notebook nb1 = new Notebook("Apple", "SSD", 512, 16, 17);
        Notebook nb2 = new Notebook("Lenovo", "SSD", 256, 8, 15);
        Notebook nb3 = new Notebook("ASUS", "HD", 1000, 8, 17);
        Notebook nb4 = new Notebook("HP", "SSD", 128, 4, 14);
        Notebook nb5 = new Notebook("Apple", "SSD", 256, 8, 13);
        Notebook nb6 = new Notebook("Apple", "SSD", 256, 8, 13);

        putInSet(notebooks, nb1);
        putInSet(notebooks, nb2);
        putInSet(notebooks, nb3);
        putInSet(notebooks, nb4);
        putInSet(notebooks, nb5);
        putInSet(notebooks, nb6);

        Set<Notebook> found =  findNotebook(notebooks);

        System.out.println("***found notebooks***");
        System.out.println(found.size());
        for (Notebook nb: found) {
            System.out.println(nb);
        }
    }

    private static Set<Notebook> findNotebook(Set<Notebook> notebooks) {
        Set<Notebook> result = new HashSet<>();

        Map<Integer, String> filter = new HashMap<>();
        String choice;

        do {
            System.out.println("Введите номер поля для поиска и Enter: ");
            System.out.println("1 : По производителю");
            System.out.println("2 : По типу жесткого диска (SSD, HD)");
            System.out.println("3 : По объему памяти ЖД GB");
            System.out.println("4 : По объему оперативной памяти GB RAM");
            System.out.println("5 : По размеру диагонали монитора");
            System.out.println("Q : искать");

            Scanner sc = new Scanner(System.in);
            choice = sc.nextLine().toLowerCase();
            choiceSwitch(filter, choice, sc);

        } while (!choice.equals("q"));

        return findNotebooks(notebooks, result, filter);
    }

    private static Set<Notebook> findNotebooks(Set<Notebook> notebooks, Set<Notebook> result, Map<Integer, String> filter) {
        for (Notebook nb: notebooks) {
            Set<String> values = new HashSet<>(filter.values());

            if (values.size() > 0) {
                boolean flag = true;
                for (String val : values) {
                    if (!nb.toString().toLowerCase().contains(val.toLowerCase())) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result.add(nb);
                }
            }
        }
        return result;
    }

    private static void choiceSwitch(Map<Integer, String> filter, String choice, Scanner sc) {
        switch (choice){
            case "1" :
                System.out.println("Введите производителя");
                String prod = sc.nextLine();
                filter.put(1, prod);
                break;
            case "2" :
                System.out.println("Введите тип жесткого диска (HD, SSD)");
                String disc = sc.nextLine();
                filter.put(2, disc);
                break;
            case "3" :
                System.out.println("Введите желаемый объем памяти");
                String mem = sc.nextLine();
                filter.put(3, mem);
                break;
            case "4" :
                System.out.println("Введите желаемый объем оперативной памяти RAM");
                String ram = sc.nextLine();
                filter.put(4, ram);
                break;
            case "5" :
                System.out.println("Введите желаемую диагональ экрана");
                String screen = sc.nextLine();
                filter.put(5, screen);
                break;
            case "q" :
                break;
            default:
                System.out.println("символ выбора не найден");
        }
    }

    private static void putInSet(Set<Notebook> notebooks, Notebook nb) {
        if (!notebooks.contains(nb)){
            notebooks.add(nb);
        }else {
            notebooks.remove(nb);
            nb.addQty();
            notebooks.add(nb);
        }
    }
}
