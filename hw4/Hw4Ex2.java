/*
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
 */

import java.util.LinkedList;
import java.util.List;

public class Hw4Ex2 {
    public static void main(String[] args) {
        String text = "Java is a cross-platform object-oriented programming language that was released by " +
                "Sun Microsystems in the year 1995";
        LinkedList<String> words = new LinkedList<>(List.of(text.split(" ")));

        enqueue(words);
        dequeue(words);
        first(words);
    }

    private static void first(LinkedList<String> words) {
        words.getFirst();
    }

    private static void dequeue(LinkedList<String> words) {
        words.pollFirst();
    }

    private static void enqueue(LinkedList<String> words) {
        words.addLast(words.pollFirst());
    }
}
